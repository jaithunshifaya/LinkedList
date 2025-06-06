import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    // Deserialize a string like "[7,2,4,3]" into a linked list
    public static ListNode deserialize(String data) {
        data = data.replaceAll("[\\[\\]\\s]", "");
        if (data.isEmpty()) return null;

        String[] parts = data.split(",");
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (String part : parts) {
            curr.next = new ListNode(Integer.parseInt(part));
            curr = curr.next;
        }
        return dummy.next;
    }

    // Print the linked list in [x, y, z] format
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode curr = this;
        sb.append("[");
        while (curr != null) {
            sb.append(curr.val);
            if (curr.next != null) sb.append(", ");
            curr = curr.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode head = null;

        while (!s1.isEmpty() || !s2.isEmpty() || carry > 0) {
            int sum = carry;

            if (!s1.isEmpty()) sum += s1.pop();
            if (!s2.isEmpty()) sum += s2.pop();

            ListNode newNode = new ListNode(sum % 10);
            newNode.next = head;
            head = newNode;

            carry = sum / 10;
        }

        return head;
    }
}

public class Main {
    public static void main(String[] args) {
        ListNode l1 = ListNode.deserialize("[7,2,4,3]");
        ListNode l2 = ListNode.deserialize("[5,6,4]");

        Solution sol = new Solution();
        ListNode result = sol.addTwoNumbers(l1, l2);

        System.out.println("Result: " + result); // Expected: [7, 8, 0, 7]
    }
}
