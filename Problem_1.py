class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        result = []
        if s == None or len(s) == 0:
            return result
        
        q = deque()
        hashset = set()
        flag = False
        q.append(s)
        hashset.add(s)
        
        while q and not flag:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                if self.isValid(curr):
                    flag = True
                    result.append(curr)
                else:
                    for j in range(len(curr)):
                        if curr[j].isalpha():
                            continue
                        child = curr[0:j] + curr[j+1:]
                        if child not in hashset:
                            q.append(child)
                            hashset.add(child)
        return result
    
    def isValid(self, s):
        count = 0
        for i in range(len(s)):
            if s[i] == ')':
                if count == 0:
                    return False
                count -= 1
            elif s[i] == '(':
                count += 1
        return count == 0

# Time Complexity: O(2^n)
# Space Complexity: O(n*n)