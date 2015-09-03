package sample.design.patterns.iterator;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by kopelevi on 03/09/2015.
 */
public class NameContainerTest {

    @Test
    public void whenNotLastObjHasNextThenReturnTrue() throws Exception {
        NameContainer nameCont = new NameContainer("Avi", "Eli", "Moshe");
        Assert.assertEquals(true, nameCont.hasNext());
        Assert.assertEquals("Avi", nameCont.next());
        Assert.assertEquals(true, nameCont.hasNext());
        Assert.assertEquals("Eli", nameCont.next());
        Assert.assertEquals(true, nameCont.hasNext());
        Assert.assertEquals("Moshe", nameCont.next());
        Assert.assertEquals(false, nameCont.hasNext());
    }
}
