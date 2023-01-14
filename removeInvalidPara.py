'''
Time Complexity --> O(n*n!)
Space Compelxity --> O(n)
'''
class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        map = set()
        res = []
        def checkValid(st):
            stk = []
            for i in st:
                if i=='(':
                    stk.append(')')
                elif i==')':
                    if len(stk)==0 or stk[-1]!=')':
                        return False
                    else:
                        stk.pop(-1)
            if len(stk)==0:
                return True
            else:
                return False
        def BFS(s):
            q = [s]
            flag = False
            while q:
                si_ze = len(q)
                for i in range(si_ze):
                    
                    para = q.pop(0)
                    #print(para)
                    for j in range(0, len(para)):
                        st = ''
                        if para[j]>='a' and para[j]<='z':
                            continue
                        if j==0:
                            st = para[j+1:]
                        elif j==len(para)-1:
                            st = para[:j]
                        else:
                            st+= para[0:j]
                            st+=para[j+1:]
                        #print(st,end=' ')
                        if st not in map:
                            map.add(st)
                            q.append(st)
                        else:
                            continue
                        if checkValid(st):
                            res.append(st)
                            flag = True
                if flag ==True:
                    return
                        
        if len(s)==1 and s[0]>='a' and s[0]<='z':
            return s
        if checkValid(s):
            res.append(s)
            return res


        BFS(s)
        return(res)



