# Time Complexity: O(n*n!)
# Space Complexity: O(n!)
class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        from collections import deque
        if self.isValid(s): return [s]
        q=deque()
        hset=set()
        q.append(s)
        hset.add(s)
        result=set()
        flag=False 
        while len(q)!=0 and not flag:
            s=len(q)
            for i in range(s):
                cur=q.popleft()
                for j in range(len(cur)):
                    if cur[j].isalpha(): continue
                    cur_str=cur[:j]+cur[j+1:]
                    if cur_str not in hset:
                        if self.isValid(cur_str):
                            flag=True
                            result.add(cur_str)
                            hset.add(cur_str)
                        else:
                            if not flag:
                                q.append(cur_str)
                                hset.add(cur_str)
        return result
                    
    def isValid(self,s):
        count=0
        for i in s:
            if i==')':count-=1
            if i=='(': count+=1
            if count==-1: return False
        if count>0: return False
        else: return True
# # Time Complexity: O(n*n!)
# # Space Complexity: O(n!)
#     def removeInvalidParentheses(self, s: str) -> List[str]:
#         if s==None or len(s)==0: return None
#         self.maxi=float('-inf')
#         self.result=[]
#         self.hmap=set()
#         self.dfs(s)
#         return self.result
#     def dfs(self,s):
        
#         if len(s)<self.maxi: return 
#         if self.isValid(s):
#             if len(s)!=self.maxi:
#                 self.result=[]
#             self.result.append(s)
#             self.maxi=len(s)
#             return
#         for j in range(len(s)):
#             if s[j].isalpha():continue
#             cur=s[:j]+s[j+1:]
#             if cur not in self.hmap:
#                 self.dfs(cur)
#                 self.hmap.add(cur)
              
#     def isValid(self,s):
#         count=0
#         for i in s:
#             if i==')':count-=1
#             if i=='(': count+=1
#             if count==-1: return False
#         if count>0: return False
#         else: return True
    
            