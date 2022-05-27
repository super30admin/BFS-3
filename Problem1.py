#Time Complexity : O(2**N)
#Space Complexity : O(N)
#Did this code successfully run on Leetcode : YES
#Any problem you faced while coding this : NO
class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        if s == None:
            return ""
        queue = []
        res = []
        sett = set()
        queue.append(s)
        sett.add(s)
        flag = False
        while queue and not flag:
            size = len(queue)
            for i in range(size):
                curr = queue.pop(0)
                result = self.isValid(curr)
                if result == True:
                    res.append(curr)
                    flag = True
                
                if flag == False:
                    for j in range(len(curr)):
                        child = curr[0:j] + curr[j+1:]
                        if child not in sett:
                            sett.add(child)
                            queue.append(child)
                            
        return res
        
    def isValid(self,strr):
        count = 0
        for i in strr:
            if i.isalpha():
                continue
            if i == '(':
                count +=1
            elif i == ')':
                count -=1
            if count < 0:
                return False
        return count == 0
        
        
        
    