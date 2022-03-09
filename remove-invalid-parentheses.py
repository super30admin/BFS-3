'''
TC: O(2^n)
SC: O(n)
'''
from collections import deque

class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        if not s:
            return []
        
        slen = len(s)
        flag = False
        q = deque()
        res = list()
        
        q.append(s)
        q.append(None)
        visited = set()
        visited.add(s)
        
        def isValid(elem):
            count = 0
            for i in elem:
                if i.isalpha():
                    continue
                if i == "(":
                    count += 1
                else:
                    if count <= 0:
                        return False
                    count -= 1
            
            return count == 0
        
        while q:
            top = q.popleft()
            if top == None:
                if flag or not q:
                    break
                q.append(None)
                continue
            if not isValid(top):
                if not flag:
                    for i in range(len(top)):
                        if top[i].isalpha():
                            continue
                        news = top[:i] + top[i+1:]
                        if news not in visited:
                            visited.add(news)
                            q.append(news)
            else:
                flag = True
                res.append(top)
        
        return res
        