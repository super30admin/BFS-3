class Solution:
    
    """
    Description: Remove the minimum number of invalid parentheses in order to make the input string valid and return all possible results
    
    Time Complexity: O(2^n)
    Space Complexity: O(n*2^n)
    where n is length of given string (includes a letter)
    
    Approach:
    1. Define a function isValid to validate a string
    2. Use BFS Algorithm (better since we can stop with minimum removal of characters from original string)
       - start a queue with current string and add the same to a hash set, and have a flag = False presuming that s is not a valid string
       - for each element in quque, find current by popping, and check if the string is valid -> add to result, and turn flag to True
       - if not valid, we can go to the next level where we can derive multiple elements to be added in the queue from current element
         + ensure no repeated elements are added (use the hash set conditional statement)
         + in loop as far as flag do not turn as True (ensuring all the valid strings at a level as all the elements will be called in the queue for the next level)
    """
    
    def removeInvalidParentheses(self, s: str) -> List[str]:
        
        from collections import deque
        
        queue = deque(); result = []
        queue.append(s); flag = False
        result_set = set()
        result_set.add(s)
        
        while queue:
            for i in range(len(queue)):
                curr = queue.popleft(); n = len(curr)
                if self.isValid(curr):
                    flag = True
                    result.append(curr)

                if not flag:
                    for i in range(n):
                        if curr[i].isalpha(): continue
                        child = curr[0: i] + curr[i + 1: n]
                        if child not in result_set:
                            queue.append(child)
                            result_set.add(child)
                    
        return result
        
    def isValid(self, string):
        # To check if a given string with paranthesis is valid
        count = 0
        for char in string:
            if char == "(": count += 1
            elif char == ")": 
                if count == 0: return False
                count -= 1
        return count == 0
    
