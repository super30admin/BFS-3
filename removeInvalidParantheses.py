#Time Complexity : O(2^n) where n is the length of string
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : Yes

class Solution:
    def isValid(self, s):
        count = 0
        for char in s:
            if char == "(":
                count += 1
            elif char == ")":
                if count == 0:
                    return False
                else:
                    count -= 1

        return count == 0

    def removeInvalidParentheses(self, s: str) -> List[str]:
        q = deque([s])
        result = []
        found = False
        seen = set()

        while q and not found:
            for _ in range(len(q)):
                curr = q.popleft()
                if self.isValid(curr): #check if our current parantheses string is valid or not
                    found = True
                    result.append(curr)
                if not found: #if we haven't already found valid parantheses, only then create new children
                    for i in range(len(curr)):
                        if not curr[i].isalpha(): #check if the char is not a letter
                            child = curr[:i] + curr[i+1:] #remove ith index char to make new child
                            if child not in seen:
                                seen.add(child)
                                q.append(child)

        return result
