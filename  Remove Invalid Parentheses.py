# time complexity is o(n*n!), where n is the size of the input
# space complexity is o(n*n!), where n is the size of the input
class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        #         bfs
    #time complexity is o(n * n!)
        from collections import deque
        newSet = set()
        q = deque()
        q.append(s)
        res = list()
        levelCheck = False
        while(len(q) != 0):
            curr = q.popleft()
            if(not self.isValid(curr)):
                if(levelCheck == False):
                    for i in range(len(curr)):
                        if(curr[i].isalpha()):
                            continue
                        else:
                            temps = curr[0:i] + curr[i+1:]
                            if(temps not in newSet):
                                newSet.add(temps)
                                q.append(curr[0:i] + curr[i+1:])
                               
            else:
                levelCheck = True
                res.append(curr)
        return res
                
    def isValid(self, curr):
        count = 0
        for i in range(len(curr)):
            if(curr[i].isalpha()):
                continue
            else:
                if(curr[i] == '('):
                    count += 1
                else:
                    if(count == 0):
                        return False
                    count -= 1
        return count == 0
                
        
        # dfs
#         if(len(s) == 0):
#             return None
#         self.max = 0
#         self.newSet = set()
#         self.result = []
#         self.dfs(s)
#         return self.result
    
#     def isValidParentheses(self, s):
#         count = 0
#         for i in range(len(s)):
#             if(s[i].isalpha()):
#                 continue
#             elif(s[i] == '('):
#                 count += 1
#             else:
#                 if(count == 0):
#                     return False
#                 count -= 1
#         return count == 0
                    
                    
#     def dfs(self, s):
#         #base
#         if(len(s) < self.max):
#             return 
#         if(s in self.newSet):
#             return
#         #logic
#         self.newSet.add(s)
#         if(self.isValidParentheses(s)):
#             if(self.max != len(s)):
#                 self.result = []
#             self.max = len(s)
#             self.result.append(s)
#         else:
#             for i in range(len(s)):
#                 if(s[i].isalpha()):
#                     continue
#                 tempStr = s[0:i] + s[i+1:]
#                 self.dfs(tempStr)
    
                
        
        
    

            
        
        