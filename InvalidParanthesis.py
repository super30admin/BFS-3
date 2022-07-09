'''
time complexity: exponential, n^n
space compleixty: O(n)
'''
class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        visited = set()
        q = deque([])
        
        q.append(s)
        visited.add(s)
        flag = False
        ans = []
        while(len(q)!=0 and flag!=True):
            sz = len(q)
            for _ in range(sz):
                curr = q.popleft()

                if(self.isValid(curr)):
                    flag = True
                    ans.append(curr)
                if(flag!=True):

                    for i in range(0,len(curr)):
                        if(curr[i].isalpha()): continue
                        newStr = curr[0:i] + curr[i+1:]
                        if(newStr not in visited):
                            q.append(newStr)
                            visited.add(newStr)
        return ans
    def isValid(self,s):
        count = 0
        for i in range(len(s)):
            if s[i]=='(': count+=1
            elif s[i]==')': count-=1
            if(count < 0):
                return False
        return count==0