# Time Complexity : O(n*n!)
# Space Complexity : O(n!)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        if self.isValid(s): return [s]
        
        q = deque()
        visited = set()
        result = set()
        
        visited.add(s)
        q.append(s)
        flag = False
        
        while q and not flag:
            s = len(q)
            for i in range(s):
                cur = q.popleft()
                for j in range(len(cur)):
                    if cur[j].isalpha(): continue
                    cur_str = cur[:j] + cur[j+1:]
                    
                    if cur_str not in visited:
                        if self.isValid(cur_str):
                            flag=True
                            result.add(cur_str)
                            visited.add(cur_str)
                        else:
                           
                            if not flag:
                                q.append(cur_str)
                                visited.add(cur_str)
        return result
    
    def isValid(self, s):
        count=0
        for i in s:
            if i==')': count-=1
            elif i=='(': count+=1
            if count==-1: return False
        return not count > 0