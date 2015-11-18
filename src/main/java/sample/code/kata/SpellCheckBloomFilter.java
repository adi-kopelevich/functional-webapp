package sample.code.kata;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by kopelevi on 18/11/2015.
 */
public class SpellCheckBloomFilter {

    private final Set<String> wordSet; //not thread safe --> replace with ConcurentHashMap impl for multi-threaded use
    private final BitSet bitSet;//not thread safe --> replace with "AtomicBitSet" based on AtomicIntegerArray  impl for multi-threaded use
    private static final int NUMBER_OF_HASH_FUNC = 2;
    private final int BLOOM_FILTER_SIZE;

    public SpellCheckBloomFilter(int numberOfWords) {
        BLOOM_FILTER_SIZE = new Double(Math.floor(NUMBER_OF_HASH_FUNC / Math.log(2) * numberOfWords)).intValue();
        wordSet = new HashSet<>(numberOfWords);
        bitSet = new BitSet(BLOOM_FILTER_SIZE);
    }

    public void addWordToDic(String word) {
        String wordClean = word.trim().toLowerCase();
        // calc hash
        int hashForBitSet = getHashId(wordClean);
        // updated bitset with val from hash
        bitSet.set(hashForBitSet);
        wordSet.add(wordClean);
    }

    public boolean isValidWord(String word) {
        String wordClean = word.trim().toLowerCase();
        // calc hash
        int hashForBitSet = getHashId(wordClean);
        // query bitset with val from hash1 and hash2
        if (!bitSet.get(hashForBitSet)) {
            System.out.println(wordClean + " doesn't exists in bit set!");
            return false;
        } else {
            System.out.println(wordClean + " exists in bit set!");
            return wordSet.contains(wordClean);
        }

    }

    private int getHashId(String word) {
        int hashCode = word.hashCode() % BLOOM_FILTER_SIZE;
        return hashCode > 0 ? hashCode : hashCode * -1;

    }

}
