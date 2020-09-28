# APPROACH: BFS (works better on average but same worst TC as brute force)
# Time Complexity : O(n ^ n), n: lengeth of input string
# Space Complexity : O(n ^ n), size of the queue (at max, it can hold all the strings at the last level of the tree)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. It's same as the brute force exponential search, but we are searching in the smart way -> BFS. It is good, if we find the result in the upper levels of the tree itself so 
#    we dont have to search the entire tree.
# 2. Initially add the input string to the queue and hashset. Also maintain a hashset so that we don't process the same string again.
# 3. Keep doing this till queue is empty or we have found valid string(s) at a level (flag is True)
#       - firstly, check if it's valid. If so, mark the flag as True. 
#       - if the string is not valid, then we will process it's childrens. (generate all strings by removing a char at every ind). 
#       - add them to queue only if it's not present in hashset.

class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        if s is None or len(s) == 0:
            return [""]
        
        queue, flag, hashset, result = deque(), False, set(), []
        hashset.add(s)
        queue.append(s)
        
        while queue and not flag:
            size = len(queue)
            while size > 0:
                curr = queue.popleft()
                
                if self.isValid(curr):
                    result.append(curr)
                    flag = True
                    
                if not flag:
                    for i in range(len(curr)):
                        child = curr[ : i] + curr[i + 1 : ]
                        if child not in hashset:
                            hashset.add(child)
                            queue.append(child)
                size -= 1
                            
        return result
    
    
    def isValid(self, s):
        count = 0
        for char in s:
            if char == '(':
                count += 1
            elif char == ')':
                if count == 0:
                    return False
                count -= 1
        
        if count == 0:
            return True
        else:
            return False
        
        
        
