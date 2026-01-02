class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        #bfs - choose not choose each one and check isvalid
        def isValid(s):
            count = 0
            for i in range(len(s)):
                if s[i] == "(":
                    count += 1
                elif s[i] == ")":
                    if count <= 0:
                        return False
                    count-=1
            return count==0
    
        result = []
        q = deque([s])
        hashset = set([s])
        flag = False

        while q and flag == False:
            l = len(q)
            for i in range(l):
                cur = q.popleft()

                if isValid(cur):
                    result.append(cur)
                    flag=True
                
                for j in range(len(cur)):
                    if cur[j] in "()":
                        new_s = cur[:j] + cur[j+1:]
                        if new_s not in hashset:
                            q.append(new_s)
                            hashset.add(new_s)
        return result
