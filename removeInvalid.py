"""
Use BFS to explore all possible strings by removing one parenthesis at each level
Once we find any valid expression, stop further search at deeper levels (guarantees minimum removal)
Use a set to avoid duplicate processing
"""
"""
Time Complexity : Exponential O(2^n) worst case (but pruned by BFS)
Space Complexity : O(n * 2^n) for visited set and queue
"""
from collections import deque

class Solution:
    def removeInvalidParentheses(self, s: str) -> list[str]:
        def is_valid(expr):
            count = 0
            for ch in expr:
                if ch == '(': count += 1
                elif ch == ')': count -= 1
                if count < 0: return False
            return count == 0

        res = []
        visited = set()
        queue = deque([s])
        found = False

        while queue:
            level_size = len(queue)
            for _ in range(level_size):
                curr = queue.popleft()
                if curr in visited:
                    continue
                visited.add(curr)

                if is_valid(curr):
                    res.append(curr)
                    found = True

                if not found:
                    for i in range(len(curr)):
                        if curr[i] not in "()":
                            continue
                        next_expr = curr[:i] + curr[i+1:]
                        if next_expr not in visited:
                            queue.append(next_expr)

            if found:
                break

        return res

if __name__ == "__main__":
    sol = Solution()
    print(sol.removeInvalidParentheses("()())()"))
    print(sol.removeInvalidParentheses("(a)())()"))
    print(sol.removeInvalidParentheses(")("))
