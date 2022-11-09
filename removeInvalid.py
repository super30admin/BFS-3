#Time: O(n^2)
#Space: O(n^2)
#Program ran on leetcode successfully

class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        res = []
        if s is None or len(s) == 0:
            return res
        q = []
        stringSet = set()
        q.append(s)
        stringSet.add(s)
        flag = False
        while (q and not flag):
            size = len(q)
            for i in range(size):
                tmp = q.pop(0)
                if (self.isValid(tmp)):
                    res.append(tmp)
                    flag = True
                if (not flag):
                    for j in range(len(tmp)):
                        c = tmp[i]
                        if (c.isalpha()):
                            continue
                        child = c[0:j-1] + c[j:]
                        if child not in stringSet:
                            q.append(child)
                            stringSet.add(child)
        
        return res
    
    def isValid(self, s: str):
        count = 0
        for i in range(len(s)):
            c = s[i]
            if c.isalpha(): 
                continue
            if c == '(': 
                count += 1
            elif c == ')':
                count += -1
            if count < 0:
                return False
        
        return count == 0
        
        