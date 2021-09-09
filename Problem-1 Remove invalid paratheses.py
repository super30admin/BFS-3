# Time COmplexity: O(2^n)
# Space COmplexity: O(n)
class Solution:

    def removeInvalidParentheses(self, s: str) :

        n = len(s)

        l = 0
        r = 0

        self.result = []
        self.visited = set()

        self.curr_stack = self.isValid(s)[1]

        for i in self.curr_stack:
            if i[1] == '(':
                l += 1

        r_count = len(self.curr_stack) - l

        self.dfs(s, l, r)
        return self.result

    def isValid(self, s):
        stack = []
        for i in range(len(s)):
            if s[i] == '(':
                stack.append((i, '('))
            elif s[i] == ')':
                if (stack and stack[-1][1] == '('):
                    stack.pop()
                else:
                    stack.append((i, ')'))
        return len(stack) == 0, stack

    def dfs(self, s, l, r):

        self.visited.add(s)

        if l == 0 and r == 0 and self.isValid(s)[0]:
            self.result.append(s)

        for index, ch in enumerate(s):

            if ch != '(' and ch != ')':
                continue
            if (ch == '(' and l == 0) or (ch == ')' and r == 0):
                continue

            if s[0:index] + s[index + 1:] not in self.visited:
                self.dfs(s[0:index] + s[index + 1:], l - (ch == '('), r - (ch == ')'))

