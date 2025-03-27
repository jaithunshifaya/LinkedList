class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode ptr1 = dummy;

        
        for (int i = 1; i < left; i++) {
            ptr1 = ptr1.next;
        }

        ListNode start = ptr1.next;  
        ListNode curr = start.next;

        
        for (int i = 0; i < right - left; i++) {
            start.next = curr.next;
            curr.next = ptr1.next;
            ptr1.next = curr;
            curr = start.next;
        }

        return dummy.next;
    }
}
