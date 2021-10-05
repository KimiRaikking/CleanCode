package com.liv.algo.doublepoint;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateNodeDelete {


    public ListNode deleteDuplicates1(ListNode head){
        if (null == head) {
            return head;
        }
        ListNode dummyNode = new ListNode(-1,head);
        ListNode cur = dummyNode;
        Set<Integer> values = new HashSet<>();
        while(cur.next != null && cur.next.next != null){
            if(cur.next.val == cur.next.next.val){
                int value = cur.next.val;
                while(cur.next != null && cur.next.val == value){
                    cur.next = cur.next.next;
                }
            }else{
                cur = cur.next;
            }
        }
        return dummyNode.next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (null == head) {
            return head;
        }

        Set<Integer> values = new HashSet<>();
        ListNode shao = new ListNode(-1, head);
        ListNode pre = shao;
        ListNode cur = pre.next;
        while (cur != null) {

            if (values.contains(cur.val)) {
                // delete cur node
                cur = cur.next;
                pre.next = cur;
            } else {
                values.add(cur.val);
                ListNode nextNode = cur.next;
                if (null == nextNode) {
                    break;
                }
                boolean isDupNode = false;
                while(nextNode.val == cur.val){
                    isDupNode = true;
                    nextNode = nextNode.next;
                    if(null == nextNode){
                        break;
                    }
                }
                if (isDupNode) {
                    // delete cur node
                    cur = nextNode;
                    pre.next = cur;
                } else {
                    pre = cur;
                    cur = nextNode;
                }
            }
        }
        return shao.next;

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
