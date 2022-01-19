# Time: O(exponential)
# Space: O(n!)
class Solution(object):
    def __init__(self):
        self.mn = 0
        self.ans = [""]
    def removeInvalidParentheses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        st = set()
        queue = []
        queue.append(s)
        result = []
        found = False
        while len(queue) != 0 and not found:
            size = len(queue)
            for i in range(size):
                curr = queue.pop(0)
                if self.is_valid(curr):
                    result.append(curr)
                    found = True
                for j in range(len(curr)):
                    if curr[j] == ')' or curr[j] == '(':
                        temp = curr[:j]+curr[j+1:]
                        if temp not in st:
                            queue.append(temp)
                            st.add(temp)
        return result
                
                    
    def is_valid(self, st):
        if len(st) == 0:
            return True
        stack = []
        if st[0] == ')' or st[0] == '(':
            stack.append(st[0])
        i = 1
        while i < len(st):
            #print(stack, st[i])
            if st[i] == '(':
                stack.append('(')
            elif st[i] == ')':
                if len(stack) == 0 or stack[-1] != '(':
                    return False
                else:
                    stack.pop()
            i += 1
        if len(stack) == 0:
            return True
        return False
        
