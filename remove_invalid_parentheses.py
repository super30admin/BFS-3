"""
// Time Complexity : O(2^N)
// Space Complexity : O(2^N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
Algorithm Explanation
Given below
"""
from collections import deque
class Solution:
	def removeInvalidParentheses(self, s: str) -> List[str]:
		"""
		Brute force - n2 time, n space
		Idea is to simulate removal of each right parentheses and run the valid string function based on stack method
		
		Min number of removal- BFS
		Idea is to consider the orginal string and split into n possible strings by removing one character and forming a new string
		- Initial configuration - Initial queue
		- If we get a valid string at a level, we break the traversal, since this will be the level where we get the minimum removal possible
			- Add to result
		- For each invalid string
			- Put all the children of the string in the queue by considering removing one character till the end
		- Repeat the above until the queue is empty
		- Return the result
		
		Checking the validity of the string(Much better than using the stack)
		- If the length is odd - False (an't use this because of alphabets)
		- Manipulate the counts of open(increment) and close(decrement) parentheses
		- Check if count == 0 in the end
		
		"""
		def valid_string(strg):
			count = 0
			for c in strg:
				if c == '(':
					count+=1
				elif c == ')':
					if count == 0: #checking if there has been at least one openining parenthesis
						return False
					count-=1
			return count == 0
		
		result = []
		if not string:
			return result
		q = deque([s])
		flag = False
		visited_str = set()
		while q and not flag: # using to discount the operations for checking the strings beyond a point, since we know if we find a positibe result at a level, we need not go to next level at all.
			size = len(q)
			for i in range(size):
				curr = q.popleft()
				if valid_string(curr):
					flag = True
					result.append(curr)
				if not flag:
					for i in range(len(curr)):
						if curr[i].isalpha():continue
						new_str = curr[:i] + curr[i+1:]
						if new_str not in visited_str:
							visited_str.add(new_str)
							q.append(new_str)
		return result