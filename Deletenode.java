class Solution {
    public void deleteNode(ListNode node) {
        ListNode curr=node;
        ListNode next=node;
        curr.val=curr.next.val;
        curr.next=curr.next.next;
        
    }
}