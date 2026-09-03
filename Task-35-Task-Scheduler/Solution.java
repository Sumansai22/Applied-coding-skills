import java.util.*;
class Solution {
 public int leastInterval(char[] tasks,int n){int[] freq=new int[26];for(char c:tasks)freq[c-'A']++;Arrays.sort(freq);int maxFreq=freq[25],maxCount=0;for(int f:freq)if(f==maxFreq)maxCount++;return Math.max(tasks.length,(maxFreq-1)*(n+1)+maxCount);}
}
