# Time Complexity : O(2^N), where N is the length of the input string
# Space Complexity : O(2^n)
from typing import List


class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        # Function to check if a given string is valid
        def is_valid(s):
            count = 0
            for char in s:
                if char == '(':
                    count += 1
                elif char == ')':
                    count -= 1
                    if count < 0:
                        return False
            return count == 0
        
        # Function to perform DFS and remove invalid parentheses
        def dfs(s, index, left_count, right_count, left_remove, right_remove, curr):
            if index == len(s):
                if left_remove == 0 and right_remove == 0 and is_valid(curr):
                    result.add(curr)
                return
            
            if s[index] == '(' and left_remove > 0:
                dfs(s, index+1, left_count, right_count, left_remove-1, right_remove, curr)
            elif s[index] == ')' and right_remove > 0:
                dfs(s, index+1, left_count, right_count, left_remove, right_remove-1, curr)
            
            curr += s[index]
            if s[index] != '(' and s[index] != ')':
                dfs(s, index+1, left_count, right_count, left_remove, right_remove, curr)
            elif s[index] == '(':
                dfs(s, index+1, left_count+1, right_count, left_remove, right_remove, curr)
            elif s[index] == ')' and left_count > right_count:
                dfs(s, index+1, left_count, right_count+1, left_remove, right_remove, curr)
            
            curr = curr[:-1]
        
        # Count the number of opening and closing brackets that need to be removed
        left_count, right_count = 0, 0
        for char in s:
            if char == '(':
                left_count += 1
            elif char == ')':
                if left_count == 0:
                    right_count += 1
                else:
                    left_count -= 1
        
        # Perform DFS and remove invalid parentheses
        result = set()
        dfs(s, 0, 0, 0, left_count, right_count, "")
        
        return list(result)