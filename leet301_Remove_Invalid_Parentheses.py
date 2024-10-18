# Solution

# // Time Complexity : O() -> Assumption is n! but leetcode said n*2^n
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : None


# // Your code here along with comments explaining your approach
# Approach is to use BFS to perform level order traversal. Basically consider the string has "n" characters, in first level we can remove one
# character at each position giving us n strings. For example ")()" can be split into "()","))",")(" strings. At this level "()" is valid, so
# we can stop at this level. Incase there was no valid string here, then for each of these n strings, each with length of n-1, we will have
# n-1 strings. We can keep going to lower levels until we find a level which has valid string. We can also use a dictionary to keep track
# of all the strings created, so that we do not go to lower level on same string multiple times.

def isValid(s):
        count = 0
        for c in s:
            if count < 0:
                return False
            elif c == "(":
                count += 1
            elif c == ")":
                count -= 1
        
        if count == 0:
            return True
        else:
            return False
        
def removeInvalidParentheses(s):
    workingS = [s[:]]
    result = []
    resultDict = {}

    if isValid(s): return [s]

    while not result:
        tempS = []
        for string in workingS:
            n = len(string)
            for i in range(n):
                if string[i].isalnum():
                    continue

                newS = string[0:i] + string[i+1:n]

                if isValid(newS) and newS not in resultDict:
                    result.append(newS)
                
                if newS not in resultDict:
                    tempS.append(newS)
                    resultDict[newS] = ""
            
            if result:
                tempS = []
                workingS = []
            else:
                workingS = tempS[:]

    return result

if __name__ == "__main__":
    # s = "()())()"
    # s = "(a)())()"
    s = ")("
    print(removeInvalidParentheses(s))