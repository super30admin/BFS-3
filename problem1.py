# problem 1 
# https://leetcode.com/problems/remove-invalid-parentheses/

class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        self.result_arr = []
        self.visited_arr = set()
        self.max_len = 0 
        self.visited_arr.add(s)
        self.dfs(s)
        return self.result_arr 

    def dfs(self,string_ip):
        if len(string_ip) < self.max_len:
            return 
        if self.valid(string_ip):
            if len(string_ip) > self.max_len:
                self.max_len = len(string_ip)
                self.result_arr.clear()
            self.result_arr.append(string_ip) 
        for i in range(len(string_ip)):
            if string_ip[i].isalpha():
                continue 
            baby = string_ip[:i]+string_ip[i+1:]
            if baby not in self.visited_arr:
                self.visited_arr.add(baby)
                self.dfs(baby)

    
    def valid(self,string_ip):
        count = 0 
        for c in string_ip:
            if c.isalpha():
                continue
            if c == '(':
                count+=1 
            else:
                count -=1 
            if count < 0:
                return False 
        if count == 0:
            return True 
        return False