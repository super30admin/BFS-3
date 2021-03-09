#time: O(2^n)
#space: O(n)

class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        if(s==""):
            return [""]
        q=deque()
        q.append(s)
        result=set()
        sets=set()
        sets.add(s)
        flag=True
        while(q!=deque()):
            size=len(q)
            result=set()
            for i in range(size):
                sol=q.popleft()
                if(self.checkvalid(sol)):
                    result.add(sol)
                else:
                    for j in range(len(sol)):
                        if(sol[j]=="(" or sol[j]==")"):
                            flag=False
                            string=sol[:j]+sol[j+1:]
                            if(self.checkvalid(string)):
                                result.add(string)
                            else:
                                if(string not in sets):
                                    q.append(string)
                                    sets.add(string)
                    
            if(result!=set()):
                break
        
        if(result!=set()):
            return list(result)
        elif(flag):
            return list(s)
        else:
            return [""]
    def checkvalid(self,string):
        stack=[]
        for i in string:
            if i == "(":
                stack.append(i)
            elif(i==")"):
                if(stack==[] or stack.pop()!="("):
                    return False
        if(stack!=[]):
            return False
        return True
                
        
                    
                