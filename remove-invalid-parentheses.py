#---------------- Solution 1 : BFS - stopping at level where we found valid string

''' Time Complexity : O(2^n) 
    Space Complexity : O(2^n * n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No
'''

class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        n = len(s)
        q = deque()
        q.append(s)
        result = []
        visited = set()
        found = False
        while q and not found:
            for i in range(len(q)):
                curr = q.popleft()
                if self.isValid(curr):
                    result.append(curr)
                    found = True
                elif not found:
                    for i in range(len(curr)):
                        if curr[i].isalpha():
                            continue
                        babystr = curr[:i] + curr[i+1:]
                        if babystr not in visited:
                            q.append(babystr)
                            visited.add(babystr)
        return result

    def isValid(self, sub):
        count = 0
        for i in range(len(sub)):
            if sub[i].isalpha():
                continue
            elif sub[i] == ')':
                count -= 1
            else:
                count += 1
            if count < 0:
                return False
        if count == 0:
            return True

        
#---------------- Solution 2 : DFS-------------

''' Time Complexity : O(2^n) 
    Space Complexity : O(2^n * n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No
'''

class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        n = len(s)
        self.result = []
        self.maxlen = 0
        self.found = False
        visited = set()
        def dfs(curr):
            #base
            if len(curr) < self.maxlen:
                return
            
            if self.isValid(curr):
                if len(curr) > self.maxlen:
                    self.maxlen = len(curr)
                    self.result.clear()
                self.result.append(curr)
                return
            #logic
            for i in range(len(curr)):
                if curr[i].isalpha():
                    continue
                babystr = curr[:i] + curr[i+1:]
                if babystr not in visited:
                    visited.add(babystr)
                    dfs(babystr)
            return

        dfs(s)
        return self.result

    def isValid(self, sub):
        count = 0
        for i in range(len(sub)):
            if sub[i].isalpha():
                continue
            elif sub[i] == ')':
                count -= 1
            else:
                count += 1
            if count < 0:
                return False
        if count == 0:
            return True

        