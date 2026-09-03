from collections import deque
class Solution:
 def longestSubarray(self,nums,limit):
  max_dq,min_dq=deque(),deque();left=ans=0
  for right in range(len(nums)):
   while max_dq and nums[max_dq[-1]]<nums[right]:max_dq.pop()
   max_dq.append(right)
   while min_dq and nums[min_dq[-1]]>nums[right]:min_dq.pop()
   min_dq.append(right)
   while nums[max_dq[0]]-nums[min_dq[0]]>limit:
    left+=1
    if max_dq[0]<left:max_dq.popleft()
    if min_dq[0]<left:min_dq.popleft()
   ans=max(ans,right-left+1)
  return ans
