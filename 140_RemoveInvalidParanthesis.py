'''
Accepted on leetcode(301)
time - exponencial.
space - exponencial
Approach:
1. Declare queue and hashset(for uniqueness) for bfs approach.
2. In validString method, check for  validity of string. If valid return that.
3. If validString not found return null.
'''


class Solution:
    def removeInvalidParentheses(self, s: str):
        resultList = []

        queue = []
        hashset = set()
        found = False
        hashset.add(s)
        queue.append(s)

        # BFS
        while queue:
            string = queue.pop(0)

            if self.isValid(string):
                resultList.append(string)
                found = True

            if not found:
                # add all possible elements in next level(by removing one paranthesis from previous level) to the queue.
                for i in range(len(string)):
                    if not string[i].isalpha():
                        t = string[:i] + string[i + 1:]  # deleting an element from string.

                        if t not in hashset:  # to remove duplicate elements.
                            hashset.add(t)
                            queue.append(t)

        if len(resultList) == 0:
            resultList.append("")  # if null add empty string.
        return resultList

    # check validity of string.
    def isValid(self, string):
        count = 0
        for i in range(len(string)):
            if string[i] == '(':
                count += 1
            elif string[i] == ')':
                if count <= 0:
                    return False
                count -= 1
        return count == 0