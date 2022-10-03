import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// Time Complexity : O(n power k) where n = number of substrings at each level, k = number of levels
// Space Complexity : O(n power k) where n = number of substrings at each level, k = number of levels
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//301. Remove Invalid Parentheses (Hard) - https://leetcode.com/problems/remove-invalid-parentheses/
// Time Complexity : O(n power k) where n = number of substrings at each level, k = number of levels
// Space Complexity : O(n power k) where n = number of substrings at each level, k = number of levels
// BFS Approach
//class Solution {
//    public List<String> removeInvalidParentheses(String s) {
//        List<String> result = new ArrayList<>();
//        if (s == null || s.length() == 0) return result;
//        
//        Set<String> set = new HashSet<>();
//        set.add(s);
//        
//        Queue<String> queue = new LinkedList<>();
//        queue.add(s);
//        
//        boolean flag = false;
//        
//        while (!queue.isEmpty() && !flag) {
//            int size = queue.size();
//            
//            for (int i = 0; i < size; i++) {
//                String curr = queue.poll();
//                
//                if (isValid(curr)) { // if string is valid, make flag as true to mark that we have got the result at that level
//                    flag = true;
//                    result.add(curr);
//                } else { // check if the flag is false, if false create substrings and add them to set and queue if not present in set
//                    if (!flag) {
//                        for (int j = 0; j < curr.length(); j++) {
//                            String child = curr.substring(0, j) + curr.substring(j+1);
//                            
//                            if (!set.contains(child)) {
//                                set.add(child);
//                                queue.add(child);
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        
//        return result;
//    }
//    
//    private boolean isValid(String s) {
//        int count = 0;
//        
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            
//            if (ch == '(') count++;
//            else if (ch == ')') {
//                if (count == 0) return false;
//                count--;
//            }
//        }
//        
//        return count == 0;
//    }
//}

// DFS Approach
//Time Complexity : O(n power k) where n = number of substrings at each level, k = number of levels
//Space Complexity : O(n power k) where n = number of substrings at each level, k = number of levels
class Solution {

	List<String> result;
	Set<String> set;
	int max;

	public List<String> removeInvalidParentheses(String s) {
		result = new ArrayList<>();
		max = 0;
		if (s == null || s.length() == 0)
			return result;

		set = new HashSet<>();
		set.add(s);
		dfs(s);

		return result;
	}

	private void dfs(String s) {
		// base
		if (s.length() < max)
			return;

		if (isValid(s)) {
			if (s.length() > max) {
				result = new ArrayList<>();
				max = s.length();
			}
			result.add(s);
			return;
		}

		// logic
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (Character.isLetter(ch))
				continue;
			String child = s.substring(0, i) + s.substring(i + 1);

			if (!set.contains(child)) {
				set.add(child);
				dfs(child);
			}
		}
	}

	private boolean isValid(String s) {
		int count = 0;

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (ch == '(')
				count++;
			else if (ch == ')') {
				if (count == 0)
					return false;
				count--;
			}
		}

		return count == 0;
	}
}