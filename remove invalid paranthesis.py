# Time Complexity: O(n*n!)
# Space Complexity: O(n!)
class Solution:
    def removeInvalidParentheses(self, s):
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

''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
#with out size of q:
# Time Complexity: O(n*n!)
# Space Complexity: O(n!)
# class Solution:
#     def removeInvalidParentheses(self, s):
#         from collections import deque
#         if self.isValid(s): return [s]
#         q=deque()
#         hset=set()
#         q.append(s)
#         hset.add(s)
#         result=set()
#         flag=False 
#         while len(q)!=0 :
#                 cur=q.popleft()
#                 for j in range(len(cur)):
#                     if cur[j].isalpha(): continue
#                     cur_str=cur[:j]+cur[j+1:]
#                     if cur_str not in hset:
#                         if self.isValid(cur_str):
#                             flag=True
#                             result.add(cur_str)
#                             hset.add(cur_str)
#                         else:
#                             if not flag:
#                                 q.append(cur_str)
#                                 hset.add(cur_str)
#         return result
                    
#     def isValid(self,s):
#         count=0
#         for i in s:
#             if i==')':count-=1
#             if i=='(': count+=1
#             if count==-1: return False
#         if count>0: return False
#         else: return True

''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
#dfs
# Time Complexity: O(n*n!)
# Space Complexity: O(n!)

# class Solution:
#     def removeInvalidParentheses(self, s):
#         if s==None or len(s)==0: return None
#         self.maxi=float('-inf')
#         self.result=[]
#         self.hmap=set()
#         self.dfs(s)
#         return self.result
#     def dfs(self,s):
#         if s in self.hmap: return
#         if len(s)<self.maxi: return 
#         self.hmap.add(s)
#         if self.isValid(s):
#             if self.maxi<len(s):
#                 self.result=[]
#             self.result.append(s)
#             self.maxi=len(s)
#         else:
#             for j in range(len(s)):
#                 if s[j].isalpha():continue
#                 cur=s[:j]+s[j+1:]
#                 self.dfs(cur)
                   
              
#     def isValid(self,s):
#         count=0
#         for i in s:
#             if i==')':count-=1
#             if i=='(': count+=1
#             if count==-1: return False
#         if count>0: return False
#         else: return True