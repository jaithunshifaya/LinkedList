import java.util.HashSet;
import java.util.Set;

class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        
        ListNode prev = dummy;
        ListNode curr = head;
        while (curr != null) {
            if (numSet.contains(curr.val)) {
                
                prev.next = curr.next;
            } else {
                
                prev = curr;
            }
            curr = curr.next;
        }

        return dummy.next;
    }
}
