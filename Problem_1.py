"""
Problem : 1

Time Complexity : O(n^n)
Space Complexity : O(n^n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Remove Invalid Parentheses

# Approach - 1
# BFS

class Solution(object):
    def removeInvalidParentheses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        q=collections.deque()
        hset=set()
        q.append(s)
        hset.add(s)
        flag=False
        result=[]
        while q and not flag:
            size=len(q)
            for i in range(size):
                curr=q.popleft()
                if self.isValidString(curr):
                    flag=True
                    result.append(curr)
                else:
                    if not flag:
                        for j in range(len(curr)):
                            c=curr[j]
                            if c.isalpha():
                                continue
                            child=curr[0:j]+curr[j+1:]
                            if child not in hset:
                                q.append(child)
                                hset.add(child)
        return result
                            
    def isValidString(self,s):
        count=0
        for i in range(len(s)):
            c=s[i]
            if c=='(':
                count+=1
            elif c==')':
                if count==0:
                    return False
                count-=1
        return count==0


# Approach - 2
# DFS

class Solution(object):
    def __init__(self):
        self.hset=set()
        self.result=[]
        self.maxx=0
    def removeInvalidParentheses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """

        self.dfs(s)
        return self.result

    def dfs(self,s):
        # base
        if len(s)<self.maxx:
            return
        elif self.isValidString(s):
            if len(s)>self.maxx:
                self.maxx=len(s)
                self.result=[]
            self.result.append(s)

        # logic
        for i in range(len(s)):
            c=s[i]
            if c.isalpha():
                continue
            child=s[:i]+s[i+1:]
            if child not in self.hset:
                self.hset.add(child)
                self.dfs(child)
            
    def isValidString(self,s):
        count=0
        for i in range(len(s)):
            c=s[i]
            if c=='(':
                count+=1
            elif c==')':
                if count==0:
                    return False
                count-=1
        return count==0