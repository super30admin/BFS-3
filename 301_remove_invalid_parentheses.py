"""
Leetcode: https://leetcode.com/problems/remove-invalid-parentheses/

Approach: Using BFS (queue)

Time Complexity : O(2^N) since in the worst case we will have only left parentheses in the expression and for
every bracket we will have two options i.e. whether to remove it or consider it. Considering that the
expression has N parentheses, the time complexity will be O(2^N).

Space Complexity: O(N), to store all elements in queue in worst case
"""


class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        if not s:
            return [""]

        result = []
        visited = set()
        q = []

        visited.add(s)
        q.append(s)

        found = False

        while q:
            top = q.pop(0)

            if self.isValid(top):
                result.append(top)
                found = True

            if not found:
                # Backtracking choices
                for i in range(len(top)):
                    # for char other than ( and )
                    if top[i] != "(" and top[i] != ")":
                        continue

                    new_str = top[:i] + top[i + 1:]

                    if new_str not in visited:
                        visited.add(new_str)
                        q.append(new_str)
        return result

    def isValid(self, s):
        count = 0
        for ch in s:
            if ch == "(":
                count += 1
            elif ch == ")":
                if count == 0:
                    return False
                count -= 1
        return count == 0

