# Time Complexity : O(2^n) 
# Space Complexity :O(2^n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
# Fro the problem we know 2 things:
#   1) We dont need duplicate valid parenthesis substring. So we use set. 
#   2) We dont know how many minimum parenthesis to remove. It can be 1 or many. 
#      So until we get atlist 1 valid parenthesis substring we find all the 
#      remaining substring combinations using the for loop until we hit True.
#   3) Then we stop for that level as we found the minimum number of brackets that we removed. 
#      We dont care about other possible answers.

class Solution:
    def removeInvalidParentheses(self, s):
        result = []
        if len(s) == None :
            return result 
        q = [s]                     # Space = O(2^n), as we will choose not choose, and somany such substring will be in the q.        
        flag = False 
        set_ = set()
        while len(q) != 0 :
            curr = q.pop(0)
            res = self.check(curr)       

            if (res):
                flag = True 
                result.append(curr)
            
            # Run this Loop until we find a valid parenthesis substring.
            if flag == False:
                print(curr)
                for i in range(len(curr)):
                    if curr[i].isalpha(): continue
                    newCurr = curr[:i] + curr[i+1:]
                    if newCurr not in set_:
                        q.append(newCurr)
                        set_.add(newCurr)
        return result
    
    # helper function to check the substring.    
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

if __name__ == "__main__":
    s = Solution()
    
    # Test case 1:
    print(s.removeInvalidParentheses("()())()"))
    
    # Test case 2:
    print(s.removeInvalidParentheses("(a)())()"))
    
    # Test case 3:
    print(s.removeInvalidParentheses(""))