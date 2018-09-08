package solutions.linkedlist;

/**
 * Created by hoducust on 2018/8/11 14H 11m .
 */
public class ReverseLinkedList {

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
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode pre = null;
            ListNode curr = head;

            while (curr != null) {
                ListNode next = curr.next;
                head.next = pre;
                pre = curr;
                curr = next;
            }

            return pre;
        }
    }

}
