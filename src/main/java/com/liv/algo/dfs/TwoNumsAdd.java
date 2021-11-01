package com.liv.algo.dfs;

import java.util.Optional;

public class TwoNumsAdd {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode();
        dfs(l1, l2, root, 0);
        return root;
    }

    private void dfs(ListNode l1, ListNode l2, ListNode target, int incr) {
        target.val += incr;
        if (null != l1) {
            target.val += l1.val;
        }
        if (null != l2) {
            target.val += l2.val;
        }
        int nextIncr = 0;
        if (target.val >= 10) {
            target.val = target.val % 10;
            nextIncr = 1;
        }
        if ((null != l1 && null != l1.next) || (null != l2 && null != l2.next) || nextIncr > 0) {
            ListNode child = new ListNode();
            target.next = child;
            dfs(null == l1 ? null : l1.next, null == l2 ? null : l2.next, child, nextIncr);
        }
    }


    public class ListNode {
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
