# Time:- O(2^n)
# Space:- O(n)
# Approach:- Start doing a bfs. Remove one charachter check if it gives a valid parentheses. If 
# it does give a valid parentheses we need to explore only the children at this level because 
# we need to give out all such string with that number of deletions. Continue to find all such 
# strings. Edge case:- We may not have to delete anything to form a valid parentheses string
class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        q=collections.deque([])
        if s=="":
            return [""]
        q.append(s)
        res=[]
        seen=set()
        # if set to true we wont explore the next level
        self.found=False
        def validparentheses(string):
            ctr=0
            for i in string:
                if i=='(':
                    ctr+=1
                elif i==')':
                    ctr-=1
                if ctr<0:
                    return False
            return ctr==0
        # Edge case
        if validparentheses(s):
            return [s]
        while(q and not self.found):
            size=len(q)
            for i in range(size):
                ele=q.popleft()
                for i in range(len(ele)):
                    if ele[i].isalpha():
                        continue
                    newstr=ele[:i]+ele[i+1:]
                    if newstr not in seen:
                        if validparentheses(newstr):
                            self.found=True
                            res.append(newstr)
                        else:
                            q.append(newstr)
                        seen.add(newstr)
        return res