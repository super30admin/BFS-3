#Time O(n!), space O(n)
class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        #BFS
        q=deque()
        hs=set()
        res=[]
        q.append(s)
        #Keeping the track of visited set
        found=False
        
        #Traversing queue
        while q and not found:
            
            for i in range(len(q)):
                
                cur=q.popleft()
                
                #Base
                if self.isValid(cur):
                    res.append(cur)
                    found = True
                
                for j in range(len(cur)):
                    if cur[j]=="(" or cur[j]==")":
                        newString = cur[0:j]+cur[j+1:len(cur)]
                        
                        if newString not in hs:
                            hs.add(newString)
                            q.append(newString)
                            
        return res
    
    
    def isValid(self,st):
        
        l=0
        
        for i in range(len(st)):
            
            if st[i]=="(":
                l+=1
            elif st[i]==")":
                if l==0:
                    return False
                l-=1
                
        return l==0
 
