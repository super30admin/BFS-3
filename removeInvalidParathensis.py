#Time Complexity:  Exponential
#SpaceCOMPLEXITY : O(l)  where L is number of any strings at any level
from collections import deque 
class Solution:
    def isvalid(self, s:str) -> bool:
            count = 0
            for ch in s:
                if ch == "(":
                    count = count + 1
                elif ch == ")":
                    count = count - 1
                if count < 0:
                    return False
            return count == 0
    def removeInvalidParentheses(self, s: str) -> List[str]:
        finalResult = []
        levelStringsSet = set()
        queue = deque([s])
        while (len(queue) > 0):
            levelCount = len(queue)
            if (len(finalResult) > 0):
                return finalResult
            for i in range(levelCount):
                currentString = queue.popleft()
                if (currentString not in levelStringsSet):
                    if (self.isvalid(currentString)):
                        finalResult.append(currentString)
                    else:
                        if (len(finalResult) <= 0):
                            for j in range(len(currentString)):
                                if (currentString[j] == '(' or currentString[j] == ')'):
                                    child = currentString[: j] + currentString[j+1: ]
                                    queue.append(child)           
                levelStringsSet.add(currentString)            
            levelStringsSet = set()              
        return finalResult 
        