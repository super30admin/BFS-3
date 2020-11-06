# Time Complexity : O(2^n), every point has choose/don't choose option
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes 
# Any problem you faced while coding this : No

# Approach/Intuition:

# We need all possible combinations: backtracking. We choose/don't choose a '(',')'.  
# Using DFS our code would explore each branch till we find an  answer and that would give us extra answers than required. But if we explore c/dc every bracket and validate the remaining string at every level, we won't have to explore more levels if we find our answer early on. We need to remove the minimum number of invalid parentheses in order to make the input string valid. 
# At the same level, when we find an answer, keep exploring the same level for more answers. If no answer is found, explore next level.
# Need to verify only unique strings: either keep a visited array or keep unique strings in a hashset
# Validating strings: Stack soln/We can count the number of ( and ) since we only have one type of brackets(+1-1+1... and so on). If count is negative at any point, return invalid string.
# When we encounter char, move the pointer ahead.

class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        output = []
        
        if s==None:
            return output
        
        #1. put initial string in hashset and queue
        hset = set()
        queue = []
        found = False
        
        hset.add(s)
        queue.append(s)
        
        #2. start BFS
        while queue:
            front = queue.pop(0)
            #2.3  
            if (self.isValid(front)):
                found = True
                output.append(front)
            
            if not found:
                for x in range(len(front)):
                    if front[x] != ')' and front[x] != '(':
                        continue
                    newString = front[:x]+front[x+1:]
                    
                    #2.2
                    if newString not in hset:
                        hset.add(newString)
                        queue.append(newString)
            
            #2.1 Check if it is a () 
            #2.2 If it is present in hashset
            #2.3 check if valid
        
        return output
        
    def isValid(self, s):
        count = 0
        for ch in s:
            if ch == "(":
                count += 1
            elif ch == ")":
                if count == 0: return False
                count -= 1
        return count == 0
        
        