from collections import deque
class Solution:
    def checkBalanced(self, s):
        count = 0
        for ch in s:
            if ch.isalpha():
                continue

            if ch == '(':
                count += 1
            else:
                count -= 1

            if count < 0:
                return False
        return True if count == 0 else False

    def removeInvalidParentheses(self, s: str) -> List[str]:
        if self.checkBalanced(s):
            return [s]

        q = deque()
        visited = set()
        visited.add(s)

        q.append(s)
        found = False
        res = []

        while q:
            qSize = len(q)
            for i in range(qSize):
                currS = q.popleft()
                for j in range(len(currS)):
                    newS = currS[:j] + currS[j + 1:]
                    if newS in visited:
                        continue

                    visited.add(newS)
                    if self.checkBalanced(newS):
                        found = True
                        res.append(newS)
                    else:
                        q.append(newS)
            if found:
                return res
        return res
