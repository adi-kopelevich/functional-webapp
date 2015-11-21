package sample.image.sharpen;

import sample.image.sharpen.actions.ImageLoad;
import sample.image.sharpen.actions.ImageSave;
import sample.image.sharpen.actions.ImageSharpener;
import sample.image.sharpen.fs.FileManagementFacade;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by kopelevi on 07/09/2015.
 */
public class ImageSharpenExecutor {

    public static void main(String[] args) throws InterruptedException {

        final int numberOfFiles = 10;

        Map<String, Boolean> initData = new HashMap<>();
        for (int i = 0; i < numberOfFiles; i++) {
            initData.put("file" + i + ".jpg", false);
        }
//        initData.put("file2.jpg", true);

        long startTime = System.currentTimeMillis();
        FileManagementFacade.getInstance().loadFileData(initData);

        BlockingQueue loadedImagesQueue = new ArrayBlockingQueue<String>(5);
        BlockingQueue sharpenedImagesQueue = new ArrayBlockingQueue<String>(5);

        Thread imageLoadThread = new Thread(new ImageLoad(loadedImagesQueue));
        imageLoadThread.setDaemon(true);
        imageLoadThread.start();

        Thread imageSaveThread = new Thread(new ImageSave(sharpenedImagesQueue));
        imageSaveThread.setDaemon(true);
        imageSaveThread.start();

        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < numberOfFiles; i++) {
            Runnable worker = new ImageSharpener(loadedImagesQueue, sharpenedImagesQueue);
            executor.execute(worker);
        }
        executor.shutdown();
        boolean finshiedOnTime = executor.awaitTermination(5, TimeUnit.SECONDS);

        long endTime = System.currentTimeMillis();
        if(finshiedOnTime){
            System.out.println("Total Execution Time [ms]: " + String.valueOf(endTime - startTime));
        }else{
            System.out.println("Aborted after timeout... ");
        }


    }
}
