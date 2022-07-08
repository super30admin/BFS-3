'''
Time Complexity: exponential i.e. 0(n^n)
Space Complexity: 0(n) -- Queue
Run on leetCode: Yes
'''
from collections import deque
class Solution:
    
    def __init__(self):
        self.__result = []
        self.__resultSet = set()
    
    def __validParanthesis(self,string):
        '''Since we have one type of paranthesis i.e. (), we will use "count" funda!!'''
        # to chk for validParanthesis
        count = 0
        # initialize itr string
        i = 0
        # iterate the string
        while i != len(string):
            if string[i] == '(':
                count += 1
            elif string[i] == ')':
                count -= 1
                if count < 0:
                    break
            # else -- i.e. a character, just ignore :'(
            i+=1
        '''end of iteration'''
        # proceed conditionally
        if count == 0:
            return True
        return False
        
    def removeInvalidParentheses(self, s: str) -> List[str]:
        
        # initialize queue
        queue = deque([])
        # add s to the queue and set
        queue.append(s)
        self.__resultSet.add(s)
        # iterate the queue
        lvl = 0
        while len(queue) != 0 and len(self.__result) == 0:
            # initialize size
            size = len(queue)
            # iterate the queue till count breeches size
            for count in range(0,size):
                # pop the string from the queue
                string = queue.popleft()
                # chk if string is a valid paranthesis
                flag = self.__validParanthesis(string)
                # proceed conditionally
                if flag == True:
                    # add the string to the result
                    self.__result.append(string)
                    continue
                else:
                    # iterate the string and create subStrings
                    # initialize pivot
                    pivot = 0
                    for i in range(0,len(string)):
                        # create subString
                        subString = string[pivot:i] + string[i+1:]
                        # chk if subString is part of the set
                        if subString not in self.__resultSet:
                            self.__resultSet.add(subString)
                            queue.append(subString)
                    '''end of for-loop based subString creation'''
            '''count breeches size'''
            # update the lvl
            lvl += 1
        '''end of while loop'''
        # update the lvl
        lvl -= 1
        # print(self.__result)
        return self.__result