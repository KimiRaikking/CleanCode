package com.liv.test.algo.tree.btree;

import com.liv.algo.tree.btree.BinaryTreeBuild;
import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeBuildTest {

    private BinaryTreeBuild binaryTreeBuild = new BinaryTreeBuild();

    @Test
    public void test(){
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        BinaryTreeBuild.TreeNode root = binaryTreeBuild.buildTree(preorder,inorder);
        Assert.assertEquals(3,root.getVal());
    }
}
