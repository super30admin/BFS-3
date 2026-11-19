'''
301 Remove Invalid Parentheses
https://leetcode.com/problems/remove-invalid-parentheses/description/

Given a string s that contains parentheses and letters, remove the minimum number of invalid parentheses to make the input string valid.

Return a list of unique strings that are valid with the minimum number of removals. You may return the answer in any order.

Example 1:
Input: s = "()())()"
Output: ["(())()","()()()"]

Example 2:
Input: s = "(a)())()"
Output: ["(a())()","(a)()()"]

Example 3:
Input: s = ")("
Output: [""]

Constraints:
1 <= s.length <= 25
s consists of lowercase English letters and parentheses '(' and ')'.
There will be at most 20 parentheses in s.

Solution:
1. BFS w/ level info:
We do level-wise BFS removing one character at a time. Thus, at level 1, we remove 1 char, at level 2 we remove 2 chars, and so on.

At the first instance we find a valid expression at some level X, we check for validity of all the strings in the queue at that level (searching for other valid expressions). But we do not go down to the next level X+1 (i.e. we do not add children of of strings at level X) because this would mean X+1 removals of parentheses which is not a minimum.

Note: If len of string = 7 (odd), then at level 1 we have an even number of chars in the string. Then then there is a chance at level 1 to get a valid string. (a valid string has an equal no. of opening and closing parentheses)
At level 2, however, it is guaranteed that no valid string will exist.

Thus, if string len = odd, then valid strings do not exist at even-numbered levels. If string len = even, then valid strings do not exist at odd-numbered levels.
Time: O(2^N), Space: O(2^N * N) - for visited set
https://youtu.be/5ibsv1HTDyU?t=287


2. BFS w/o using level info:
In BFS w/ level approach, although we compute the size of q at each level, we never really used it. Hence, we can eliminate the for loop over size items to get this working.
Time: O(2^N), Space: O(2^N * N) - for visited set
https://youtu.be/5ibsv1HTDyU?t=2298
https://youtu.be/pmo-ZUg6MMY?t=1720 (JS, good point about next level, video  until t=1875)


3. DFS
We do DFS to remove one bracket at a time and track visited strings.
Once we find a valid expression, we check if it's the longest so far.
Only the longest valid strings with the fewest deletions are kept.
Time: O(2^N), Space: O(2^N * N) - for visited set
https://youtu.be/5ibsv1HTDyU?t=2683 (RK)
https://youtu.be/pmo-ZUg6MMY?t=1877 (JS, till https://youtu.be/pmo-ZUg6MMY?t=2749)

'''

from typing import List
from collections import deque

def isValid(s: str) -> bool:
    ''' Time: O(N), Space: O(1) '''
    if not s:
        return True
    count = 0
    for c in s:
        if c == '(':
            count += 1
        elif c == ')':
            count -= 1
        else: # letters
            pass

        if count < 0:
            return False
    return count == 0

def removeInvalidParenthesesBFSLevel(s: str) -> List[str]:
    if not s:
        return []
    q = deque()
    q.append(s)
    h = set()
    result = set()
    while q:
        sz = len(q)
        for _ in range(sz):
            curr = q.popleft()
            if isValid(curr):
                result.add(curr)
                h.add(curr)
            else:
                for j in range(len(curr)): # remove parenthesis
                    c = curr[j]
                    # if c is a letter, then skip
                    if c >= 'a' and c <= 'z':
                        continue
                    child = curr[0:j] + curr[j+1:]
                    if child not in h:
                        q.append(child)
                        h.add(child)
        # If at the end of this level, we have collected valid strings,
        # we can say that we have made minimum number of removals & can quit
        if len(result) > 0:
            break
    return list(result)


def removeInvalidParenthesesBFSNoLevel(s: str) -> List[str]:
    if not s:
        return []
    q = deque()
    q.append(s)
    h = set()
    result = set()
    flag = False # boolean to indicate if valid string found or not
    while q:
        curr = q.popleft()
        if isValid(curr):
            result.add(curr)
            h.add(curr)
            flag = True
        else:
            if flag == False:
                for j in range(len(curr)): # remove parenthesis
                    c = curr[j]
                    # if c is a letter, then skip
                    if c >= 'a' and c <= 'z':
                        continue
                    child = curr[0:j] + curr[j+1:]
                    if child not in h:
                        q.append(child)
                        h.add(child)
    return list(result)


def removeInvalidParenthesesDFS(s: str) -> List[str]:
    def dfs(s):
        nonlocal max_len, result
        # base
        if len(s) < max_len:
            return

        # logic
        if isValid(s):
            if len(s) > max_len:
                max_len = len(s)
                result.clear()
                result.add(s)
            elif len(s) == max_len:
                result.add(s)
            return


        for j in range(len(s)): # remove parenthesis
            c = s[j]
            # if c is a letter, then skip
            if c >= 'a' and c <= 'z':
                continue
            child = s[0:j] + s[j+1:]
            if child not in h and len(child) >= max_len:
                h.add(child)
                dfs(child)

    # max len of valid string = string with min no. of parenthesis
    # removals
    result = set()
    h = {s}
    max_len = 0
    dfs(s)
    return list(result)



def run_tests():
    tests = [("()())()", ["(())()","()()()"]),
             ("(a)())()", ["(a())()","(a)()()"]),
             (")(", [""]),
    ]
    for test in tests:
        s, ans  = test[0], test[1]
        print(f"\nstring (w/ invalid parentheses) = {s}")
        for method in ['bfs_w_level', 'bfs_wo_level', 'dfs']:
            if method == 'bfs_w_level':
                result = removeInvalidParenthesesBFSLevel(s)
            elif method == 'bfs_wo_level':
                result = removeInvalidParenthesesBFSNoLevel(s)
            elif method == 'dfs':
                result = removeInvalidParenthesesDFS(s)
            print(f"Method {method}: result = {result}")
            passed = (sorted(ans) == sorted(result))
            assert passed == True, f"Test case failed"
            print(f"Pass: {passed}")
    print(f"\nDONE")

run_tests()