# TC: O(2^n)
# SC: O(n)
class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        seen = set()
        q = collections.deque()
        flag = False
        q.append(s)
        seen.add(s)
        ans = []
        
        def isValid(s):
            count = 0
            for i in s:
                if i == '(':
                    count += 1
                elif i == ')':
                    if count == 0:
                        return False
                    count -= 1
            return count == 0
        
        while q and not flag:
            size = len(q)
            
            for i in range(size):
                curr = q.popleft()
                
                if isValid(curr):
                    flag = True
                    ans.append(curr)
                else:
                    if not flag:
                        for j in range(len(curr)):
                            child = curr[0:j] + curr[j+1:]
                            if child not in seen:
                                q.append(child)
                                seen.add(child)
        return ans