from collections import deque


class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        result = []
        if s is None or len(s) == 0:
            return result

        hashSet = set()
        hashSet.add(s)
        q = deque()
        q.append(s)
        flag = False

        while len(q) > 0:
            # size = len(q)
            # for i in range(size):
            curr = q.popleft()
            if self.isValid(curr):
                flag = True
                result.append(curr)
            else:
                if not flag:
                    for j in range(len(curr)):
                        if curr[j].isalpha():
                            continue
                        child = curr[0: j] + curr[j + 1:]
                        if child not in hashSet:
                            hashSet.add(child)
                            q.append(child)
        return result

    def isValid(self, ss):
        count = 0
        for i in range(len(ss)):
            char = ss[i]
            if char == "(":
                count += 1
            elif char == ")":
                count -= 1
                if count < 0:
                    return False
        return count == 0

# BFS without the size variable
# Time Complexity: O(2n)
# Space Complexity: O(n)
# Did this code successfully run on LeetCode : Yes
# Any problem you faced while coding this : No
