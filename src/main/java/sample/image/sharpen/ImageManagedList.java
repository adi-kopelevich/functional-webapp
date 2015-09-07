package sample.image.sharpen;

/**
 * Created by kopelevi on 07/09/2015.
 */
public class ImageManagedList {

    private static ImageManagedList _instance;
    private static String[] filenames;
    private static String[] status;
    private int lastProcessedIndex;

    private ImageManagedList() {
        filenames = new String[]{"file1.jpg", "file2.jpg", "file3.jpg", "file4.jpg", "file5.jpg"};
        status = new String[]{"false", "true", "false", "false", "false"};
        for (int i = 0; i < status.length; i++) {
            if (!Boolean.valueOf(status[i])) {
                break;
            }
            lastProcessedIndex++;
        }

    }

    public static ImageManagedList getInstance() {
        if (_instance == null) {
            _instance = new ImageManagedList();
        }
        return _instance;
    }

    public boolean alreadyProcessed(String filename){
        for (int i = 0; i < filenames.length; i++) {
            if (filenames[i].equals(filename)) {
                return Boolean.valueOf(status[i]);
            }
        }
        return false;
    }

    public String[] getFilenamesToProcess(){
        return filenames.clone();
    }

    public void markComplete(String filename) {
        for (int i = 0; i < status.length; i++) {
            if (filenames[i].equals(filename)) {
                status[i] = "true";
                break;
            }
        }
    }
}
