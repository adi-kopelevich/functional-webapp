package sample.binary.tree;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by kopelevi on 01/09/2015.
 */
public class TreeNodeCalculatorTest {

    TreeNodeCalculator treeNodecalCalculator;

    @Before
    public final void init() {
        treeNodecalCalculator = new TreeNodeCalculator();
    }

    @After
    public final void tearDown() {
        treeNodecalCalculator = null;
    }

    @Test
    public final void whenGivenBinaryIntTreeThenReurnMaxSumPath() {
        TreeNode leftTreeNode = new TreeNode(-2, new TreeNode(8, null, null), new TreeNode(-4, null, null));
        TreeNode rightTreeNode = new TreeNode(7,null, null);
        TreeNode rootTreeNode = new TreeNode(10, leftTreeNode, rightTreeNode);
        Assert.assertEquals(treeNodecalCalculator.findMaxPath(rootTreeNode), 17);
    }

}
