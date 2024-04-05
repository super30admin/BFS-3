"""
Time Complexity : n^n where n is the length of the input string. This is because we are creating substrings every time.
Space Complexity : n^n where n is the length of the input string. This is because we are creating new substrings every time.

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : Yes


Your code here along with comments explaining your approach:
Create all the possible substring add to the result if the string is valid and has maximum length
"""


class Solution:
    def __init__(self):
        self.hashSet = set()
        self.result = []
        self.max = 0

    def removeInvalidParentheses(self, s: str) -> List[str]:
        if len(s) == 0:
            return self.result
        self.dfs(s)
        return self.result

    def dfs(self, s):
        # base
        if len(s) < self.max or s in self.hashSet:
            return
        if self.isValid(s):
            if len(s) > self.max:
                self.result = []
                self.result.append(s)
                self.max = len(s)
            elif len(s) == self.max:
                self.result.append(s)
            self.hashSet.add(s)
            return

        # logic
        self.hashSet.add(s)
        for i in range(len(s)):
            if s[i].isalpha():
                continue
            newStr = s[0:i] + s[i+1:]
            self.dfs(newStr)

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
