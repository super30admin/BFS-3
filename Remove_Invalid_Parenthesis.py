#Time:O(2^N)
#Space:O(N)
class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        
        self.visited = set()
        self.ans = []
        def isvalid(string_val):
            count=0
            for i in range(len(string_val)):
                if string_val[i] == "(":
                    count+=1
                elif string_val[i] == ")":
                    count-=1
                if count<0:
                    return False
            return True if count==0 else False
        self.max_string = 0
        self.original_string = s
        def dfs(string_val):
            if string_val == "":
                return
            if isvalid(string_val):
                if len(string_val)>self.max_string:
                    self.max_string=len(string_val)
                    self.ans = []
                if len(string_val)==self.max_string and len(string_val)>0:
                    self.ans.append(string_val)
                return
            for i in range(len(string_val)):
                if string_val[i].isalpha():
                    continue
                if string_val[:i]+string_val[i+1:] not in self.visited:
                    self.visited.add(string_val[:i]+string_val[i+1:])
                    dfs(string_val[:i]+string_val[i+1:])
        dfs(s)
        return [""] if not self.ans else self.ans