class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        
        if not s:
            return []
        n = len(s)
        result = []
        q = deque()
        q.append(s)
        found = False
        baby_set = set()
        
        while q :
            size = len(q)
            for  i in range(size):
                #print(baby_set)
                curr = q.popleft()
                print(curr)
                if self.isValid(curr):
                    found = True
                    result.append(curr)
                    #print(result)
                
                if not found:
                    for j in range(len(curr)):
                        if str.isalpha(curr[j]):
                            continue
                        baby = curr[:j]+ curr[j+1:]
                        if baby not in baby_set:
                            baby_set.add(baby)
                            q.append(baby)
                
        return result
                    
                
    def isValid(self,curr):
        count = 0
        for i in range(len(curr)):
            if curr[i] == '(':
                count +=1
            elif curr[i] == ')':
                count -=1
            if count < 0:
                return False
        
        if count == 0:
            return True
        else:
            return False
                           
                
            
            
            
