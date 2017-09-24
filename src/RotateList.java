public class RotateList {
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    public ListNode rotateRight(ListNode head, int k) {
        int len = getLength(head);
        if(len <= 1) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        k = k % len;
        int next = len - k;
        ListNode tail = dummy;
        for (int i = 0; i < next; i++) {
            head = head.next;
            tail = tail.next;
        }
        ListNode tempHead = head;
        if (tempHead != null) {
            while(head.next != null) {
                head = head.next;
            }
            head.next = dummy.next;
            dummy.next = tempHead;
            tail.next = null;
        } else {
            return dummy.next;
        }

        return dummy.next;
    }

    private int getLength(ListNode head) {
         if (head == null) {
             return 0;
         }
         int n = 1;
         while (head.next != null) {
             head = head.next;
             n++;
         }

         return n;
    }
}
