# Time COmplexity: O(2^n)
# Space COmplexity: O(n)
class Solution:

    def removeInvalidParentheses(self, s):

        n = len(s)
        self.curr_stack = self.is_Valid(s)[1]
        l_count = 0
        r_count = 0
        self.result = []
        self.visited = set()

        for i in self.curr_stack:
            if i[1] == '(':
                l_count += 1

        r_count = len(self.curr_stack) - l_count

        self.dfs(s, l_count, r_count)
        return self.result

    def is_Valid(self, s):
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

        if l == 0 and r == 0 and self.is_Valid(s)[0]:
            self.result.append(s)

        for index, ch in enumerate(s):

            if ch != '(' and ch != ')':
                continue
            if (ch == '(' and l == 0) or (ch == ')' and r == 0):
                continue

            if s[:index] + s[index + 1:] not in self.visited:
                self.dfs(s[:index] + s[index + 1:], l - (ch == '('), r - (ch == ')'))

