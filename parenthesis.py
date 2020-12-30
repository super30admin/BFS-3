#As taught in class using BFS to solve this problem
#Time Complexity: O(e+v)
#Space complexity: O(v)
class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        result = list()
        if s is None:
            return result
        sett = list()
        q = list()
        q.append(s)
        sett.append(s)
        flag = False
        while(len(q)!=0 and flag==False):
            size = len(q)
            for i in range(size):
                current = q.pop()
                if self.isValid(current):
                    flag = True
                    result.append(current)
            if not flag:
                for i in range(size):
                    if current[i].isalpha():
                        continue
                        
                    baby = s[0:i]+s[i+1:]
                    if baby not in sett:
                        sett.append(baby)
                        q.append(baby)
        return result
    
    def isValid(self,s):
        count = 0
        for i in range(len(s)):
            c = s[i]
            if c == "(":
                count += 1
            elif c == ")":
                if count ==0:
                    return False
                else:
                    count -= 0 
        return count ==0
                
        