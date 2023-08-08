# Time Complexity : O(product of n!)
# Space Complexity :O(n)
# Passed on Leetcode: yes

class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        def is_valid(string):
            count = 0
            for char in string:
                if char == '(':
                    count += 1
                elif char == ')':
                    count -= 1
                    if count < 0:
                        return False
            return count == 0
        
        queue = [s]
        visited = set()
        found = False
        result = []
        
        while queue:
            current = queue.pop(0)
            if is_valid(current):
                result.append(current)
                found = True
            
            if found:
                continue
                
            for i in range(len(current)):
                if current[i] not in ['(', ')']:
                    continue
                next_string = current[:i] + current[i+1:]
                if next_string not in visited:
                    visited.add(next_string)
                    queue.append(next_string)
        
        return result
