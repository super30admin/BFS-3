// Time Complexity : O(n^n) - worst case, n -> Length of string
// Space Complexity : O(n*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RemoveInvalidParentheses {
	List<String> ans;
	Set<String> ansSet;
	int max;

	/********************* BFS *********************/
	public List<String> removeInvalidParentheses(String s) {
		ans = new ArrayList<>();

		if (s == null || s.length() == 0) {
			return ans;
		}

		ansSet = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		boolean found = false;

		queue.add(s);

		while (!queue.isEmpty() && !found) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				String str = queue.poll();

				if (isValid(str)) {
					found = true;
					ans.add(str);
				} else {
					if (!found) {
						for (int j = 0; j < str.length(); j++) {
							if (Character.isLetter(str.charAt(j))) {
								continue;
							}
							String child = str.substring(0, j) + str.substring(j + 1);
							if (!ansSet.contains(child)) {
								queue.add(child);
								ansSet.add(child);
							}
						}
					}
				}
			}
		}
		return ans;
	}

	private boolean isValid(String s) {
		int cnt = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				cnt--;
			} else if (s.charAt(i) == '(') {
				cnt++;
			}

			if (cnt < 0) {
				return false;
			}
		}

		return cnt == 0;
	}

	/********************* Backtracking *********************/
	// Time Complexity : O(n^n), n -> Length of string
	// Space Complexity : O(n)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public List<String> removeInvalidParenthesesBacktrack(String s) {
		ans = new ArrayList<>();

		if (s == null || s.length() == 0) {
			return ans;
		}

		max = 0;
		ansSet = new HashSet<>();
		backtrack(new StringBuilder(s));
		return ans;
	}

	private void backtrack(StringBuilder sb) {
		// Base
		if (ansSet.contains(sb.toString()) || max > sb.length()) {
			return;
		}

		if (isValid(sb.toString())) {
			if (max < sb.length()) {
				max = sb.length();
				ans = new ArrayList<>();
			}
			ans.add(sb.toString());
		}

		// Logic
		ansSet.add(sb.toString());
		for (int i = 0; i < sb.length(); i++) {
			// Action
			char ch = sb.charAt(i);
			// Recurse
			backtrack(sb.deleteCharAt(i));
			// Backtrack
			sb.insert(i, ch);
		}
	}

	private void print(List<String> parentheses) {
		for (String parenthesis : parentheses) {
			System.out.print(parenthesis + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		RemoveInvalidParentheses obj = new RemoveInvalidParentheses();
		String s = "()())()";

		List<String> validParentheses = obj.removeInvalidParentheses(s);
		System.out.println("Valid Parentheses:");
		obj.print(validParentheses);
	}

}
