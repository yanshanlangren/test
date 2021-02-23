package elvis.leetcode;


public class AddTwoNumbers {
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

    void print(ListNode head) {
        ListNode cursor = head;
        do {
            System.out.print(cursor.val);
            cursor = cursor.next;
        } while (cursor != null);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode cursor = head;
        int pls = 0;
        while (l1 != null && l2 != null) {
            cursor.next = new ListNode();
            cursor = cursor.next;

            int val = l1.val + l2.val + pls;
            cursor.val = val % 10;
            pls = val / 10;

            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null) {
            cursor.next = l1;
        }
        if (l2 != null) {
            cursor.next = l2;
        }
        while (cursor.next != null) {
            cursor = cursor.next;
            int val = cursor.val + pls;
            cursor.val = val % 10;
            pls = val / 10;
        }
        if (pls == 1) {
            cursor.next = new ListNode(1, null);
        }
        return head.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers tn = new AddTwoNumbers();
//        ListNode l1 = new ListNode(0, null);
//        ListNode l2 = new ListNode(0, null);

        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));

//        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, null)));
//        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null)))));
        tn.print(tn.addTwoNumbers(l1, l2));
    }
}
