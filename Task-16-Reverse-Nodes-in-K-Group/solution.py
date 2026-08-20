class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        def reverse_linked_list(start_node: Optional[ListNode]) -> Optional[ListNode]:
            dummy_head = ListNode()
            current = start_node

            while current:
                next_temp = current.next
                current.next = dummy_head.next
                dummy_head.next = current
                current = next_temp

            return dummy_head.next

        dummy = ListNode(next=head)
        prev_group_tail = dummy

        while prev_group_tail:
            current = prev_group_tail

            for _ in range(k):
                current = current.next
                if current is None:
                    return dummy.next

            group_head = prev_group_tail.next
            next_group_head = current.next

            current.next = None
            prev_group_tail.next = reverse_linked_list(group_head)

            group_head.next = next_group_head
            prev_group_tail = group_head

        return dummy.next
