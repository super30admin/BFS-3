# Time Complexity : O(n*n!) --> exponential
# Space Complexity : exponential.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#

# BFS.
from collections import deque


class Solution:
    def isValid(self, s):
        count = 0
        for i in s:
            if i != '(' and i != ')':
                continue
            if i == '(':
                count += 1
            if i == ')':
                count -= 1
            if count < 0:
                return False
        if count == 0:
            return True
        return False

    def removeInvalidParentheses(self, s: str) -> list[str]:
        result = []
        queue = deque()
        check = set()
        queue.append(s)
        check.add(s)
        flag = False
        while queue and not flag:
            size = len(queue)
            for i in range(size):
                pop = queue.popleft()
                if self.isValid(pop):
                    flag = True
                    result.append(pop)
                else:
                    if not flag:
                        for j in range(len(pop)):
                            if pop[j] != '(' and pop[j] != ')':
                                continue
                            new_str = pop[:j] + pop[j + 1:]
                            if new_str not in check:
                                queue.append(new_str)
                                check.add(new_str)
        return result


print(Solution().removeInvalidParentheses("()())()"))


# DFS
# class Solution:
#     def isValid(self, s):
#         count = 0
#         for i in s:
#             if i != '(' and i != ')':
#                 continue
#             if i == '(':
#                 count += 1
#             if i == ')':
#                 count -= 1
#             if count < 0:
#                 return False
#         if count == 0:
#             return True
#         return False
#
#     def dfs(self, s):
#         # base
#         if s in self.check:
#             return
#         if len(s) < self.max:
#             return
#         # logic
#         self.check.add(s)
#         if self.isValid(s):
#             if len(s) > self.max:
#                 self.result = []
#             self.max = len(s)
#             self.result.append(s)
#         else:
#             for i in range(len(s)):
#                 if s[i] != '(' and s[i] != ')':
#                     continue
#                 new_string = s[:i] + s[i+1:]
#                 self.dfs(new_string)
#
#     def removeInvalidParentheses(self, s: str) -> list[str]:
#         self.max = 0
#         self.result = []
#         self.check = set()
#         self.dfs(s)
#         return self.result
#
#
# print(Solution().removeInvalidParentheses("()())()"))
