class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        mp, st = {}, []
        for x in nums2:
            while st and st[-1] < x:
                mp[st.pop()] = x
            st.append(x)
        while st:
            mp[st.pop()] = -1
        return [mp[x] for x in nums1]
