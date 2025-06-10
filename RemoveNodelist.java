class Solution {
    public ListNode removeNodes(ListNode head) {
        head = reverseList(head);

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = head;
        int max = current.val;

        while (current != null && current.next != null) {
            if (current.next.val < max) {
                current.next = current.next.next;
            } else {
                current = current.next;
                max = current.val;
            }
        }

        return reverseList(dummy.next);
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode nextTemp = head.next;
            head.next = prev;
            prev = head;
            head = nextTemp;
        }
        return prev;
    }
}
