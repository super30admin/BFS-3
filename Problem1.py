from collections import deque
#Time complexity is: O(n^n)
#Space complexity is: O(n^n)
#No issues faced while coding
#COde ran successfully on leetcode
class Solution(object):
    def removeInvalidParentheses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        #Initializng hashset and queue
        hset=set()
        q=deque()
        #Appending s into q and hset
        q.append(s)
        hset.add(s)
        flag=False
        result=[]
        #We will iterate through q and until flag is false
        while(q and not flag):
            size=len(q)
            #We will be iterating through current size of queue
            for i in range(size):
                #We will take the current value from queue
                curr=q.popleft()
                #We will check if the curr string is valid or not
                if(self.isValid(curr)):
                    #If the string is valid, we will amke the flag as true
                    flag=True
                    #We will append the current value into the result
                    result.append(curr)
                else:
                    #If the curf value is not valid and the flag is false then only we will
                    #go into the next if condition
                    if(not flag):
                        #making babies for that
                        for j in range(0,len(curr)):
                            #Taking the current character out
                            c=curr[j]
                            #Checking if the current character is alphabet or not
                            if(c.isalpha()):
                                #If it is alphabet, we will continue the loop
                                continue
                            #We will take the substring
                            child=curr[0:j]+curr[j+1:]
                            #If the child is not present in hset, we will add that
                            #to the hset and q
                            if(child not in hset):
                                hset.add(child)
                                q.append(child)
        #Finally we will return result
        return result
    
    #Function to check if the substring is valid or not
    def isValid(self,s):
        #Initializing count to 0
        count=0
        #We will go through each value in s
        for i in range(0,len(s)):
            #We will update the count based on the brackets
            c=s[i]
            if(c=="("):
                count+=1
            elif(c==")"):
                if(count==0):
                    return False
                count-=1
        #Finally we will return True or False based on count value
        return count==0


