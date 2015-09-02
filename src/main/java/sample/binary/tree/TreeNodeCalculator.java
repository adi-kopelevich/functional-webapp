package sample.binary.tree;

/**
 * Created by kopelevi on 01/09/2015.
 */
public class TreeNodeCalculator {

    public int findMaxPath(TreeNode node){

        if(node == null){
            return 0;
        }

        return node.getVal() + Math.max(findMaxPath(node.getLeft()), findMaxPath(node.getRight()));
    }

}
