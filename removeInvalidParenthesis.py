from collections import deque

#time Complexity: O(2^N)
#space Complexity: O(N+N)

class Solution:
    def validParentheses(self, s):
        count = 0
        for ch in s:
            if ch == "(":
                count += 1
            if ch == ")":
                count -= 1
            if count < 0:
                return False
        return count == 0

    def removeInvalidParentheses(self, s: str) -> List[str]:
        if not s:
            return []
        result = []
        visited = set()
        visited.add(s)
        que = deque([s])
        flag = False
        while que and not flag:
            size = len(que)
            for i in range(size):
                curr = que.popleft()
                if self.validParentheses(curr):
                    flag = True
                    result.append(curr)
                else:
                    for j in range(len(curr)):
                        if curr[j].isalpha():
                            continue
                        newS = curr[:j] + curr[j + 1:]
                        if newS not in visited:
                            que.append(newS)
                            visited.add(newS)
        return result