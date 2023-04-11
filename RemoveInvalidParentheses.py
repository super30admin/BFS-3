"""
Rasika Sasturkar
Time Complexity: O(n^n)
Space Complexity: O(n)
"""

from collections import deque


def removeInvalidParentheses(s: str):
    result = []

    # null case
    if s is None:
        return result

    def validate_string(t):
        count = 0
        for char in t:
            if char.isalpha():
                continue
            if char == "(":
                count += 1
            elif char == ")":
                count -= 1
            if count < 0:
                return False
        return count == 0

    # Using BFS
    queue = deque()
    string_set = set()
    queue.append(s)
    string_set.add(s)
    flag = False

    while queue and not flag:
        size = len(queue)
        for i in range(size):
            curr = queue.popleft()
            if validate_string(curr):
                result.append(curr)
                flag = True
            if not flag:
                for j in range(len(curr)):
                    c = curr[j]
                    if c.isalpha():
                        continue
                    child = curr[:j] + curr[j + 1:]
                    if child not in string_set:
                        queue.append(child)
                        string_set.add(child)

    # Using DFS
    # max_len = 0
    # string_set = set()
    #
    # def dfs(t):
    #     nonlocal max_len
    #     nonlocal result
    #     # base case
    #     if t in string_set or len(t) < max_len:
    #         return
    #     if (validate_string(t)):
    #         if len(t) > max_len:
    #             max_len = len(t)
    #             result = []
    #             result.append(t)
    #         elif len(t) == max_len:
    #             result.append(t)
    #         string_set.add(t)
    #
    #     # logic
    #     string_set.add(t)
    #     for j in range(len(t)):
    #         c = t[j]
    #         if c.isalpha():
    #             continue
    #         child = t[:j] + t[j + 1:]
    #         dfs(child)
    #
    # dfs(s)
    return result


def main():
    """
    Main function - examples from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    print(removeInvalidParentheses(s="()())()"))  # return ['(())()', '()()()']
    print(removeInvalidParentheses(s="(a)())()"))  # return ['(a())()', '(a)()()']
    print(removeInvalidParentheses(s=")("))  # return ['']


if __name__ == "__main__":
    main()
