public class AddTwoNumbers {
    public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode current = root;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int x = (l1 != null)? l1.val : 0;
            int y = (l2 != null)? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return root.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        int rootVal = l1.val + l2.val;
        int inc = rootVal / 10;
        rootVal = rootVal % 10;
        ListNode root = new ListNode(rootVal);
        l1 = l1.next;
        l2 = l2.next;
        ListNode next = root;
        while(l1 != null && l2 != null) {
            rootVal = l1.val + l2.val + inc;
            inc = rootVal / 10;
            rootVal = rootVal % 10;
            next.next = new ListNode(rootVal);
            next = next.next;

            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null) {
            l1.val += inc;
            inc = l1.val / 10;
            l1.val = l1.val % 10;
            next.next = l1;
            next = next.next;
            l1 = l1.next;
        }
        while(l2 != null) {
            l2.val += inc;
            inc = l2.val / 10;
            l2.val = l2.val % 10;
            next.next = l2;
            next = next.next;
            l2 = l2.next;
        }
        if (inc != 0) {
            next.next = new ListNode(inc);
        }

        return root;
    }

    public static final void main(String[] args) {
        AddTwoNumbers c = new AddTwoNumbers();
        c.test();
    }

    private void print(ListNode p) {
         while (p != null) {
             System.out.print(p.val + " -> ");
             p = p.next;
         }
    }

    private void test() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        print(addTwoNumbers2(l1, l2));
    }
}
