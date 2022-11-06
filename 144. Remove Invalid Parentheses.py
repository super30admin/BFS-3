#Time Complexity: O(n^n)
#Space Complexity: O(n^n)

#----------------------------BFS-----------------------------
class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        result = []
        if len(s) == 1 and s[0].isalpha(): 
            result.append(s)
            return result
        if len(s) == 0 or s is None:
            return result
        
        hashset = set([])
        # maximum = 0
        queue = []
        queue.append(s)
        flag = False
        while queue and flag != True:
            size = len(queue)
            for i in range(size):
                curr = queue.pop(0)
                if self.isValid(curr):
                    result.append(curr)
                    flag = True
                if flag != True:
                    for j in range(len(curr)):
                        if curr[j].isalpha(): continue
                        child = curr[0:j] + curr[j+1:]
                        if child not in hashset:
                            queue.append(child)
                            hashset.add(child)
        return result
        
    def isValid(self, s):
        count = 0
        for i in s:
            if i.isalpha(): continue
            if i == "(": count += 1 
            elif i == ")": count -= 1
            if count<0: return False
        return count == 0


#----------------------------DFS-----------------------------
class Solution:
    def __init__(self):
        self.flag = False
        self.result = []
        self.maximum = 0
        
    def removeInvalidParentheses(self, s: str) -> List[str]:
        if len(s) == 0 or s is None:
            return self.result
        
        hashset = set([])
        self.helper(s, hashset)
        return self.result
        
    def helper(self, curr, hashset):
        #base
        if len(curr) < self.maximum or curr in hashset: return
        
        #logic
        if self.isValid(curr):
            if len(curr) > self.maximum:
                self.maximum = len(curr)
                self.result = []
            hashset.add(curr)
            self.result.append(curr)
            
        hashset.add(curr)
        if self.flag != True:            
            for j in range(len(curr)):
                    if curr[j].isalpha(): continue
                    child = curr[0:j] + curr[j+1:]
                    self.helper(child, hashset)
                    
    def isValid(self, s):
        count = 0
        for i in s:
            if i.isalpha(): continue
            if i == "(": count += 1 
            elif i == ")": count -= 1
            if count<0: return False  
        return count == 0