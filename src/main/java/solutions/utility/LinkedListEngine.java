package solutions.utility;

/**
 * Created by hoducust on 2018/8/11 22H 16m .
 */
public class LinkedListEngine {

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

    public ListNode take(int[] listSeed) {

        if (listSeed == null || listSeed.length == 0) {
            return null;
        }
        ListNode head = new ListNode(listSeed[0]);
        ListNode curr = head;
        for (int i = 1; i < listSeed.length; i++) {
            curr.next = new ListNode(listSeed[i]);
            curr = curr.next;
        }
        return head;
    }
}
