#Time Complexity :O(n^n) 
#Space Complexity :O(n^n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

from collections import deque
class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        result=[]
        q=deque()
        strset=set()
        q.append(s)
        strset.add(s)
        flag=False
        while q and not flag:
            size=len(q)
            for i in range(size):
                curr=q.popleft()
                if self.isValid(curr):
                    flag=True
                    result.append(curr)
                else:
                    if not flag:
                        for k in range(0,len(curr)):
                            if curr[k].isalpha():
                                 continue
                            baby=curr[0:k]+curr[k+1:]
                            if baby not in strset:
                                q.append(baby)
                                strset.add(baby)
        return result

    def isValid(self,string):
        count=0
        for s in string:
            if s.isalpha():
                continue
            if s=='(':
                count+=1
            else:
                if count==0:
                    return False
                count-=1
        return count==0

        