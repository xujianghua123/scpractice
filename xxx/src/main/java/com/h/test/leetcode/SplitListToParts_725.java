package com.h.test.leetcode;

import org.junit.Test;

public class SplitListToParts_725 {


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    @Test
    public void test(){

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        System.out.println(splitListToParts(head,5).length);
    }


    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = 1;
        ListNode listNode = head;
        while (listNode.next != null){
            listNode = listNode.next;
            size++;
        }
        ListNode curNode = head;
        ListNode[] resNode = new ListNode[k];
        for(int i = 0;i < k && curNode != null;i++){
            resNode[i] = curNode;
            int curSize = size % k > i ? (size/k + 1)  : size/k;
            for(int j = 0;j < curSize - 1 ;j++){
                curNode = curNode.next;
            }
            ListNode nextNode = curNode.next;
            curNode.next = null;
            curNode = nextNode;
        }
        return resNode;
    }

}
