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
        found = False
        queue = deque([s])
        levelStringsSet.add(s)
        while (len(queue) > 0):
            levelCount = len(queue)
            for i in range(levelCount):
                currentString = queue.popleft()
                if (self.isvalid(currentString)):
                    finalResult.append(currentString)
                    found = True
                else:
                    if (found!= True):
                        for j in range(len(currentString)):
                            if (currentString[j].isalpha()) ==True:
                                continue
                            child = currentString[: j] + currentString[j+1: ]
                            if child not in levelStringsSet:
                                queue.append(child) 
                                levelStringsSet.add(child)                     
        return finalResult 
        
        