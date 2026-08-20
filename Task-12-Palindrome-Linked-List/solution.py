class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        # Find the middle of the linked list using slow and fast pointers
        slow = head
        fast = head.next

        # Move slow pointer one step and fast pointer two steps each iteration
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        # Reverse the second half of the linked list
        previous = None
        current = slow.next

        while current:
            temp = current.next
            current.next = previous
            previous = current
            current = temp

        # Compare the first half with the reversed second half
        while previous:
            if previous.val != head.val:
                return False
            previous = previous.next
            head = head.next

        return True
