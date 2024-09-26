package bfs2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class RemoveInvalidParantheses {

	public List<String> removeInvalidParentheses(String s) {
		List<String> result = new ArrayList<String>();
		Queue<String> q = new ArrayDeque<String>();
		Set<String> seen = new HashSet<String>();
		boolean found = false;
		q.offer(s);

		while (!q.isEmpty()) {
			String temp = q.poll();

			if (isValid(temp)) {
				result.add(temp);
				found = true;
			} else {
				if (!found)
					for (int i = 0; i < temp.length(); i++) {

						if (temp.charAt(i) == '(' || temp.charAt(i) == ')') {
							String dummy = temp.substring(0, i) + temp.substring(i + 1);

							if (!seen.contains(dummy)) {
								q.add(dummy);
								seen.add(dummy);
							}
						}
					}
			}
		}

		return result;
	}

	private boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		char[] charArr = s.toCharArray();

		for (char ch : charArr) {

			if (ch == '(')
				stack.push(ch);
			else if (ch == ')') {
				if (stack.isEmpty())
					return false;

				Character stackTop = stack.pop();
				if (stackTop != '(')
					return false;
			}
		}

		return stack.isEmpty();
	}

}