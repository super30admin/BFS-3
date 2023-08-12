class Solution(object):
    def removeInvalidParentheses(self, s):
        """
        BFS - Remove the minimum number of invalid parentheses in order to make the input string valid.

        Time Complexity: O(2^N), where N is the length of the input string s
        Space Complexity: O(2^N), where N is the length of the input string s

        :type s: str
        :rtype: List[str]
        """
        def isValid(s):
            """
            Check if a given string has a valid parentheses arrangement.

            :type s: str
            :rtype: bool
            """
            count = 0  # Counter to keep track of open parentheses
            for i in range(len(s)):
                c = s[i]
                if c == "(":
                    count += 1
                elif c == ")":
                    if count == 0:  # If there is no corresponding open parenthesis, return False
                        return False
                    count -= 1
            return count == 0  # The count should be zero at the end for valid parentheses arrangement

        parSet = set()  # Set to store visited strings
        q = [s]  # Initialize the queue with the original string
        result = []  # List to store valid expressions
        flag = False  # Flag to indicate if a valid expression is found

        while q and not flag:
            size = len(q)
            for i in range(size):
                # Get and remove the front string from the queue
                curr = q.pop(0)
                if isValid(curr):
                    flag = True
                    # Add valid expression to the result list
                    result.append(curr)
                else:
                    if not flag:
                        for j in range(len(curr)):
                            c = curr[j]
                            if c.isalpha():  # Skip alphanumeric characters
                                continue
                            # Remove the current parentheses character
                            child = curr[:j] + curr[j+1:]
                            if child not in parSet:
                                # Add the modified string to the queue
                                q.append(child)
                                # Add the modified string to the set of visited strings
                                parSet.add(child)

        return result
