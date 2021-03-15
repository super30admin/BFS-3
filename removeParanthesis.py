#Time complexity: Exponential
#space: O(N)

class Solution(object):
    def removeInvalidParentheses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        if len(s) == 0:
            return [""]
        if len(s) == 1:
            if s == "(" or s == ")":
                return [""]
            else:
                return [s]
        if self.isValid(s):
            return [s]
        res = set()
        visited=set()
        queue = []
        step = 0
        queue.append(s)
        visited.add(s)
        while queue:
            size = len(queue)
            for item in queue:
                if self.isValid(item):
                    res.add(item)
            if len(res) > 0:
                return list(res)
            for _ in range(size):
                cur = queue.pop(0)
                for i in range(len(cur)):
                    tmp=cur[:i] + cur[i + 1:]
                    if tmp not in visited:
                        visited.add(tmp)
                        queue.append(tmp)

    def isValid(self, s):
        stack = []
        for i in s:
            if i == "(":
                stack.append("(")
            elif i == ")":
                if not stack:
                    return False
                else:
                    stack.pop()
        return not stack