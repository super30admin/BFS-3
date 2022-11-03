"""

## Problem 301: Remove Invalid Parentheses

## Author: Neha Doiphode
## Date:   10-31-2022

## Description
    Given a string s that contains parentheses and letters, remove the minimum number of invalid parentheses to make the input string valid.
    Return all the possible results. You may return the answer in any order.

## Examples:
    Example 1:
        Input: s = "()())()"
        Output: ["(())()","()()()"]

    Example 2:
        Input: s = "(a)())()"
        Output: ["(a())()","(a)()()"]

    Example 3:
        Input: s = ")("
        Output: [""]

## Constraints:
    1 <= s.length <= 25
    s consists of lowercase English letters and parentheses '(' and ')'.
    There will be at most 20 parentheses in s.


Time Complexity : O(2^n) since in the worst case we will have only left parentheses in the expression and
                  for every bracket we will have two options i.e. whether to remove it or consider it.
                  Considering that the expression has n parentheses, the time complexity will be O(2^n).

Space Complexity : O(n) because we are resorting to a recursive solution and
                   for DFS - a recursive solution there is always stack space used as internal function states
                   are saved onto a stack during recursion. Same applies for BFS based solution where we use the queue.
                   The maximum depth of recursion decides the stack space used.
                   Since we process one character at a time and the base case for the recursion is
                   when we have processed all of the characters of the expression string,
                   the size of the stack would be O(n).
                   Note that we are not considering the space required to store the valid expressions.
                   We only count the intermediate space here.

"""

from typing import List, Optional
from collections import deque

def get_input():
    print("Enter the input string: ", end = "")
    string = input()
    print()
    return string

class Solution:
    result = []
    max_len = 0
    already_considered = set()

    def is_valid(self, s: str) -> bool:
        count = 0
        for char in s:
            if char == "(":
                count += 1
            elif char == ")":
                count -= 1
                if count < 0:
                    return False

        return (count == 0)

    def removeInvalidParentheses_bfs(self, s: str) -> List[str]:
        if len(s) == 0:
            return []

        q = deque()
        self.already_considered = set()
        self.result = []
        q.append(s)
        found = False


        """
                                                        ['(a)())()']    ----> Level 0

                                 ['a)())()', '(a())()', '(a)))()', '(a)()()', '(a)()))', '(a)())(']   ----> Level 1
                                    invalid    valid     invalid     valid     invalid     invalid

        In the example above, we found 2 valid strings at level 1 iteself. We found them by just removing one of the brackets.
        In the output, we are expected to find valid strings with "minimum" number of bracket removals.
        Hence, if we find something at level "X" we should not be required to explore further levels X+1 onwards.

        In the code below, we are using level order breadth first search as it allows us to traverse level wise and we are using found variable
        to detect if we found any valid strings at that level.

        If found is set to True even by one of the valid strings, it will never be set to False, outer while loop checks that if it was ever set to True,
        that means at least one valid string is present at the current level, in that case, outer most while loop can simply stop executing as we already found
        set of valid strings with "minimum" number of bracket removals.

        """
        while len(q) != 0 and not found:
            size = len(q)
            while size > 0:
                current = q.popleft()
                if self.is_valid(current):
                    found = True
                    self.result.append(current)
                else:
                    for index in range(len(current)):
                        if current[index] >= 'a' and current[index] <= 'z':
                            continue
                        temp = ''
                        temp += current[:index] + current[index + 1:]
                        if temp not in self.already_considered:
                            self.already_considered.add(temp)
                            q.append(temp)
                size -= 1
        return self.result

    def dfs(self, s: str) -> None:
        if s in self.already_considered or len(s) < self.max_len:
            return

        self.already_considered.add(s)
        if self.is_valid(s):
            if len(s) > self.max_len:
                self.max_len = len(s)
                self.result = []
                self.result.append(s)
            elif len(s) == self.max_len:
                self.result.append(s)
        else:
            for index in range(len(s)):
                if s[index] >= 'a' and s[index] <= 'z':
                    continue
                temp = ''
                temp += s[:index] + s[index + 1:]
                self.dfs(temp)

    def removeInvalidParentheses_dfs(self, s: str) -> List[str]:
        if len(s) == 0:
            return []

        self.result = []
        self.max_len = 0
        self.already_considered = set()
        self.dfs(s)
        return self.result

# Driver code
solution = Solution()
string = get_input()
print(f"Input string: {string}")
print(f"Output: Approach 1: Breadth first search: List of strings removing minimum number of invalid parentheses: {solution.removeInvalidParentheses_bfs(string)}")
print(f"Output: Approach 2: Depth first search  : List of strings removing minimum number of invalid parentheses: {solution.removeInvalidParentheses_dfs(string)}")
