#time complexity o(v+e) or O(n)
# space complexity o(n) for queue
class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        #bsf
        if s=="" or len(s)==0: return [""]
        result=[]
        q=[]
        q.append(s)
        duplicate=set()
        duplicate.add(s)
        flag=False
        size=0
        while q!=[]:
            size=len(q)
            for ss in range(size):
                
                temp=q.pop(0)
                if self.isValid(temp):
                    flag=True
                    result.append(temp)
                if not flag:
                    for i in range(len(temp)):
                        if temp[i].isalpha(): continue
                        tempstr=temp[0:i]+temp[i+1:]
                        #print(tempstr)
                        if not (tempstr in duplicate):
                            q.append(tempstr)
                            duplicate.add(tempstr)
        return result
    
    def isValid(self,str):
        count=0
        for s in str:
            if s=='(':
                count+=1
            elif s==')':
                if count==0: 
                    return False
                else:
                    count-=1
        print(count)
        return count==0