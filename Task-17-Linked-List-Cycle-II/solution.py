class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        fast_pointer = slow_pointer = head

        while fast_pointer and fast_pointer.next:
            slow_pointer = slow_pointer.next
            fast_pointer = fast_pointer.next.next

            if slow_pointer == fast_pointer:
                start_pointer = head

                while start_pointer != slow_pointer:
                    start_pointer = start_pointer.next
                    slow_pointer = slow_pointer.next

                return start_pointer

        return None
