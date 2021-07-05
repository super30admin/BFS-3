"""1. Remove Invalid Parentheses
Time Complexity: 0(2^n) - choose or not choose
Space Complexity: O(n)
Apprroach -> BFS and use a hashset to prevent adding same string"""
class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        output =[]
        if s is None or len(s)==0:
            return output
        
        #add initial string to
        queue =[]
        queue.append(s)
        hashset = set()
        hashset.add(s)
        found = False
        
        while queue and not found:
            size = len(queue)
            for i in range(size):
                curr = queue.pop(0)
                if self.isvalid(curr):
                    found =True
                    output.append(curr)
                # not valid case
                if not found:
                    for k in range(len(curr)):
                        if curr[k].isalpha():
                            continue
                        newString = curr[:k]+curr[k+1:]
                        
                        if newString not in hashset:
                            hashset.add(newString)
                            queue.append(newString)
        return output
                
                            
                    
    def isvalid(self,s):
        count = 0
        for ch in s:
            if ch =="(":
                count+=1
            elif ch ==")":
                if count == 0: return False
                count-=1
        return count==0
            
        