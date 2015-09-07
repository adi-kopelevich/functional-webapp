package sample.image.sharpen;

import java.util.concurrent.SynchronousQueue;

/**
 * Created by kopelevi on 07/09/2015.
 */
public class ImageSharpener implements Runnable {

    private SynchronousQueue<String> loadedImagesQueue;
    private SynchronousQueue<String> sharpenedImagesQueue;

    public ImageSharpener(SynchronousQueue<String> loadedImagesQueue, SynchronousQueue<String> sharpenedImagesQueue) {
        this.loadedImagesQueue = loadedImagesQueue;
        this.sharpenedImagesQueue = sharpenedImagesQueue;
    }

    public void run() {
        String filename = "";
        byte[] imageBytes = new byte[0];
        try {
            filename = loadedImagesQueue.take();
            imageBytes = SharpenedImagesCache.getInstance().get(filename);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        byte[] imageSharpenBytes = sharpenImage(imageBytes, filename);
        try {
            SharpenedImagesCache.getInstance().add(filename, imageSharpenBytes);
            sharpenedImagesQueue.put(filename);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private byte[] sharpenImage(byte[] imageBytes, String filename) {
        System.out.println("Sharpen " + filename);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return imageBytes;
    }
}
