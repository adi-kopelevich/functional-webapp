package sample.image.sharpen;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kopelevi on 07/09/2015.
 */
public class SharpenedImagesCache {

    private static Map<String, Object> sharpenedImagesMap;
    private static SharpenedImagesCache _instance;

    private SharpenedImagesCache() {
        this.sharpenedImagesMap = new HashMap<>();
    }

    public static synchronized SharpenedImagesCache getInstance() {
        if (_instance == null) {
            _instance = new SharpenedImagesCache();
        }
        return _instance;
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
