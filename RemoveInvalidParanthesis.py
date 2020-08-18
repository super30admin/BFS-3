--------------------------remove invalid paranthesis------------------------------------------
# Time Complexity : O(2**nXn) as N is length of string 
# Space Complexity : O(2**n)  as we are using set
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# We will iterate through string and check all the children of the string by removing one character at a time. We will start from the 
# given string and check if it is a valid string or not, else we will check all the children of the parent and add them to the queue and process,
# them again. When we encounter alphabet we will jus continue as it is always valid.



class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        if not s:
            return [""]
        
        
        def isValid(subString):
            count = 0
            for i in subString:
                if i == '(':
                    count +=1
                elif i == ')':
                    count -=1
                
                if count<0:
                    return False
            return count == 0
        
        queue = collections.deque()
        stringSet = set()
        queue.append(s)
        stringSet.add(s)
        flag = 0
        res = set()
        while queue:
            curr = queue.popleft()
            if isValid(curr):
                flag = 1
                res.add(curr)
            if not flag:
                for i in range(len(curr)):
                    if curr[i].isalpha():
                        continue
                    temp = curr[:i]+curr[i+1:]
                    if temp not in stringSet:
                        stringSet.add(temp)
                        queue.append(temp)
        return res if len(res)>0 else [""]