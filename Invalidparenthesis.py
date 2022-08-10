#301. Remove Invalid Parentheses
"""
Time Complexity : O(n^2) #n for loop, n + n for isValid and check in HashSet
Space Complexity : O(n) #HashSet
"""
class Solution:
    def isValid(self, curr):
            cnt = 0
            for i in curr:
                if i != '(' and i != ')':
                    continue
                
                if i == "(":
                    cnt += 1
                elif i == ")":
                    cnt -= 1
                if cnt < 0:
                    return False
            return cnt == 0
            
    def removeInvalidParentheses(self, s: str) -> List[str]:
        q = deque()
        hs = set()
        
        q.append(s)
        hs.add(s)
        
        flag = False
        result = list()
        
        while len(q) != 0:
            #print(hs)
            curr = q.popleft()
            
            if self.isValid(curr) == True:
                flag = True
                result.append(curr)
            
            if flag == False:
                for j in range(0, len(curr)):
                    
                    if curr[j] != '(' and curr[j] != ')':
                        subStr = curr
                    
                    else:
                        subStr = curr[:j:] + curr[j+1::]

                    if subStr not in hs:
                        q.append(subStr)
                        
                        hs.add(subStr)
                        
        return result
