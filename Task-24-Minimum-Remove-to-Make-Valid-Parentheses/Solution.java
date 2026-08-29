import java.util.*;

class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> remove = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') stack.push(i);
            else if (c == ')') {
                if (!stack.isEmpty()) stack.pop();
                else remove.add(i);
            }
        }
        while (!stack.isEmpty()) remove.add(stack.pop());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
            if (!remove.contains(i)) result.append(s.charAt(i));
        return result.toString();
    }
}
