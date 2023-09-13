# Time Complexity :O(N^N)
# Space Complexity :O(N^N*N)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach


from collections import deque
class Solution:

    def isValid(self, s):
        count=0
        for i in s:
            if(i=='('):
                count+=1
            else:
                if(count==0 and i==')'):
                    return False
                if(i==')'):
                    count-=1
        if(count==0):
            return True
        return False
    
    def removeInvalidParentheses(self, s: str) -> List[str]:
        # print("test", self.isValid("(())()"))
        q=deque()
        result=[]
        f=False
        q.append(s)
        st_set=set()
        st_set.add(s)
        while(len(q) and f==False):
            size=len(q)
            for i in range(size):
                curr=q.popleft()
                # print("cjheck",curr)
                if(self.isValid(curr)):
                    f=True
                    result.append(curr)
                    
                elif(not f):
                    for i in range(len(curr)):
                        if(curr[i].isalpha()):
                            continue
                        mutated=curr[:i]+curr[i+1:]
                        if(mutated not in st_set):
                            st_set.add(mutated)
                            q.append(mutated)
            # print(q)
        # print(st_set)
        return result
