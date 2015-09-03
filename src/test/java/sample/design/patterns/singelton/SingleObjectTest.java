package sample.design.patterns.singelton;

import junit.framework.Assert;
import org.junit.Test;
import sample.design.patterns.singleton.SingleObject;

/**
 * Created by kopelevi on 03/09/2015.
 */
public class SingleObjectTest {

    @Test
    public void whenCallingGetInstanceSeveralTimesThenSameInstanceIsReturned() throws Exception {
        SingleObject obj1 = SingleObject.getInstance();
        SingleObject obj2 = SingleObject.getInstance();
        Assert.assertEquals(obj1, obj2);
    }
}
