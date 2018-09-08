package solutions.linkedlist;

import solutions.utility.LinkedListEngine;

/**
 * Created by hoducust on 2018/8/11 22H 11m .
 */
public class ReverseLinkedListII {

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode pre = dummy;
            int cnt = 0, tot = n - m + 1;
            while(--m > 0)
                pre = pre.next;
            ListNode tail = pre.next;
            ListNode tailHead = tail;
            ListNode need = tail.next;
            while(++cnt < tot && need != null) {
                tail.next = need.next;
                need.next = tailHead;
                tailHead = need;
                pre.next = need;
                need = tail.next;
            }
            return dummy.next;
        }
    }

    public static void main(String[] args) {

        LinkedListEngine.ListNode node = new LinkedListEngine().take(new int[]{1,2,3,4,5,6,7});

        System.out.println();
    }

}
