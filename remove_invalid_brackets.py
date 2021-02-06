class Solution(object):
    def removeInvalidParentheses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        #O(exponential)> each bracket can be considered or removed> 2choices
        #O(n)
        res=[]
        if not s:
            return [""]
        myset=set()
        q=deque()
        #at level 1, all strings with one char removed>
        #at level 2> 2chars removed
        q.append(s)
        #visited set
        myset.add(s)
        flag=False
        while q:
            cur=q.popleft()
            if self.isValid(cur):
                res.append(cur)
                #here flag is helping to remove min number of brackets to give valid string
                flag=True
            if not flag:
                for j in range(len(cur)):
                    #if alpha character, just keep it in final string
                    if cur[j].isalpha():
                        continue
                    #make substring by removing jth bracket
                    baby=cur[0:j]+cur[j+1:]
                    if baby not in myset:
                        q.append(baby)
                        myset.add(baby)      
        return res 
    
    def isValid(self,check):
        cnt=0
        for i in check:
            if i =="(":
                cnt+=1
            elif i==")":
                #if by now valid > and without open bracket comes only the closing bracket
                if cnt==0:
                    return False
                cnt-=1
            
        if cnt==0:
            return True
        return False
            
        
                
            
        