# // Time Complexity : O(2^n)
# // Space Complexity : O(2^n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no

# we do bdf at each level to check if there is a valid string at this level by removing each bracket exhaustively. If a valid is found at a level - we stop- we dont go to create the next level
from Queue import Queue

class Solution(object):
    def removeInvalidParentheses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        # O(2^n), O(2^n)
        def isValid(st):
            count = 0
            for i in range(len(st)):
                c = st[i]
                if c == '(':
                    count += 1
                elif c == ')':
                    count -= 1
                    if count < 0:
                        return False
            return count == 0

        res = []
        hset = set()
        hq = Queue()
        hq.put(s)
        hset.add(s)
        flag = False

        while not hq.empty():
            curr = hq.get()

            if isValid(curr):
                flag = True
                res.append(curr)

            if flag:
                continue  

            for j in range(len(curr)):
                c = curr[j]
                if c.isalpha():
                    continue
                child = curr[:j] + curr[j+1:]
                if child not in hset:
                    hq.put(child)
                    hset.add(child)

        return res


        