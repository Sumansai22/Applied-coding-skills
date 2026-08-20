class Solution {
    public boolean isPalindrome(ListNode head) {
        // Use two pointers to find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head.next;

        // Move slow pointer one step and fast pointer two steps each iteration
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Split the list into two halves
        ListNode current = slow.next;
        slow.next = null;

        // Reverse the second half of the linked list
        ListNode previous = null;
        while (current != null) {
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }

        // Compare the first half with the reversed second half
        while (previous != null) {
            if (previous.val != head.val) {
                return false;
            }
            previous = previous.next;
            head = head.next;
        }

        return true;
    }
}
