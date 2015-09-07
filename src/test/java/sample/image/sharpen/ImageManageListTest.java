package sample.image.sharpen;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sample.image.sharpen.fs.FileManagementFacade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kopelevi on 07/09/2015.
 */
public class ImageManageListTest {

//    public boolean alreadyProcessed(String filename);
//
//    public String[] getFilenamesToProcess();
//
//    public void markComplete(String filename) ;

    private FileManagementFacade files;

    @After
    public void tearDown() throws Exception {


    }

    @Before
    public void setUp() throws Exception {
        files = FileManagementFacade.getInstance();
        files.clear();
    }

    @Test
    public void whenMarkingCompletedFileIsNotRetrivable() throws Exception {
        Map<String, Boolean> initData = new HashMap<>();
        for (int i = 1; i <= 5; i++) {
            initData.put("file" + i + ".jpg", false);
        }
        files.loadFileData(initData);
        String fileName = "file4.jpg";
        Assert.assertTrue(files.getFilenamesToProcess().contains(fileName));
        files.markComplete(fileName);
        Assert.assertFalse(files.getFilenamesToProcess().contains(fileName));
    }

    @Test
    public void wheGetListOfFilesThenOnlyFilesThatPendingAreReturned() throws Exception {
        Map<String, Boolean> initData = new HashMap<>();
        for (int i = 1; i <= 5; i++) {
            initData.put("file" + i + ".jpg", false);
        }
        initData.put("file2.jpg", true);
        files.loadFileData(initData);
        List<String> pendingFiles = files.getFilenamesToProcess();
        Assert.assertEquals(4, pendingFiles.size());
        Assert.assertTrue(pendingFiles.contains("file1.jpg"));
        Assert.assertTrue(pendingFiles.contains("file3.jpg"));
        Assert.assertTrue(pendingFiles.contains("file4.jpg"));
        Assert.assertTrue(pendingFiles.contains("file5.jpg"));
    }
}
