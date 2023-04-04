import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
//Time Complexity : O(2^N)
//Space Complexity : O(N)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Apply BFS on the string. Push the string to the queue. While queue is not
 * empty, pop the peek string and check if it is valid. If so, then push it to
 * the result list and mark found as true. This will filter all the other
 * strings of lesser length since the identified string would be the correct one
 * with minimum removals. If found is true, skip the next part of while loop.
 * Else, in the next part, iterate over the string and generate substrings
 * removing one char at a time and push them to the queue. Finally return the
 * list. For checking if it is a valid string, we have to see if any ) is before
 * (.
 *
 */
class Solution {
	public List<String> removeInvalidParentheses(String s) {
		List<String> ans = new ArrayList<>();
		if (s == null)
			return ans;
		Queue<String> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>();
		queue.add(s);
		visited.add(s);
		boolean found = false;
		while (!queue.isEmpty()) {
			String str = queue.poll();
			if (isValid(str)) {
				ans.add(str);
				found = true;
			}
			if (found)
				continue;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) != '(' && str.charAt(i) != ')')
					continue;
				String newStr = str.substring(0, i) + str.substring(i + 1);
				if (visited.contains(newStr))
					continue;
				visited.add(newStr);
				queue.add(newStr);
			}
		}
		return ans;
	}

	boolean isValid(String s) {
		int count = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(')
				count++;
			if (c == ')' && count-- == 0)
				return false;
		}

		return count == 0;
	}
}