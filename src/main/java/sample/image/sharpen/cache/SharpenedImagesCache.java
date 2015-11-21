package sample.image.sharpen.cache;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by kopelevi on 07/09/2015.
 */
public class SharpenedImagesCache {


    private static final SharpenedImagesCache _INSTANCE = new SharpenedImagesCache();
    private static ConcurrentHashMap<String, Object> sharpenedImagesMap;

    private SharpenedImagesCache() {
        this.sharpenedImagesMap = new ConcurrentHashMap<>();
    }

    public static synchronized SharpenedImagesCache getInstance() {
        return _INSTANCE;
    }
    public void add(String filename, byte[] sharpenedImageBytes) {
        sharpenedImagesMap.put(filename, sharpenedImageBytes);
    }

    public byte[] get(String filename) {
        return (byte[]) sharpenedImagesMap.get(filename);
    }

    public void remove(String filename) {
        sharpenedImagesMap.remove(filename);
    }

}
