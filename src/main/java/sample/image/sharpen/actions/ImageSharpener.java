package sample.image.sharpen.actions;

import sample.image.sharpen.cache.SharpenedImagesCache;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * Created by kopelevi on 07/09/2015.
 */
public class ImageSharpener implements Runnable {

    private final BlockingQueue<String> loadedImagesQueue;
//    private final BlockingQueue<String> sharpenedImagesQueue;

    public ImageSharpener(BlockingQueue<String> loadedImagesQueue, BlockingQueue<String> sharpenedImagesQueue) {
        this.loadedImagesQueue = loadedImagesQueue;
//        this.sharpenedImagesQueue = sharpenedImagesQueue;
    }

    public void run() {
        String filename = "";
        byte[] imageBytes = null;
        try {
            filename = loadedImagesQueue.take();
            imageBytes = SharpenedImagesCache.getInstance().get(filename);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        byte[] imageSharpenBytes = sharpenImage(imageBytes, filename);
//        try {
//            SharpenedImagesCache.getInstance().add(filename, imageSharpenBytes);
//            sharpenedImagesQueue.put(filename);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }


    private byte[] sharpenImage(byte[] imageBytes, String filename) {

        try {
            Thread.sleep((int)Math.random()*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Random().nextBytes(imageBytes);
        System.out.println("Sharpened " + filename + " - " + imageBytes[1]);
        return imageBytes;
    }
}
