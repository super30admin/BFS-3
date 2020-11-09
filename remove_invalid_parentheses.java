// TC: O(n * 2 ^(n-1)) - n to compare if its valid and 2^n to generate different combinations of substring be deleting parentheses
// SC: O(2^n) to store values in queue since we have 2^n combination in one time
import java.util.*;

public class remove_invalid_parentheses {

	public List<String> remove_parentheses(String s) {
		
		List<String> res = new ArrayList<>();

		if(s == null || s.length() == 0)
			return res;
		
		boolean isFound = false;
		Queue<String> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>();
		queue.add(s);
		visited.add(s);
		
		while(!queue.isEmpty()) {
			String str = queue.poll();
			// check if the given string or generated string is valid, if its valid, add in result and mark it as found so that we d
			// do not have to remove the same string pattern further and check if its valid
			
			if(isValid(str)) {
				res.add(str);
				isFound = true;
			}
			
			if(isFound)
				continue;
			for(int i=0;i<str.length();i++) {
				// if the str contains character, ignore those
				if(str.charAt(i) != '(' && str.charAt(i) != ')')
					continue;
				// remove the first character and check if the string is already visited, if not add it in queue so that we can verify its validity
				// and remove further characters and check them and mark them as visited once added to queue
				String t = str.substring(0, i) + str.substring(i+1);
				if(!visited.contains(t)) {
					queue.add(t);
					visited.add(t);
				}
			}
		}
		return res;
	}

	private boolean isValid(String str) {
		// TODO Auto-generated method stub
		int cnt = 0;
		for(int i=0;i<str.length();i++) {
			// if the character is opening, increment the count
			if(str.charAt(i) == '(')
				cnt++;
			// if the character is closing, check if the count is not 0, if its 0 which means that there is extra closing character,
			// we return false, or else decrement the count and continue
			if(str.charAt(i) == ')' && cnt-- == 0)
				return false;
		}
		// if the count is 0, we have equal number of opening and closing bracket, if not 0, we have more opening brackets
		return cnt == 0;
	}
	
}
