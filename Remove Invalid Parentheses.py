#BFS
""""// Time Complexity : O(n^n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        visited = set()
        q = deque()

        q.append(s)
        visited.add(s)
        flag = False
        ans = []
        while len(q) != 0 and flag != True:
            size = len(q)
            for i in range(size):
                curr = q.popleft()

                if self.isValid(curr):
                    flag = True
                    ans.append(curr)
                if flag != True:

                    for i in range(0, len(curr)):
                        if curr[i].isalpha():
                            continue
                        newStr = curr[0:i] + curr[i + 1:]
                        if newStr not in visited:
                            q.append(newStr)
                            visited.add(newStr)
        return ans

    def isValid(self, s):
        count = 0
        for i in range(len(s)):
            if s[i] == '(':
                count += 1
            elif s[i] == ')':
                count -= 1
            if (count < 0):
                return False
        return count == 0

#DFS
""""// Time Complexity : O(n^n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
# class Solution:
#     def removeInvalidParentheses(self, s: str) -> List[str]:
#         self.visited = set()
#         self.result = []
#         self.max = 0
#         self.dfs(s)
#         return self.result
#
#     def dfs(self, s):
#         # base
#         if s in self.visited:
#             return
#         if len(s) < self.max:
#             return
#
#         # logic
#         self.visited.add(s)
#         if self.isValid(s):
#             if self.max < len(s):
#                 self.result = []
#             self.max = len(s)
#             self.result.append(s)
#         else:
#             for i in range(len(s)):
#                 if s[i].isalpha():
#                     continue
#                 child = s[0:i] + s[i + 1:]
#                 self.dfs(child)
#
#     def isValid(self, s):
#         count = 0
#         for i in range(len(s)):
#             if s[i] == '(':
#                 count += 1
#             elif s[i] == ')':
#                 count -= 1
#             if (count < 0):
#                 return False
#         return count == 0