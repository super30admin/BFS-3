#Time Complexity :o(2^n) 
#Space Complexity :o(n)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no

class Solution(object):
    def removeInvalidParentheses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        if(s==None or len(s)==0):
            return [""]
        queue=collections.deque()
        hset=set()
        hset.add(s)
        res=[]
        
        queue.append(s)
        flag=False
        
        while(queue):
            size=len(queue)
            for i in range(size):
                curr=queue.popleft()
                if(self.isValid(curr)):
                    res.append(curr)
                    flag=True
                #if not found cintinur
                if(not flag):
                    for i in range(len(curr)):
                        if(curr[i].isalpha()):
                            continue
                        subString=curr[0:i]+curr[i+1:]
                        if(subString not in hset):
                            hset.add(subString)
                            queue.append(subString)
        
        return res
    #c heck valid or not          
    def isValid(self,s):
        count=0
        for i in s:
            if(i=='('):
                count+=1
            elif(i==')'):
                if(count==0):
                    return False
                count-=1
        return count==0
            
        