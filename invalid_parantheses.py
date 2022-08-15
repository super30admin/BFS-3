# Approach: BFS
# TC: O(n*n!) - as we are checking all combinations, n*n-1*n-2... so on at each level, by removing one char from the string s of len n
# SC: O(n!) - as we are creating new strings each time
from collections import deque
class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        if self.isValid(s): return [s]
        
        q = deque()
        visited = set()
        result = set()
        # add initial string in the set and queue
        visited.add(s)
        q.append(s)
        flag = False
        
        while q and not flag:
            s = len(q)
            for i in range(s):
                cur = q.popleft()
                for j in range(len(cur)):
                    if cur[j].isalpha(): continue
                    # skip jth char and build cur_str
                    cur_str = cur[:j] + cur[j+1:]
                    # if its not already visited(or seen)
                    if cur_str not in visited:
                        # then check if it is a valid group of "()"
                        if self.isValid(cur_str):
                            # if so, set flag to True
                            # setting flag true will avoid processing further levels
                            # in the BFS as we have already got the valid results
                            # we don't need to explore further, just process current 
                            # level and stop
                            flag=True
                            # add it to res and visited
                            result.add(cur_str)
                            visited.add(cur_str)
                        else:
                            # if it is not valid and flag is not set to True
                            # then add it to q for further processing and mark it visited
                            if not flag:
                                # we need to check flag because, at any given level
                                # it may happen that we have got a valid result while we are processing
                                # that level. In that case we no longer care to process any of its children
                                q.append(cur_str)
                                visited.add(cur_str)
        return result
    
    def isValid(self, s):
        count=0
        for i in s:
            if i==')': count-=1
            if i=='(': count+=1
            if count==-1: return False
        return not count > 0

# This problem can also be solved with DFS. But averagely this may perform better with BFS because its likely that 
# we may find our results relatively higher up in the tree that we are forming by removing one char at a time for generating
# next level of tree nodes in memory.