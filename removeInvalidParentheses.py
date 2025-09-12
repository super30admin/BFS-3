class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        def isValid(s):
            count=0
            for char in s:
                if char=='(':
                    count+=1
                if char==')':
                    count-=1
                
                if count<0:
                    return False
            
            return count==0
        

        q=deque([s])
        flag=False
        res=[]
        hset=set()
        hset.add(s)
        while q and not flag:
            size=len(q)
            for _ in range(size):
                curr=q.popleft()
                #print(curr)
                if isValid(curr):
                    flag=True
                    res.append(curr)
                
                elif not flag:
                    for j in range(len(curr)):
                        baby=curr[:j]+curr[j+1:]
                        #print(baby)
                        if baby not in hset:
                            hset.add(baby)
                            q.append(baby)
                            #print(q)
        
        return res
