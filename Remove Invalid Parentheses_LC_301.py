class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        if len(s)==0 or s==None:
            return []

        que=[]
        result=[]
        flag=False 
        dic=set()
        que.append(s)

        while que!=[] and flag==False:
            size=len(que)

            for i in range(size):
                curr=que.pop(0)
                if self.isValid(curr):
                    result.append(curr)
                    flag=True

                elif flag==False:
                    for j in range(len(curr)): 
                        if curr[j] == '(' or curr[j] == ')':
                            child=curr[:j] + curr[j+1:]
                            if child not in dic:
                                dic.add(child)
                                que.append(str(child))
                    


        return result

    def isValid(self,curr):
        count=0
        for i in curr:
            if i=="(":
                count+=1
            if i==")":
                count-=1 
                if count<0:
                    return False

        return count==0               

        






