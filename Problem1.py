class Solution:
    
    """
    
        Name : Shahreen Shahjahan Psyche
        Time : O(N*2^N) [Remove/Not Remove - 2 options]
        Space: O(N)
        
        Passed All Test Cases in LC : Yes
        
        Approach : # Here we are doing backtracking using BFS. Cause our goal is to get the minimum number of parenthesis removing. So, thee distance from 
                     root should be minimized. 
                   # We initilize a queue and push the string
                   # Inside the queue, we pop the value, check its validity and if valid then add it to the result list and visited set. Also we create a flag
                     which we assign to False as we do not need to travarse into the next level or next depth
                   # Finally, we return the resultant array
    
    
    """
    
    # Checking the validity of the string
    def isValid(self, string):
        count = 0
        for i in range(len(string)):
            if string[i] == "(":
                count += 1
            elif string[i] == ")":
                count -= 1
            if count < 0:
                return False
        if count > 0:
            return False
        return True
        
    
    def removeInvalidParentheses(self, s: str) -> List[str]:
        # edge case
        if not s:
            return [""]
        
        from collections import deque
        
        q = deque()
        res = []
        visited = set()
        q.append(s)
        index = 0
        flag = True
        
        while q and flag:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                is_valid = False
                is_valid = self.isValid(curr)
                if is_valid == True:
                    if curr not in visited:
                        visited.add(curr)
                        res.append(curr)
                    flag = False
                for j in range(len(curr)):
                    st = ""
                    if curr[j] == "(" or curr[j] == ")":
                        if j < len(curr)-1:
                            st = curr[0:j]+curr[j+1:len(curr)]
                        else:
                            st = curr[0:j]
                        q.append(st)
        
        if len(res) == 0:
            res = [""]
        
        return res
                
        
        
        
        
        
        
