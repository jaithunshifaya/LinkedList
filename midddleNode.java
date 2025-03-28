import java.util.LinkedList;

class Solution {
    public ListNode middleNode(ListNode head) {
        @SuppressWarnings("unused")
        LinkedList<Integer>list=new LinkedList<>();
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
        
    }
}