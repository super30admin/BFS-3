"""
Time Complexity : n^n where n is the length of the input string. This is because we are creating substrings every time.
Space Complexity : n^n where n is the length of the input string. This is because we are creating new substrings every time.

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : Yes


Your code here along with comments explaining your approach:
Create all the possible substring add to the result if the string is valid and has maximum length
"""
from collections import deque


class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        if len(s) == 0:
            return []
        result = []
        hashSet = set()
        flag = False
        queue = deque()

        queue.append(s)
        hashSet.add(s)

        while queue:
            size = len(queue)
            for i in range(size):
                currStr = queue.popleft()
                if self.isValid(currStr):
                    flag = True
                    result.append(currStr)
                elif not flag:
                    for j in range(len(currStr)):
                        if currStr[j].isalpha():
                            continue
                        newStr = currStr[0:j] + currStr[j+1:]
                        if newStr not in hashSet:
                            queue.append(newStr)
                            hashSet.add(newStr)

        return result

    def isValid(self, s):
        count = 0
        for i in range(len(s)):
            currChar = s[i]
            if currChar.isalpha():
                continue
            elif currChar == "(":
                count += 1
            elif currChar == ")":
                count -= 1
            if count < 0:
                return False
        return count == 0
