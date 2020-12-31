"""
Time Complexity : I am not sure. I think its exponential
Space Complexity : O(l)- length of the queue
Did this code successfully run on Leetcode : I don't have leetcode Premium. I saw the code online and just
wrote down my algo
Any problem you faced while coding this : no

This is BFS.At every level, we need to remove a bracket from the curr value, if its valid, add it to the result array and convert the boolean
to true. After this, Add all its children to the queue. Once after a level, our found boolean is True, we donot need to 
proceed.
"""
from collections import deque


class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        result = []
        if not s:
            return [""]
        queue = deque()
        found = False
        visited = set()
        queue.append(s)
        while queue and not found:
            size = len(queue)
            for i in range(size):
                curr = queue.popleft()
                if self.isValid(curr):
                    found = True
                    result.append(curr)
                for i in range(len(curr)):
                    if curr[i] not in '()':
                        continue
                    tempString = curr[:i]+curr[i+1:]
                    if tempString not in visited:
                        queue.append(tempString)
                        visited.add(tempString)
        return result

    def isValid(self, s):
        count = 0
        for i in range(len(s)):
            if s[i] == '(':
                count += 1
            elif s[i] == ')':
                if count == 0:
                    return False
                count -= 1
        return count == 0
