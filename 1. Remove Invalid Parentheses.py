from collections import deque
class Solution:
    # Time Complexity - O(2^n)
    # Space Complexity - O(n)
    def removeInvalidParentheses(self, s: str):
        if s is None or len(s) == 0: return []
        d = set()
        q = deque()
        q.append(s)
        d.add(s)
        result = []
        found = False

        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                if self.isValid(curr):
                    found = True
                    result.append(curr)
                else:
                    if found == False:
                        for j in range(len(curr)):
                            if curr[j].isalpha():
                                continue
                            sub = curr[0:j] + curr[j + 1:]
                            if sub not in d:
                                d.add(sub)
                                q.append(sub)
        return result

    def isValid(self, s):
        count = 0
        for c in s:
            if c == '(':
                count += 1
            elif c == ')':
                count -= 1
            else:
                continue
            if count < 0:
                return False
        return count == 0