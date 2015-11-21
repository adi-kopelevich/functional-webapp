package sample.image.sharpen.fs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by kopelevi on 07/09/2015.
 */
public class FileManagementFacade {

    private static final FileManagementFacade _INSATNCE = new FileManagementFacade();
    private static ConcurrentHashMap<String, Boolean> fileNamesStatus;

    private FileManagementFacade() {
        fileNamesStatus = new ConcurrentHashMap<String, Boolean>();
    }

    public static FileManagementFacade getInstance() {
        return _INSATNCE;
    }

    public void loadFileData(Map<String, Boolean> fileNamesStatus) {
        this.fileNamesStatus.putAll(fileNamesStatus);
    }
    public List<String> getFilenamesToProcess() {
        List<String> targetLongList = new ArrayList<>();
        fileNamesStatus.keySet().stream().filter(file -> !fileNamesStatus.get(file)).forEach(targetLongList::add);
        return targetLongList;
    }

    public void markComplete(String filename) {
        fileNamesStatus.put(filename, true);
    }

    public void clear() {
        fileNamesStatus.clear();
    }
}
