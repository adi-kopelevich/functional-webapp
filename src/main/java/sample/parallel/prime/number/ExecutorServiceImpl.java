package sample.parallel.prime.number;

import java.util.concurrent.*;

/**
 * Created by kopelevi on 16/11/2015.
 */
public class ExecutorServiceImpl implements PrimeNumChecker {

    public boolean isPrime(final int n) {
        int parallelFactor = Runtime.getRuntime().availableProcessors();
        int chunkSize = n / parallelFactor + 1;
        int chunkCounter = 0;
        boolean isPrime = true;
        if (n <= 0) {
            throw new IllegalArgumentException("Expected positive number, given: " + n);
        }
        Future[] futures = new Future[parallelFactor];
        java.util.concurrent.ExecutorService executorService = Executors.newFixedThreadPool(parallelFactor);
        for (int i = 2; i < n; i = i + chunkSize) {
            final int fromIndex = i;
            final int toIndex = Math.min(i + chunkSize, n);

            futures[chunkCounter] = executorService.submit(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    boolean isChunkPrime = true;
                    for (int j = fromIndex; j < toIndex; j++) {
                        if (n % j == 0) {
                            isChunkPrime = false;
                            break;
                        }
                    }
                    return isChunkPrime;
                }
            });
            chunkCounter++;
        }
        executorService.shutdown();
        // iterate over response
        for (int i = 0; i < chunkCounter; i++) {
            try {
                boolean isChunkPrime = (Boolean) futures[i].get();
                if (!isChunkPrime) {
                    isPrime = false;
                    break;
                }
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException("Failed to calculate is prime for: " + n, e);
            }
        }
        return isPrime;
    }
}
