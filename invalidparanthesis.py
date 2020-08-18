# STEPS:
# Keep a queue to process the strings.
# create a hash set to keep a track of processed strings inside it.
# add the actual string to a queue. 
# traverse the queue till the level of strings children where the string is found to be valid. use breadth first search to traverse the string level by level.
# add the string's children to the queue.
# keep the track of the processed substrings in the hash set.
# Time complexity - O(2^n) -- since for every index we need to take two decisions whether to include it or not.
# Space complexity - O(n + 2^n) -- for queue and hashset  ??

from collections import deque

class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        queue = deque([s])
        found = False
        hashset = set([s])
        answer = []
 
        while queue:
            node = queue.popleft()
            if self.isValidParanthesis(node):
                answer.append(node)
                found = True
                
            if not found:
                # add every child node
                l=len(node)
                for i in range(l):
                    if node[i] in ['(', ')']:
                        nodesub = node[:i]+node[i+1:]
                        if nodesub not in hashset:
                            queue.append(nodesub)
                            hashset.add(nodesub)
        
        return answer
            
                
    def isValidParanthesis(self, s):
        count = 0
        for ch in s:
            if ch == "(":
                count += 1
            elif ch == ")":
                if count == 0: return False
                count -= 1
        return count == 0
        