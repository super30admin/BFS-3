class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        '''
        )( - valid 
        criteria for valid - no of opening brackets = no of closing brackets 
        T = O(N)
        S = O(N)
        '''
        q = collections.deque([s])
        # print("q", q)
        res = []
        visited = set()
        visited.add(s)
        found = False
        while q:
            strr = q.popleft()
            if self.isValid(strr):
                # print("strr", strr )
                res.append(strr)
                found = True
            if found: continue
            for i in range(len(strr)):
                if strr[i]=='(' or strr[i]==')':
                    ss = strr[:i] + strr[i+1:]
                    if ss not in visited:
                        q.append(ss)
                        visited.add(ss)
        return res
       
    def isValid(self, s):
        count = 0
        for c in s:
            if c == '(':
                count+=1
            elif c == ')':
                count-=1
            if count<0:
                return False
        return count == 0
