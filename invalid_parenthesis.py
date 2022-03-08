# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :Yes

# Your code here along with comments explaining your approach

import collections
from typing import List


class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        def is_valid(expr):
            count = 0
            for ch in expr:
                if ch in '()':
                    if ch == '(':
                        count += 1
                    elif ch == ')':
                        count -= 1
                    if count < 0:
                        return False
            return count == 0

        queue = collections.deque()
        queue.append(s)

        seen = set()
        seen.add(s)

        stay_at_this_level = False
        output = []

        while queue:

            expression = queue.popleft()

            if is_valid(expression):
                output.append(expression)
                stay_at_this_level = True

            elif not stay_at_this_level:
                # populate queue with candidiates at the next level i.e. one less ( or )
                for i in range(len(expression)):

                    if expression[i] in '()':
                        candidate = expression[:i] + expression[i+1:]

                        if candidate not in seen:
                            queue.append(candidate)
                            seen.add(candidate)

        return output if output else ['']
