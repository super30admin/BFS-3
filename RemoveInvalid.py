# -*- coding: utf-8 -*-
"""
Created on Wed Mar 18 19:34:35 2020

@author: WELCOME
"""
"""
Remove invalid Paranthesis
Time - O(2^N)
Space - O(N)
"""

from collections import deque
class Solution:
    def validParanthesis(self,s):
        count=0
        for i in s:
            if i=='(':
                count+=1
            elif i==')':
                count-=1
            if count<0:
                return False
        if count==0:
            return True
        else:
            return False
    def removeInvalidParentheses(self, s: str) -> List[str]:
        result=[]
        queue=deque()
        length=len(s)
        queue.append(s)
        flag=False
        DPmemo={}
        while queue:
            size=len(queue)
            if not flag:
                for i in range(size):
                        currNode=queue.popleft()
                        
                        if self.validParanthesis(currNode):
                            flag=True
                            result.append(currNode)
                        if not flag:
                            if currNode not in DPmemo:
                                DPmemo[currNode]=True
                                for z in range(len(currNode)):
                                    queue.append(currNode[0:z]+currNode[z+1:len(currNode)])
            else:
                break
                        
        
        res= list(set(result))
        if len(res)==0:
            return [""]
        else:
            return res
                
        
        
        