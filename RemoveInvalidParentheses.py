# Time Complexity : Exponential
# Space Complexity :
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :

# Your code here along with comments explaining your approach
# Using BFS Approach. If we have a valid string then append it to res. We will check for validity using isValid function
# If the currString is not valid then iterate over the currString and for the child get every combination using substring and check if it is already in set
# If not add it to set and append it to queue

from collections import deque


class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        string_set = set()
        queue = deque([s])
        string_set.add(s)
        res = []
        flag = False
        while queue:
            for i in range(0, len(queue)):
                currString = queue.popleft()
                if self.isValid(currString):
                    flag = True
                    res.append(currString)
                if flag == False:
                    #add the children to the queue
                    for j in range(len(currString)):
                        if currString[j].isalpha():
                            continue
                        baby = currString[:j] + currString[j + 1:]
                        if baby not in string_set:
                            queue.append(baby)
                            string_set.add(baby)

        return res

    def isValid(self, s):
        count = 0
        for i in range(len(s)):
            if s[i] == "(":
                count += 1
            elif s[i] == ")":
                if count == 0:
                    return False
                count -= 1
        return count == 0
