public class LinkedListCycle {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
        }
    }
    public static ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head.next;

        while(slow != null && fast != null && fast.next != null && slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
            System.out.println("slow: " + slow.val);
            System.out.println("fast: " + fast.val);
        }

        System.out.println("slow: " + slow.val);
        System.out.println("fast: " + fast.val);

        if (slow != null && fast != null && fast.next != null && slow == fast) {
            fast = head;
            while(slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        System.out.println(detectCycle(node));
    }
}
