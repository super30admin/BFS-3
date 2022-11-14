class Solution:
    def __init__(self):

        # self.flag = False
        self.result = []
        self.maximum = 0

    def removeInvalidParentheses(self, s: str) -> List[str]:
        self.hashSet = set()
        # self.hashSet.add(s)
        self.result = []
        self.maximum = 0

        self.helper(s)
        return self.result

    def helper(self, curr):
        if len(curr) < self.maximum or curr in self.hashSet:
            return
        self.hashSet.add(curr)

        if self.isValid(curr):
            if len(curr) > self.maximum:
                self.maximum = len(curr)
                self.result = []
                self.result.append(curr)
            elif len(curr) == self.maximum:
                self.result.append(curr)

        else:
            for i in range(len(curr)):
                child = curr[0: i] + curr[i + 1:]
                self.helper(child)

    def isValid(self, curr):
        count = 0
        for i in range(len(curr)):
            char = curr[i]
            if char == "(":
                count += 1
            elif char == ")":
                count -= 1
                if count < 0:
                    return False
        return count == 0

# DFS
# Time Complexity: O(2n)
# Space Complexity: O(n)
# Did this code successfully run on LeetCode : Yes
# Any problem you faced while coding this : No
