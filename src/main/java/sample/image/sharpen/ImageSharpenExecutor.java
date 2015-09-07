package sample.image.sharpen;

import sample.image.sharpen.actions.ImageLoad;
import sample.image.sharpen.actions.ImageSave;
import sample.image.sharpen.actions.ImageSharpener;
import sample.image.sharpen.fs.FileManagementFacade;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by kopelevi on 07/09/2015.
 */
public class ImageSharpenExecutor {

    public static void main(String[] args) {

        Map<String, Boolean> initData = new HashMap<>();
        for (int i = 1; i <= 10; i++) {
            initData.put("file" + i + ".jpg", false);
        }
        initData.put("file2.jpg", true);
        FileManagementFacade.getInstance().loadFileData(initData);

        SynchronousQueue loadedImagesQueue = new SynchronousQueue();
        SynchronousQueue sharpenedImagesQueue = new SynchronousQueue();

        new Thread(new ImageLoad(loadedImagesQueue)).start();
        new Thread(new ImageSave(sharpenedImagesQueue)).start();

        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            Runnable worker = new ImageSharpener(loadedImagesQueue, sharpenedImagesQueue);
            executor.execute(worker);
        }
        executor.shutdown();
    }
}
