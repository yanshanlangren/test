package elvis.leetcode;


public class ReverseBetween {
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

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for(int i = 1; i < m; i++){
            pre = pre.next;
        }
        head = pre.next;
        for(int i = m; i < n; i++){
            ListNode nex = head.next;
            head.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ReverseBetween r = new ReverseBetween();
//        ListNode l = r.reverseBetween(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2, 4);
        ListNode l = r.reverseBetween(new ListNode(5), 1, 1);
        System.out.println(l);
    }
}
