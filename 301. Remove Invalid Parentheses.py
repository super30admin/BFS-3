class Solution(object):
    def removeInvalidParentheses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        def isValid(s):
            count=0
            for i in range(len(s)):
                if s[i]=='(':
                    count=count+1
                elif s[i]==')':
                    count=count-1
                    if count<0:
                        return False
                else:
                    continue
            return count==0

        if not s:
            return [""]
        dq=collections.deque()
        visited=set()
        result=[]
        flag=False
        dq.append(s)
        visited.add(s)
        while dq:
            curr=dq.popleft()
            if(isValid(curr)):
                result.append(curr)
                flag=True
            if flag:
                continue
            for j in range(len(curr)):
                if curr[j].isalpha():
                    continue
                child=curr[:j]+curr[j+1:]
                if child not in visited:
                    dq.append(child)
                    visited.add(child)
        return result if result else [""]


