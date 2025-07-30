"""
I implemented a DFS-based solution to remove the minimum number of invalid parentheses. It explores all possible strings by removing one parenthesis at a time and uses a visited set to avoid duplicates. We keep track of the longest valid expressions found (max_len) to ensure only valid strings of maximum length are returned.
Time Complexity: O(2^n)
Space Complexity: O(2^n * n)
"""
class Solution:
    def removeInvalidParentheses(self, s: str) -> list[str]:
        self.result = []
        self.visited = set()
        self.max_len = 0
        self.dfs(s)
        return self.result

    def dfs(self, s: str):

        if len(s) < self.max_len:
            return

        if self.is_valid(s):
            if len(s) > self.max_len:
                self.max_len = len(s)
                self.result.clear()
            self.result.append(s)
            return

        for i in range(len(s)):
            if s[i].isalpha():
                continue
            next_s = s[:i] + s[i+1:]
            if next_s not in self.visited:
                self.visited.add(next_s)
                self.dfs(next_s)
                
    def is_valid(self, s: str) -> bool:
        count = 0
        for char in s:
            if char == '(':
                count += 1
            elif char == ')':
                count -= 1
                if count < 0:
                    return False
        return count == 0