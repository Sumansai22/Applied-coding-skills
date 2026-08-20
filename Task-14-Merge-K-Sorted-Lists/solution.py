import heapq

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        setattr(ListNode, "__lt__", lambda self, other: self.val < other.val)

        priority_queue = [head for head in lists if head]
        heapq.heapify(priority_queue)

        dummy_head = ListNode()
        current_node = dummy_head

        while priority_queue:
            min_node = heapq.heappop(priority_queue)

            if min_node.next:
                heapq.heappush(priority_queue, min_node.next)

            current_node.next = min_node
            current_node = current_node.next

        return dummy_head.next
