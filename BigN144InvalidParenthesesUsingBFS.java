//Time complexity is O(2^N)
//Space complexity is O(2^N)
//This solution is submitted on leetcode

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BigN144InvalidParenthesesUsingBFS {
	class Solution {
		public List<String> removeInvalidParentheses(String s) {
			List<String> result = new ArrayList<>();
			// edge case
			if (s == null)
				return result;
			Queue<String> q = new LinkedList<>();
			HashSet<String> set = new HashSet<>();
			boolean flag = false;
			q.add(s);
			set.add(s);
			while (!q.isEmpty()) {
				String temp = q.poll();
				if (isValid(temp)) {
					flag = true;
					result.add(temp);
				}
				if (!flag) {
					for (int i = 0; i < temp.length(); i++) {
						if (Character.isLetter(temp.charAt(i)))
							continue;
						String curr = temp.substring(0, i) + temp.substring(i + 1);
						if (!set.contains(curr)) {
							q.add(curr);
							set.add(curr);
						}
					}
				}
			}
			return result;
		}

		private boolean isValid(String s) {
			int count = 0;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c == '(')
					count++;
				else if (c == ')') {
					if (count == 0)
						return false;
					count--;
				}
			}
			return count == 0;
		}
	}
}