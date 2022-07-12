'''
Using BFS
Time: O(n^n)
Space: O(n) best or O(n^n) worst
'''


class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        
        if s == '' or len(s) == 0:
            return []
        
        res = []
        q = collections.deque()
        hs = set()
        q.append(s)
        hs.add(s)
        
        flag = False
        
        while len(q) != 0 and flag == False:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                if self.isValid(curr):
                    res.append(curr)
                    flag = True
                if flag == False:
                    for i in range(len(curr)):
                        if curr[i].isalpha():
                            continue
                        ns = curr[:i] + curr[i+1:]
                        if ns not in hs:
                            q.append(ns)
                            hs.add(ns)
        return res
                    
    
    def isValid(self, s):
        count = 0
        for ch in s:
            if ch == '(':
                count += 1
            elif ch == ')':
                count -= 1
            else:
                continue
            
            if count < 0:
                return False
        
        return count == 0

'''
Using DFS
Time: O(n^n)
Space: O(n) and recursive stack (max depth will be n)
'''
class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        
        if s == '' or len(s) == 0:
            return []
        
        self.max = 0
        self.res = list()
        self.hs = set()
        
        self.dfs(s)
        return self.res
        
    def dfs(self, s):
        # base
        if s in self.hs and len(s) < self.max:
            return
        
        if self.isValid(s):
            if len(s)  == self.max:
                self.res.append(s)
                self.hs.add(s)
            elif len(s) > self.max:
                self.res = list()
                self.res.append(s)
                self.max = len(s)
                self.hs.add(s)
            return
            
        
        # logic
        self.hs.add(s)
        
        for i in range(len(s)):
            if s[i].isalpha():
                continue
            
            nw = s[:i] + s[i+1:]
            if nw not in self.hs:
                self.dfs(nw)
                    
    
    def isValid(self, s):
        count = 0
        for ch in s:
            if ch == '(':
                count += 1
            elif ch == ')':
                count -= 1
            else:
                continue
            
            if count < 0:
                return False
        
        return count == 0