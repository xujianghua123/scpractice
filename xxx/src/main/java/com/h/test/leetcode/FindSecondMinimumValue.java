package com.h.test.leetcode;

import java.util.*;

public class FindSecondMinimumValue {

    public int findSecondMinimumValue(TreeNode root) {
        Set<Integer> nodeSet = this.nodeList(root, new HashSet<>());
        ArrayList<Integer> nodes = new ArrayList<>(nodeSet);
        Collections.sort(nodes);
        if(nodeSet.size() < 2){
            return -1;
        }
        return nodes.get(1);
    }

    private Set<Integer> nodeList(TreeNode root, Set<Integer> nodeSet){

        if(root == null){
            return nodeSet;
        }
        nodeSet.add(root.val);
        nodeList(root.left,nodeSet);
        nodeList(root.right,nodeSet);
        return nodeSet;
    }

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
}
