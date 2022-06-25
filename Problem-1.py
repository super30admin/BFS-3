class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        q=deque()
        output=[]
        if not s or len(s)==0:
            return output
        q.append(s)
        hashset=set()
        hashset.add(s)
        found=False
        
        def isValid(s):
            count=0
            for char in s:
                if char=='(':
                    count+=1
                elif char==')':
                    if count==0:
                        return False
                    count-=1
                else:
                    continue
            return count==0
        
        while q:
            front=q.popleft()
            
            if isValid(front):
                found=True
                output.append(front)
                
            if not found:
                for i in range(len(front)):
                    if front[i].isalpha():
                        continue
                        
                    sub_s=front[0:i] +front[i+1:]
                    
                    if sub_s not in hashset:
                        hashset.add(sub_s)
                        q.append(sub_s)
                        jj
        return output
                        
            
            