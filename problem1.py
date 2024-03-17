#Time Complexity :O(2^n)
#Space Complexity :O(2^n)
#Did this code successfully run on Leetcode :Yes
#Any problem you faced while coding this :No

from ast import List
from collections import deque


class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        def isValid(s: str) -> bool:
            opened = 0
            for c in s:
                if c == '(':
                    opened += 1
                elif c == ')':
                    opened -= 1
                if opened < 0:
                    return False
            return opened == 0

        queue = deque([s])
        visited = set([s])  

        valid_strings = []
        found_valid = False

        while queue:
            current = queue.popleft()

            if isValid(current):
                valid_strings.append(current)
                found_valid = True

            if found_valid:
                continue  

            for i in range(len(current)):
                if current[i] not in '()':
                    continue
                new_string = current[:i] + current[i + 1:]
                if new_string not in visited:
                    visited.add(new_string)
                    queue.append(new_string)

        return valid_strings
        