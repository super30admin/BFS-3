# Time Complexity : O(2^n) 
# Space Complexity :O(2^n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

class Solution:
    def removeInvalidParentheses(self, s):
        result = []
        if len(s) == None :
            return result 
        q = [s]                     
        flag = False 
        set_ = set()
        while len(q) != 0 :
            curr = q.pop(0)
            res = self.check(curr)       

            if (res):
                flag = True 
                result.append(curr)
            
            
            if flag == False:
                print(curr)
                for i in range(len(curr)):
                    if curr[i].isalpha(): continue
                    newCurr = curr[:i] + curr[i+1:]
                    if newCurr not in set_:
                        q.append(newCurr)
                        set_.add(newCurr)
        return result
    
    def check(self, s):
        count = 0 
        for i in range(len(s)):
            if s[i] == ')' and count == 0 :
                return False 
            elif s[i] == '(':
                count += 1 
            elif s[i] == ')' and count:
                count -= 1 
        
        return count == 0 