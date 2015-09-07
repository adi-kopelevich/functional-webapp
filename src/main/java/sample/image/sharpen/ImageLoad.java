package sample.image.sharpen;

import java.util.concurrent.SynchronousQueue;

/**
 * Created by kopelevi on 07/09/2015.
 */
public class ImageLoad implements Runnable {

    private SynchronousQueue<String> loadedImagesQueue;

    public ImageLoad(SynchronousQueue<String> loadedImagesQueue) {
        this.loadedImagesQueue = loadedImagesQueue;
    }

    public void run() {
        for (String filename : ImageManagedList.getInstance().getFilenamesToProcess()) {
            if (!ImageManagedList.getInstance().alreadyProcessed(filename)) {
                byte[] imageBytes = loadImage(filename);
                try {
                    SharpenedImagesCache.getInstance().add(filename, imageBytes);
                    loadedImagesQueue.put(filename);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    private byte[] loadImage(String filename) {
        System.out.println("Loaded File: " + filename);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new byte[1];
    }
}
