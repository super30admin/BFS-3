# Time complexity - O(n^n)
#  Space complexity - O(n^n)
class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        st=set()
        q=deque()
        res=[]
        q.append(s)
        st.add(s)
        flag=False
        while(q):
            size=len(q)
            for i in range(size):
                c=q.popleft()
                if(self.isValid(c)):
                    flag=True
                    res.append(c)
                else:
                    if(not flag):
                        for j in range(len(c)):
                            ct=c[j]
                            if(ct.isalpha()):
                                pass
                            else:
                                child=c[:j]+c[j+1:]
                                if (child not in st):
                                    q.append(child)
                                    st.add(child)
        return res
    
    def isValid(self, s):
        ct=0
        for i in s:
            if i == "(":
                ct+=1
            elif i == ")":
                if ct == 0 :
                    return False
                ct-=1
        
        if ct ==0:
            return True
        else:
            return False
            