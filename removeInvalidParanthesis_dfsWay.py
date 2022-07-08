'''
Time Complexity: exponential i.e. 0(n^n)
Space Complexity: 0(n) --- recursive stack
Run on leetCode: Yes
'''
class Solution:
    
    def __init__(self):
        self.__result = []
        self.__resultSet = set()
        self.__max = 0
        
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
    
    def __dfsTraversal(self,string):
        
        # base-case
        if len(string) < self.__max:
            return
        
        elif string in self.__resultSet:
            return
        
        # print("\nSELF.MAX is:\t",self.__max)
        
        # logic-case
        # 0. add string to the resultSet
        self.__resultSet.add(string)
        
        # 1. chk for valid paranthesis
        flag = self.__validParanthesis(string)
        
        # 2. proceed conditionally
        if flag == True:
            
            # case-1 self.__max is UNCHANGED
            if self.__max == len(string):
                self.__result.append(string)
            # case-2 self.__max need to be changed to new maxima
            elif self.__max < len(string):
                self.__result = []
                self.__result.append(string)
                self.__max = len(string)
            return  # no need to check further as it will lead to small subStrings
        
        # 3. proceed for the string
        pivot = 0
        for i in range(0,len(string)):
            # create subString
            subString = string[pivot:i] + string[i+1:]
            # dfs on subString
            self.__dfsTraversal(subString)
        '''end of subString creation'''
        
        pass
    def removeInvalidParentheses(self, s: str) -> List[str]:
        
        # base-case, chk if string is a valid paranthesis
        flag = self.__validParanthesis(s)
        if flag == True:
            self.__result.append(s)
            return self.__result
        
        # flag is False
        # 1. add s to the set
        self.__resultSet.add(s)
        
        # 2. iterate the string
        pivot = 0
        for i in range(0,len(s)):
            # create subString
            subString = s[pivot:i] + s[i+1:]
            # dfs on subString
            self.__dfsTraversal(subString)
        
        '''print the result'''
        # print(self.__result)
        return self.__result