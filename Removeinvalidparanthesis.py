# // Time Complexity :O(2^n)
# // Space Complexity :O(N)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no
class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        # define when a combination of parenthesis is still valid
        def valid(candidate):
            counter = 0
            for char in candidate:
                if char == "(": counter += 1
                elif char == ")": counter -= 1
                if counter < 0: return False
            # balanced?
            return counter == 0
        # the actual BFS, we return the minimum of removals, so we stop as soon as we have something
        res, frontier = set() , set([s])
        while not res:
            _next = set()
            for candidate in frontier:
                if valid(candidate): res.add(candidate); continue
                # generate more candidates based on this candidate
                for i, letter in enumerate(candidate):
                    # skip trash
                    if letter not in "()": continue
                    _next.add(candidate[:i] + candidate[i+1:])
            frontier = _next
        return res