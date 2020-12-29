"""
TC  O(2^n)
SC  O(N)
BFS to get valid str level by level by removing one ch at each level in different index in a level

"""

class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        res=[]
        visited=set()
        q=[]
        q.append(s) #root is original string 
        visited.add(s)
        flag=False # Bool to track if valid string found at level l
        while q and not flag:
            size=len(q)
            for _ in range(size):
                curr=q.pop(0)
                
                if(self.isValid(curr)):
                    flag=True
                    res.append(curr)
                if not flag:#if True, the string is valid so we dont need to go further leves.
                    for i in range(len(curr)):
                        if curr[i] not in '()': #if its alphabet 'a'
                            continue
                        baby=curr[0:i]+curr[i+1:] #take substr removing one ch
                       
                        if baby not in visited:
                            q.append(baby)
                            visited.add(baby)
        return res
    
    def isValid(self,word):
        count=0
        for i in range(len(word)):
            ch=word[i]
            if(ch=="("):
                count+=1
            elif(ch==')'):
                if(count==0):
                    return False
                else:
                    count-=1
        return count==0
                            
            
            

        
        
        