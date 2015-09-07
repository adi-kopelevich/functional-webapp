package sample.image.sharpen.fs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kopelevi on 07/09/2015.
 */
public class FileManagementFacade {

    private static FileManagementFacade _instance;
    private static Map<String, Boolean> fileNamesStatus ;

    private FileManagementFacade() {
        fileNamesStatus = new HashMap<>();
    }

    public void loadFileData(Map<String, Boolean> fileNamesStatus) {
        this.fileNamesStatus.putAll(fileNamesStatus);
    }

    public static FileManagementFacade getInstance() {
        if (_instance == null) {
            _instance = new FileManagementFacade();
        }
        return _instance;
    }

    public List<String> getFilenamesToProcess() {
        List<String> targetLongList = new ArrayList<>();
        fileNamesStatus.keySet().stream().filter(file -> !fileNamesStatus.get(file)).forEach(targetLongList::add);
        return targetLongList;
    }

    public void markComplete(String filename) {
        fileNamesStatus.put(filename, true);
    }

    public void clear(){
        fileNamesStatus.clear();
    }
}
