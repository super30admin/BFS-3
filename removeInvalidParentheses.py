class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        
        #BFS to be done so we use a queue
        queue = deque([s])
        
        output = []
        found = False
        visited = set()
        while queue:
            
            # for _ in range(len(queue)):
                curr = queue.popleft()
                if self.isValid(curr):

                        output.append(curr)
                        found = True
                if not found:
                    for i in range(len(curr)):
                        if not curr[i].isalpha():
                            newString = curr[:i]+curr[i+1:]
                            if newString not in visited:
                                visited.add(newString)
                                queue.append(newString)
        
        return output
        
    def isValid(self, s):
        count = 0
        i = 0
        while i<len(s):
            curr = s[i]
            if curr == ")":
                count-=1
            if curr == "(":
                count+=1
            i+=1
            if count<0:
                return False
        return count==0
                
                    
Time: O(2^N)
Space: O(N)
