public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return convertListToBST(head, null);
    }
    
    private TreeNode convertListToBST(ListNode head, ListNode tail) {
        if (head == tail) return null;
        
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        TreeNode root = new TreeNode(slow.val);
        
        
        root.left = convertListToBST(head, slow);
        root.right = convertListToBST(slow.next, tail);
        
        return root;
    }
}
