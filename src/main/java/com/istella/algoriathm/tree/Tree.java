package com.istella.algoriathm.tree;

import java.util.Stack;

/**
 * @author liunan13
 * @date 2021/6/9
 * @description
 */
public class Tree {

    public static void main(String[] args){
        Integer[] vals={3,9,20,null,null,15,7};
        TreeNode node=initTree(vals,0);

        print(node);
    }

    private static TreeNode print(TreeNode node){
        if(node!=null) {
            System.out.println(node.val);
            print(node.left);
            print(node.right);
        }
        return node;
    }

    private static TreeNode initTree(Integer[] vals,int index){
        System.out.println("index:"+index);
        if (index>=vals.length)
            return null;
        TreeNode c=null;
        if(vals[index]!=null) {
            System.out.println("index "+index+",val "+vals[index]);
            c = new TreeNode(vals[index]);
            c.left=initTree(vals,2*index+1);
            c.right=initTree(vals,2*index+2);
        }
        return c;
    }

    public int maxDepth(TreeNode root) {

        return 0;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
