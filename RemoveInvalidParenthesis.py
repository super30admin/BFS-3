'''
Solution:   
1.  Perform a BFS for this question as we require to remove least number of parenthesis.
2.  We create one level extra by removing one of the parenthesis and if at any level, we find
    a valid parenthesis, we stop at that level and add all valid strings to the resultant array.
3.  At each level, we also keep track of already visited new strings using a HashSet, and for better
    optimization, we clear the HashSet at each level.

Time Complexity:    Exponential |   Space:  O(L), where L is the number of strings at any level
--- Passed all testcases successfully on leetcode.
'''


from collections import deque

class Solution:
    
    def __isValid(self, string: str) -> bool:
        
        #   function to check whether a string is valid or not using count method.
        count = 0
        
        for char in string:
            if (char == ')'):
                count -= 1
            elif (char == '('):
                count += 1
            
            if (count < 0):
                return False
            
        return (count == 0)
    
    def removeInvalidParentheses(self, s: str) -> List[str]:
        
        #   initializations
        finalResult = []
        levelStringsSet = set()
        
        queue = deque([s])
        
        #   iterate until queue is empty
        while (len(queue) > 0):
            levelCount = len(queue)
            
            #   if at any level, if final result is non-empty => return
            if (len(finalResult) > 0):
                return finalResult
            
            #   for each string in current level
            for i in range(levelCount):
                currentString = queue.popleft()
                
                #   check for the presence in HashSet
                if (currentString not in levelStringsSet):

                    #   check whether string is valid or not
                    #   otherwise push to Queue all its children
                    if (self.__isValid(currentString)):
                        finalResult.append(currentString)
                    else:
                        if (len(finalResult) <= 0):
                            for j in range(len(currentString)):
                                if (currentString[j] == '(' or currentString[j] == ')'):
                                    child = currentString[: j] + currentString[j+1: ]
                                    queue.append(child)
                
                #   add the string to HashSet               
                levelStringsSet.add(currentString)
             
            #   clear the HashSet at each level                   
            levelStringsSet = set()
        
        #   return final array                       
        return finalResult