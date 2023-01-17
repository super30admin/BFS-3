#Time complexity: O(n^(n+1))
#Space complexity: O(n)
#ran on leetcode: yes
#do a BFS level by level traversal. From each node, neighboring nodes will be all cahrcters which excludes one of the possible characters. When a sequnce becomes valid, then the current level should be the last level to be processed.
class Solution:
    def isValid(self,s):
        count=0
        #print(s)
        
        for i in s:
            if(i=='('):
                count+=1
            elif(i==')'):
                count-=1
                if(count<0):
                    return False
        if(count!=0):
            return False
        return True
    def removeInvalidParentheses(self, s: str) -> List[str]:
        Q=[s]
        seen=set()
        res=[]
        ans_found=False
        if(self.isValid(s)):
            res.append(s)
            return res
        while(Q and not ans_found):
            size=len(Q)
            #print(Q)
            while(size>0):
                curr=Q[0]
                del(Q[0])
                for i in range(len(curr)):
                    if(ord(curr[i])>=97 and ord(curr[i])<123):
                        continue
                    s=""+curr[0:i]+curr[i+1:]
                    if(s not in seen):
                        seen.add(s)
                        #print(seen)
                        
                        if(self.isValid(s)):
                            #print("HERE")
                            res.append(s)
                            ans_found=True
                        else:
                            Q.append(s)
                size-=1
        
        return res
            

