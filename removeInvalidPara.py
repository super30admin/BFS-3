#Time complexity: O(n.n!)
#Space complexity: O(n)

class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        q = deque()
        hSet = set()
        q.append(s)
        hSet.add(s)
        flag = False
        res = []
        while q:
            # size = len(q)
            # for i in range(size):
            curr = q.popleft()
            if self.isValid(curr):
                flag = True
                res.append(curr)
            if not flag:
                for j in range(len(curr)):
                    if curr[j].isalpha():
                        continue
                    subS = curr[:j]+curr[j+1:]
                    if subS not in hSet:
                        q.append(subS)
                        hSet.add(subS)
        return res
    
    def isValid(self, s):
        cnt = 0
        for i in range(len(s)):
            if s[i].isalpha():
                continue
            if s[i] == "(":
                cnt += 1
            elif s[i] == ")":
                cnt -= 1
            if cnt < 0:
                return False
        return cnt == 0
