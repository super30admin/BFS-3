"""
TC: O(2^n)
SP: O(n)
"""
class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        def valid(cstr):
            stack = []
            for c in cstr:
                if c == "(":
                    stack.append(c)
                elif c == ")":
                    if stack:
                        stack.pop()
                    else:
                        return False
            return True if not stack else False

        q = deque()
        q.append(s)
        seen = set()
        seen.add(s)
        res = []
        while q:
            for i in range(len(q)):
                curr_string = q.popleft()
                if not valid(curr_string):
                    for i in range(len(curr_string)):
                        new_str = curr_string[:i] + curr_string[i + 1 :]
                        if new_str not in seen:
                            q.append(new_str)
                            seen.add(new_str)
                else:
                    res.append(curr_string)
            if res:
                return res
