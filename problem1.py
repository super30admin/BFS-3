# Time Complexity : O(n^n)
# Space Complexity : O(n^n)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO

import collections

class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        res = []
        seen = set()
        flag = False
        queue = collections.deque()
        queue.append(s)

        while queue and not flag:
            size = len(queue)
            for i in range(size):
                cur = queue.popleft()
                if self.is_valid(cur):
                    flag = True
                    res.append(cur)

                # process the babies
                if not flag:
                    for i in range(len(cur)):
                        if cur[i].isalpha():
                            continue
                        baby = cur[:i] + cur[i+1:]
                        if baby not in seen:
                            queue.append(baby)
                            seen.add(baby)
        
        return res
    
    def is_valid(self, cur):
        count = 0
        for c in cur:
            if c == "(":
                count += 1
            if c == ")":
                count -= 1
            if count < 0:
                return False

        return count == 0