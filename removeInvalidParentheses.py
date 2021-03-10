# Time Complexity : Exponential
# Space Complexity : Exponential O(2^n*n)
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        res = []
        
        if not s:
            return [""]
        
        seen = set()
        queue = deque([])
        
        flag = False
        queue.append(s)
        seen.add(s)
        
        while queue:
            size = len(queue)
            for i in range(size):
                curr = queue.popleft()
                if self.isValid(curr):
                    res.append(curr)
                    flag = True
                if not flag:
                    #add children
                    for i in range(len(curr)):
                        if curr[i].isalpha():
                            
                            continue
                        baby = curr[:i] + curr[i+1:]
                        if baby not in seen:
                            queue.append(baby)
                            seen.add(baby)
        return res
    def isValid(self, s):
        count = 0
        for i in range(len(s)):
            c = s[i]
            if (c == '('):
                count += 1
            elif c == ')':
                if count == 0:
                    return False
                count -= 1
        return count == 0