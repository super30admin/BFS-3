class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        if not s: return []

        hashset=set()
        q=collections.deque()
        q.append(s)
        res=[]
        flag=False
        
        while q and not flag:
            size=len(q)
            for i in range(size):
                string=q.popleft()
                if self.isvalid(string):
                    flag = True
                    res.append(string)
                else:
                    if not flag:
                        for j in range(len(string)):
                            if string[j].isalpha():
                                continue
                            substring=string[:j]+string[j+1:]
                            if substring not in hashset:
                                hashset.add(substring)
                                q.append(substring)
        return res

    def isvalid(self,s):
        count=0
        for i in range(len(s)):
            if s[i]=="(":
                count+=1
            elif s[i]==")":
                if count==0:
                    return False
                count-=1
        return count==0
