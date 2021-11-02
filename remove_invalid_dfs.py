# // Time Complexity :O(exponential)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :giving time limisted exceeded when submitting, but when the same input was given as text case works fine


# // Your code here along with comments explaining your approach

class Solution:
    def __init__(self):
        self.result=[]
        self.hset=[]
        self.max=0
    def removeInvalidParentheses(self, s: str) -> List[str]:
    
        self.dfs(s)
        return self.result
    def dfs(self,s):
        #base
        if s in self.hset or len(s)<self.max:
            return
        #logic
        self.hset.append(s)
        if self.isvalid(s):
            if len(s)>self.max:
                self.result=[]
                self.max=len(s)
                self.result.append(s)
            else:
                self.result.append(s)

                
        else:
            for i in range(len(s)):
                subs=s[:i]+s[i+1:]
                self.dfs(subs)
            
        
    def isvalid(self,curr):
        count=0
        for i in curr:
            
            if i=='(':
                count+=1
            elif i==')':
                count-=1
            if count==-1:
                return False
        return count==0
            