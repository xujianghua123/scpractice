package com.h.test.leetcode;

public class PathSum_437 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int sum = 0;
    public int pathSum(TreeNode root, int targetSum) {

        return 0;
    }

    public void pathSum(TreeNode root,TreeNode cur,int total, int targetSum) {
        if(cur == null) return;

        if(total + cur.val == targetSum){
            sum++;
        }

    }
}
