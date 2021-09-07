
#Time complexity : O(N^N)
#Space complexity : O(N) 
class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        self.maxlen = 0
        self.result = []
        self.visited = set()
        def valid(string):
            count = 0
            for index,item in enumerate(string):
                if item=='(':
                    count+=1
                elif item ==')':
                    count-=1
                else:
                    continue
                if count<0:
                    return False
            return count==0
        
        def backtrack(newstring):
            
            #base
            
            if newstring in self.visited or len(newstring)<self.maxlen:
                return
            if valid(newstring):
                if self.maxlen < len(newstring):
                    self.maxlen = len(newstring)
                    self.result = []
                self.result.append(newstring)
                
            #logic
            self.visited.add(newstring)
            for i in range(len(newstring)):
                char = newstring[i]
                if char.isalpha():continue
                newone = newstring[:i]+newstring[i+1:]
                backtrack(newone)
                newstring = newstring[:i]+char+newstring[i+1:]
                
            
        
        
        
        backtrack(s)
        return self.result