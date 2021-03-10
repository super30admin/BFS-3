from collections import deque

class Solution:
    #Solution 1
    def removeInvalidParentheses(self, s: str) -> List[str]:
        #Approach: BFS
        #Time Complexity: O(2^n * n^2)
        #Space Complexity: O(2^n * n)
        #where, n is the length of the string s
        
        #a little optimization for validity check
        alpha_count = 0
        for char in s:
            if char.isalpha():
                alpha_count += 1
        
        de = deque()
        visited = set()
        result = []
        
        de.append(s)
        visited.add(s)
        
        while de:
            sz = len(de)  # don't actually need since we stop appending after first solution
            for _ in range(sz):
                popped = de.popleft()
                if self.isValid(popped, alpha_count):
                    result.append(popped)
                
                if not result:
                    for i in range(len(popped)):
                        if popped[i].isalpha():
                            continue
                        new = popped[:i] + popped[i+1:]
                        if new not in visited:
                            de.append(new)
                            visited.add(new)
        
        return result
    
    #Solution 2
    """
    def removeInvalidParentheses(self, s: str) -> List[str]:
        #Approach: Backtracking w/ pruning
        #Time Complexity: O(2^n * n^2)
        #Space Complexity: O(2^n * n)   //  because of 'visited'
        #where, n is the length of the string s
        
        #a little optimization for validity check
        self.alpha_count = 0
        for char in s:
            if char.isalpha():
                self.alpha_count += 1
        
        self.result, self.length = [], 0
        self.visited = set()
        
        self.dfs(list(s))
        self.visited.add(s)
        
        return self.result
    
    def dfs(self, sb):
        #base
        if self.isValid(sb, self.alpha_count) and len(sb) > self.length:
            self.result = [''.join(sb)]
            self.length = len(sb)
            return
            
        elif self.isValid(sb, self.alpha_count) and len(sb) == self.length:
            self.result.append(''.join(sb))
            return
            
        elif not sb:
            return
        
        #logic
        for i in range(len(sb)):
            if sb[i].isalpha():
                continue
            
            removed = sb.pop(i)             #action
            if ''.join(sb) not in self.visited:
                self.dfs(sb)                #recursion
                self.visited.add(''.join(sb))
            sb.insert(i, removed)           #backtracking
    """
    
    #Solution 3
    """
    def removeInvalidParentheses(self, s: str) -> List[str]:
        #Approach: Backtracking w/ pruning
        #Time Complexity: O(2^n * n^2)
        #Space Complexity: O(n)
        #where, n is the length of the string s
        
        #a little optimization for validity check
        self.alpha_count = 0
        for char in s:
            if char.isalpha():
                self.alpha_count += 1
        
        self.result, self.length = [], 0
        self.dfs(list(s))
        
        return self.result
    
    def dfs(self, sb):
        #base
        if self.isValid(sb, self.alpha_count) and len(sb) > self.length:
            self.result = [''.join(sb)]
            self.length = len(sb)
            return
            
        elif self.isValid(sb, self.alpha_count) and len(sb) == self.length:
            if ''.join(sb) not in self.result:
                self.result.append(''.join(sb))
            return
            
        elif not sb:
            return
        
        #logic
        for i in range(len(sb)):
            if sb[i].isalpha():
                continue
            
            removed = sb.pop(i)             #action
            self.dfs(sb)                    #recursion
            sb.insert(i, removed)           #backtracking
    """
        
    def isValid(self, s, alpha_count):
        if (len(s) - alpha_count) % 2 != 0:
            return False
        
        count = 0
        for char in s:
            if char == '(':
                count += 1
            elif char == ')':
                count -= 1
                
            if count < 0:
                return False
            
        return count == 0