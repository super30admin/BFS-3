# Time Complexity : O(2^n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
from collections import deque

class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        def is_valid(s_to_check):
            bal = 0

            for c in s_to_check:
                if c == '(':
                    bal +=1
                elif c == ')':
                    bal -= 1
                    if bal < 0:
                        return False

            return bal == 0

        res = []

        visited = {s}
        queue = deque([(s,0)])
        is_found, min_num_changes = False, len(s)

        while queue:
            curr_s, num_changes = queue.popleft()

            if is_found and min_num_changes < num_changes:
                break

            if is_valid(curr_s):
                is_found = True
                min_num_changes = num_changes
                res.append(curr_s)
            else:
                for i in range(len(curr_s)):
                    curr_s_state = curr_s[:i] + curr_s[i+1:]

                    if curr_s_state not in visited:
                        queue.append((curr_s_state, num_changes + 1))
                        visited.add(curr_s_state)

        return res
