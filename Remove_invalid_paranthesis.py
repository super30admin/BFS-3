// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
In this process we use BFS to calculate the min removal of paranthesis in a given string to make it valid.so fot that we go level by level and if we find a valid paranthesis at a level ,we traverse through the whole level and then we break the whole loop and return the result.If not we traverse each level till we find a valid paranthesis.string generated at level1 will have more valid length paranthesis when comapred to the string generated at level2.

# Time complexity --> o(2**n) n is the length of input string
# space complexity --> o(n) n is the length of the given input string
from collections import deque
class Solution(object):
    #making sure if a given strign at a level is valid or not
    def isvalid(self,str2):
        count=0
        for i in str2:
            if i=='(':
                count=count+1
            elif i==')':
                count=count-1
            else:
                continue
            if count<0:
                return False
        if count==0:
            return True
        return False
    def removeInvalidParentheses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        queue=deque()
        visited=set()
        queue.append(s)
        #visted to make sure we r nor dng BFS on the same string again and again
        visited.add(s)
        if s==None:
            return []
        result=[]
        if self.isvalid(s):
            result.append(s)
        while len(queue)!=0:
            size=len(queue)
            for i in range(size):
                str1=queue.popleft()
                for i in range(len(str1)):
                    #if it is character then we skip it
                    if str1[i].isalpha():
                        continue
                    str2=str1[0:i]+str1[i+1:]
                    if str2 not in visited:
                        if self.isvalid(str2):
                            result.append(str2)
                            # print(result,i)
                        queue.append(str2)
                        visited.add(str2)
            #if we found a valid paranthesis string at a level we break the loop
            if len(result)>0:
                break
        return result
                
        