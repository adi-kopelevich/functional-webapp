package sample.multi.threading;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * Created by kopelevi on 10/11/2015.
 */
public class ConcurentHashMapIteration {

    public static void main(String[] args) {
        final ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<String, String>();

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10000; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    String key = String.valueOf("Key" + new Random().nextInt(10));
                    String value = String.valueOf("Value" + new Random().nextInt(10));
                    concurrentHashMap.put(key, value);
                    ConcurrentHashMap.KeySetView<String, String> keySetView = concurrentHashMap.keySet();
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    List<String> values = keySetView.stream()
                            .map(concurrentHashMap::get)
                            .collect(Collectors.toList());
                    System.out.println(values);
                }
            });
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    String key = String.valueOf("Key" + new Random().nextInt(10));
                    concurrentHashMap.remove(key);
                    List<String> values = concurrentHashMap.keySet().stream()
                            .map(concurrentHashMap::get)
                            .collect(Collectors.toList());
                    System.out.println("Key " + key + " was removed");
                }
            });
        }
        executorService.shutdown();

    }
}
