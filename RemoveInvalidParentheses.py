# TC: O(2 ^ N) as in worst case, we would be exploring 2 options of considering or not considering a character in the valid string. 
# SC: O(N) where N is the size of the queue we use for BFS.

class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        if not s or len(s) == 0: 
            return []
        
        result = []
        queue = collections.deque()
        visited = set()
        queue.append(s)
        visited.add(s)
        flag = False
        
        while queue and not flag:
            size = len(queue)
            for i in range(size):
                curr = queue.popleft()
                if self.isValid(curr): 
                    flag = True
                    result .append(curr)
                    visited.add(curr)
                else:  
                    for j in range(len(curr)): 
                        if curr[j].isalpha(): 
                            continue
                        child = curr[0:j] + curr[j + 1:]
                        if child not in visited: 
                            queue.append(child)
                            visited.add(child)
        return result
    
    def isValid(self, string):
        count = 0 
        for i in string:
            if i.isalpha(): 
                continue
            if i == '(': 
                count += 1
            elif i == ')':
                if count == 0: 
                    return False
                count -= 1
        
        return count == 0
            
            
