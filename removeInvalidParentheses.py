#Time Complexity:O(2^N)
#Space complexity:O(n)
#Ran successfully on Leetcode:yes
#Algo:
#Create a function to check if the string input is valid or not.
#Initialize a result array to store valid parantheis
#Uisng a queue we process all the brackets. 
#If the string input is a valid one , then we add them to result array and set flag as True
#Else we check if the flag has been set to False only, then wwe explore its children and add to queue.

from collections import deque
class Solution(object):
    def is_valid(self, s):
        count = 0
        for ch in s:
            if ch == "(":
                count = count + 1
            elif ch == ")":
                count = count - 1
            if count < 0:
                return False
        return count == 0
    
    def removeInvalidParentheses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        q, result = deque(), []
        q.append(s)
        flag=False
        while len(q) and not flag:
            next_level = set([])
            for _ in range(len(q)):
                x = q.popleft()
                if self.is_valid(x):
                    result.append(x)
                    flag=True
                if not flag:
                    for i in range(len(x)):
                        if x[i] in ("(", ")"):
                            next_level.add(x[0:i] + x[i+1:])
            for nl in next_level:
                q.append(nl)
        return result if result else [""]
