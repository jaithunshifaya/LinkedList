class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast= head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode secondReversedHalf=reverse(slow);
        ListNode firstHalf=head;
        while(secondReversedHalf != null){
            if(firstHalf.val != secondReversedHalf.val){
                return false;
            }
            firstHalf=firstHalf.next;
            secondReversedHalf=secondReversedHalf.next;
        }
        return true;
        
    }
    static ListNode reverse(ListNode head){
        if(head==null){
            return head;
        }
        ListNode prev=null;
        ListNode curr=head;
        ListNode next=curr.next;
        while(curr!=null){
            curr.next=prev;
            prev=curr;
            curr=next;
            if(next!=null){
                next=next.next;
            }
        }
        return prev;
    }
}