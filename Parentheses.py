'''
Time Complexity : exponential O(2^n)
Space Complexity : O(l)- length of the queue
Approach : BFS. 
 - At each level, we need to remove a bracket from the curr value, if its valid, add it to the result array and convert the boolean to true. 
 - Next , Add all its children to the queue. Once the level is conpleted and the found boolean is True, do not proceed.
'''
class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        result = []
        if not s:
            return [""]
        queue = deque()
        found = False
        visited = set()
        queue.append(s)
        while queue and not found:
            size = len(queue)
            for i in range(size):
                curr = queue.popleft()
                if self.isValid(curr):
                    found = True
                    result.append(curr)
                for i in range(len(curr)):
                    if curr[i] not in '()':
                        continue
                    tempString = curr[:i]+curr[i+1:]
                    if tempString not in visited:
                        queue.append(tempString)
                        visited.add(tempString)
        return result

    def isValid(self, s):
        count = 0
        for i in range(len(s)):
            if s[i] == '(':
                count += 1
            elif s[i] == ')':
                if count == 0:
                    return False
                count -= 1
        return count == 0