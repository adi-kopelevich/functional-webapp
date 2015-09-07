package sample.image.sharpen;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by kopelevi on 07/09/2015.
 */
public class ImageSharpenExecutor {

    public static void main(String[] args) {

        SynchronousQueue loadedImagesQueue = new SynchronousQueue();
        SynchronousQueue sharpenedImagesQueue = new SynchronousQueue();

        new Thread(new ImageLoad(loadedImagesQueue)).start();
        new Thread(new ImageSave(sharpenedImagesQueue)).start();

        ExecutorService executor = Executors.newFixedThreadPool(16);
        for (int i = 0; i < 5; i++) {
            Runnable worker = new ImageSharpener(loadedImagesQueue, sharpenedImagesQueue);
            executor.execute(worker);
        }
        executor.shutdown();
    }
}
