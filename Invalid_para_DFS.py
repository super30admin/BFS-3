# DFS Approach
# Time complexity : O(2^N)
# Space complexity : O(N)
# Leetcode : Solved and submitted

class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        self.res = []
        self.max_val = 0
        
        # check for null case
        if not s or len(s) == 0:
            return self.res
        
        # create a set to maintain the unqiue result and also to check that we do not do traversal for the same string
        self.seen = set()
        
        # call the dfs on the string and return the res
        self.dfs(s)
        return self.res
    
    def dfs(self, s):
        # base
        # if the max_val is greater than the lenght of the string, then return as this is not the minimum operation string len
        if len(s) < self.max_val:
            return
        
        # if the string is valid then check for the len of s is equal to max_val
        if self.isValid(s):
            if len(s) > self.max_val:
              # if we have a new max_val, then reset the res to empty list and max_val to the len of current string
                self.max_val = len(s)
                self.res = []
            self.res.append(s)
            return
            
        # add the string to the set
        self.seen.add(s)
        
        # do for loop based recursion to check for each possibility of the string as valid
        for i in range(len(s)):
          # if we encounter any letter or alphabet then continue
            if s[i].isalpha():
                continue
           # form the subtring
            child = s[0:i] + s[i+1:]
            # if the substring is not present in the set only then add to the set and also call the dfs
            if child not in self.seen:
                self.seen.add(child)
                self.dfs(child)
    
    # function to validate the bring by checking for balanced oepning and closing brackets
    def isValid(self, s):
        count = 0
        for i in range(len(s)):
            if s[i] == '(':
                count += 1
            else:
                if s[i] == ')':
                    if count == 0:
                        return False
                    count -= 1
        return count == 0
