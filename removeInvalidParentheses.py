# TimeComplexity:O(n × 2^n) : for worst case of striung size n we generate 2^n possiblites and we should validate if everytime
# SpaceComplexity:O(n × 2^n) for queue and set
# # s = "(((((((((((((" this is worst case
# Approach: we can genarate all possible combiantions and check if they are valid or not .
# we can also use bfs and dfs for this .BFS finds answer quickly as we are processing level by level


class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        #doing bfs with both result and visted as set to no check repeates
        def validate(s):
            #return true if is valid
            count=0
            for i in s:
                if i=="(":
                    count+=1
                elif i==")":
                    count-=1
                if count<0:return False

            if count !=0: return False
            return True
        

        q=deque([s])
        ans=set()
        visted=set()
        toggle=False
        ansl=0
        while(len(q)):
            l=len(q)
            for _ in range(l):
                subS=q.popleft()
                if subS not in visted and  validate(subS)==True :
                    if toggle==False:
                        ans.add(subS)
                        visted.add(subS)
                        toggle=True
                        ansl=max(len(subS),ansl)
                    elif len(subS)==ansl: 
                        ans.add(subS)
                        visted.add(subS)



                elif toggle== False and subS not in visted :
                    visted.add(subS)
                    for i in range(len(subS)):
                        if subS[i].isalpha():continue
                        p=subS[:i]+subS[i+1:]
                        if p not in visted:
                            q.append(p)
        return list(ans)    
                    
            

