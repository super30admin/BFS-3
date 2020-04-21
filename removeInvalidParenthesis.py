'''
Time Complexity: O(2^n)
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Explanation: Add the string to queue, for every level see if we can generate a valid bracket string by removing paranthesis
by removing one bracket at a time from left to right, if its possible add this to the result and at this level the removal
would be the minimum number of brackets to be removed for it to be valid so no need of going deeper in the recursion.
'''
class Solution:
    def isValid(self, s):
        count = 0
        for char in s:
            if char == '(':
                count += 1
            elif char == ')':
                count -= 1

            if count == -1:
                return False

        return count == 0

    def removeInvalidParentheses(self, s: str) -> List[str]:
        res = []

        if s == None:
            return res

        visited = set()

        shouldExploreNextLevel = True

        queue = [s]

        while len(queue) != 0:
            levelCount = len(queue)

            for i in range(0, levelCount):
                current = queue[0]
                queue = queue[1:]

                if current not in visited:
                    if self.isValid(current):
                        shouldExploreNextLevel = False
                        res.append(current)

                    visited.add(current)

                    if shouldExploreNextLevel:
                        for k in range(0, len(current)):
                            if current[k].isalpha():
                                continue

                            child = current[0:k] + current[k + 1:]

                            queue.append(child)

            if shouldExploreNextLevel == False:
                break

        return res
