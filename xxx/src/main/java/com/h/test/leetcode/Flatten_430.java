package com.h.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
* @Description:
 * 多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 *
 * 给你位于列表第一级的头节点，请你扁平化列表，使所有结点出现在单级双链表中。
 *
* @Author: xujianghua
* @Date: 2021/9/24 10:38
*/
public class Flatten_430 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };

    public Node flatten(Node head) {
        Node node = head;
        List<Node> nodes = new ArrayList<>();
        flatten(head,nodes);
        for(int i = 1;i<nodes.size();i++){
            node.next = nodes.get(i);
            nodes.get(i).prev = node;
            node = node.next;
        }
        return head;
    }

    private void flatten(Node root,List<Node> nodes){
        while (root != null){
            nodes.add(root);
            if(root.child != null){
                flatten(root.child,nodes);
                root.child = null;
            }
            root = root.next;
        }
    }



/*
    public Node flatten(Node head) {
        if(head == null){
            return head;
        }
        ArrayList<Integer> values = new ArrayList<>();
        flatten(head,values);
        Node resNode = new Node();

        resNode.val = values.get(0);
        Node cur = resNode;
        for(int i = 1;i < values.size();i++){
            Node node = new Node();
            node.val = values.get(i);
            cur.next = node;
            node.prev = cur;
            cur = node;
        }
        return resNode;
    }

    private void flatten(Node root,ArrayList<Integer> values){
        while (root != null){
            values.add(root.val);
            if(root.child != null){
                flatten(root.child,values);
            }
            root = root.next;
        }
    }

    */

}
