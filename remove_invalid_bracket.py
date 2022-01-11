# // Time Complexity :O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach



class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        q=[]
        q.append(s)
        
        hset=[]
        hset.append(s)
        flag=False
        res=[]
        while q:
            curr=q.pop(0)
            # print(curr)
            if self.isvalid(curr):
                flag=True
                res.append(curr)
            if not flag:
                # print(len(curr),curr)
                for i in range(len(curr)):
                    if curr[i] != '(' and curr[i] != ')':
                        continue
                    
                    st=curr[:i]+curr[i+1:]
                    
                    if st not in hset:
                        hset.append(st)
                        q.append(st)
                        # print(st)
        return res
    def isvalid(self,curr):
        count=0
        for i in curr:
            
            if i=='(':
                count+=1
            elif i==')':
                count-=1
            if count==-1:
                return False
        return count==0
            