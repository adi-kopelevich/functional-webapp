package sample.image.sharpen.actions;

import sample.image.sharpen.cache.SharpenedImagesCache;

import java.util.concurrent.BlockingQueue;

/**
 * Created by kopelevi on 07/09/2015.
 */
public class ImageSave implements Runnable {

    private volatile boolean stop = false;
    private final BlockingQueue<String> sharpenedImagesQueue;

    public ImageSave(BlockingQueue<String> sharpenedImagesQueue) {
        this.sharpenedImagesQueue = sharpenedImagesQueue;
    }

    public void run() {
        String filename = "";
        byte[] imageSharpenBytes = null;
        while (!stop) {
            try {
                filename = sharpenedImagesQueue.take();
                imageSharpenBytes = SharpenedImagesCache.getInstance().get(filename);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            saveImage(imageSharpenBytes, filename);
            SharpenedImagesCache.getInstance().remove(filename);
//            FileManagementFacade.getInstance().markComplete(filename);
        }
    }

    private void saveImage(byte[] imageBytes, String filename) {
        System.out.println("Saved File: " + filename + " - " + imageBytes[1]);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stopSave() {
        stop = true;
    }
}
