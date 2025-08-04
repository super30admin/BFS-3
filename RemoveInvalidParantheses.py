# Time Complexity: O(n^n) Exponential
# Space Complexity: O(n^n) Exponential
# Approach: BFS
# class Solution:
#     def removeInvalidParentheses(self, s: str) -> list[str]:
#         result = []
#         visited = set([s])
#         queue = deque([s])
#         found = False
        
#         while queue:
#             size = len(queue)
#             for _ in range(size):
#                 curr = queue.popleft()
            
#                 if self._is_valid(curr):
#                     result.append(curr)
#                     found = True
                
#                 if not found:
#                     for i in range(len(curr)):
#                         if curr[i].isalpha():
#                             continue
#                         baby = curr[:i] + curr[i+1:]
#                         if baby not in visited:
#                             visited.add(baby)
#                             queue.append(baby)
#         return result
    
#     def _is_valid(self, s: str) -> bool:
#         count = 0
#         for c in s:
#             if c.isalpha():
#                 continue
#             if c == '(':
#                 count += 1
#             else:
#                 if count == 0:
#                     return False
#                 count -= 1
#         return count == 0


# Time Complexity: O(2^n)
# Space Complexity: O(n)
# Approach: DFS
class Solution:
    def __init__(self):
        self.max_len = 0
        self.result = []
    
    def removeInvalidParentheses(self, s: str) -> list[str]:
        self.result = []
        self._dfs(s, set())
        return self.result
    
    def _dfs(self, s: str, visited: set):
        # base case
        if len(s) < self.max_len:
            return
        
        # check validity
        if self._is_valid(s):
            if len(s) > self.max_len:
                self.max_len = len(s)
                self.result = []
            self.result.append(s)
        
        # explore neighbors
        for i in range(len(s)):
            if s[i].isalpha():
                continue
            baby = s[:i] + s[i+1:]
            if baby not in visited:
                visited.add(baby)
                self._dfs(baby, visited)
    
    def _is_valid(self, s: str) -> bool:
        count = 0
        for c in s:
            if c.isalpha():
                continue
            if c == '(':
                count += 1
            else:
                if count == 0:
                    return False
                count -= 1
        return count == 0
