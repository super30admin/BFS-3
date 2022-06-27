class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        
        queue = [s]
        hs = set()
        hs.add(s)
        ans =[]
        flag = False
        while(len(queue)!=0 and flag==False):
            
            for i in range(len(queue)):
                curr = queue.pop(0)
                
                if(self.isValid(curr)):
                    flag = True
                    ans.append(curr)
                elif(flag==False):
                    for i in range(len(curr)):
                        if(curr[i].isalpha()):
                            continue
                        new = curr[0:i]+curr[i+1:]
                        if(new not in hs):
                            hs.add(new)
                            queue.append(new)
        return ans
    
    def isValid(self,curr):
        count = 0
        for i in curr:
            if(i=="("):
                count+=1
            elif(i==")"):
                count-=1
            else:
                continue
            if(count<0):
                return False
        return count==0