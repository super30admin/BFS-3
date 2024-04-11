'''
TC: O(2^n) - we are doing an exhaustive approach by BFS
SC: O(n) - for maintaining the queue - it will have maximum of n/2 leaf nodes
'''
from typing import List

class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        res = set()

        def isValid(word):
            count = 0
            for letter in word:
                if letter.isalpha():
                    continue
                if letter == '(':
                    count +=1
                else:
                    count -= 1
                if count<0:
                    return False
            return True if count == 0 else False

        q = set([s])
        while not res:
            children = set()
            for word in q:
                if isValid(word):
                    res.add(word)
                    continue
                for i in range(0,len(word)):
                    if word[i] not in "()":
                        continue
                    subchild = word[:i]+word[i+1:]
                    children.add(subchild)
            q = children
        return res
s = Solution()
print(s.removeInvalidParentheses("()())()"))
print(s.removeInvalidParentheses("(a)())()"))
print(s.removeInvalidParentheses(")("))
print(s.removeInvalidParentheses("n"))
print(s.removeInvalidParentheses("()"))
print(s.removeInvalidParentheses(")(f"))
print(s.removeInvalidParentheses("((()((s((((()"))
