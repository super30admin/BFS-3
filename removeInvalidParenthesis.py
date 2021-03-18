class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        '''
        Time Complexity: O(n^2*2^n)
        Space Complexity: O(N)
        '''
        def isValid(s):
            c=0
            for i in range(0,len(s)):
                if(s[i]=="("):
                    c+=1
                elif(s[i]==")"):
                    if(c==0):
                        return False
                    c-=1
            return c==0
        
        if(len(s)==0):
            return [""]
        o = []
        q = deque([])
        q.append(s)
        visited = set()
        found = False
        while len(q)>0:
            size = len(q)
            for k in range(0,size):
                ex = q.popleft()
                if(isValid(ex)):
                    o.append(ex)
                    found = True
                if found:
                    continue
                for i in range(len(ex)):
                    if ex[i] not in '()':
                        continue
                    baby = ex[:i] + ex[i+1:]
                    if baby not in visited:
                        q.append(baby)
                    visited.add(baby)  
            
        return o
