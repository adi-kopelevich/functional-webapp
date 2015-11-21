package sample.image.sharpen.actions;

import sample.image.sharpen.fs.FileManagementFacade;
import sample.image.sharpen.cache.SharpenedImagesCache;

import java.util.concurrent.SynchronousQueue;

/**
 * Created by kopelevi on 07/09/2015.
 */
public class ImageSave implements Runnable {

    private final SynchronousQueue<String> sharpenedImagesQueue;

    public ImageSave(SynchronousQueue<String> sharpenedImagesQueue) {
        this.sharpenedImagesQueue = sharpenedImagesQueue;
    }

    public void run() {
        String filename = "";
        byte[] imageSharpenBytes = null;
        while (true) {
            try {
                filename = sharpenedImagesQueue.take();
                imageSharpenBytes = SharpenedImagesCache.getInstance().get(filename);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            saveImage(imageSharpenBytes, filename);
            SharpenedImagesCache.getInstance().remove(filename);
            FileManagementFacade.getInstance().markComplete(filename);
        }
    }

    private void saveImage(byte[] imageBytes, String filename) {
        System.out.println("Saved File: " + filename + " - "+imageBytes[1]);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
