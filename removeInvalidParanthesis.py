from collections import deque

class Solution:
    """DFS Implementation and BFS implementation
    Time Complexity-O(m*n*n)
    Space Complexity-O(n*n)"""
    def __init__(self):
        self.hashset=set()
        self.result=[]
        self.max=0
        
    def removeInvalidParentheses(self, s: str) -> List[str]:
        hashset=set()
        result=[]
        if not s:
            return self.result
        self.dfs(s)
        return self.result
    
    def dfs(self, s):
        if s in self.hashset or len(s)<self.max:
            return
        if self.isValid(s):
            if len(s)>self.max:
                self.result=[]
                self.max=len(s)
            self.result.append(s)
            
        self.hashset.add(s)
        for i in range(len(s)):
            if s[i].isalpha():
                continue
            newstr=s[:i]+s[i+1:]
            self.dfs(newstr)
            
        # q=deque()
        # result=[]
        # flag=False
        # hashset=set()
        # if not s:
        #     return result
        # q.append(s)
        # hashset.add(s)
        # while q and not flag:
        #     size=len(q)
        #     for i in range(size):
        #         string=q.popleft()
        #         if self.isValid(string):
        #             flag=True
        #             result.append(string)
        #         else:
        #             if not flag:
        #                 for j in range(len(string)):
        #                     if string[j].isalpha():
        #                         continue
        #                     str1=string[:j]+string[j+1:]
        #                     if str1 not in hashset:
        #                         q.append(str1)
        #                         hashset.add(str1)
        # return result
    
    def isValid(self,string):
        count=0
        # print(string)
        for i in range(len(string)):
            if string[i]=="(":
                count+=1
            elif string[i]==")":
                if count==0:
                    return False
                count-=1
        return count==0
                
        