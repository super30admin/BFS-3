"""
TC: O(2^N) {In the worst case, we generate all possible substrings by removing one parenthesis at a time. 
             Each substring validation takes O(N) time, but we stop processing deeper levels once valid strings 
             are found, effectively pruning the search space. In practice, this performs much faster than the worst case.}
SC: O(2^N) {We use a queue to perform BFS and a set to track visited substrings. 
             In the worst case, all possible substrings could be stored in memory simultaneously, 
             leading to exponential space complexity.}

Approach:
We are tasked with removing the minimum number of invalid parentheses to make the input string valid 
and returning all possible results.

We use a Breadth-First Search (BFS) approach to ensure minimal removals:
    - We start by adding the original string to a queue.
    - For each level of BFS, we process all strings of the same "removal depth".
    - For each string, we check whether it is valid using a helper function `isValid` that ensures parentheses 
      are balanced while ignoring alphabetic characters.
    - If a valid string is found, it is added to the result list, and we set a flag to stop exploring deeper levels 
      (since deeper levels represent more removals, which we don't need).
    - If no valid strings are found at the current level, we generate all possible strings by removing one parenthesis 
      at each index and enqueue them for the next level, skipping duplicates using a visited set.

This BFS approach guarantees that all valid strings in the result have the minimum number of removals 
required to balance the parentheses.

This problem ran successfully on Leetcode.
"""


class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        def isValid(s: str) -> bool:
            closed = {')'}
            count = 0

            for curr in s:   
                if curr in closed:
                    count -= 1
                elif curr.isalpha():
                    continue
                else:
                    count += 1
                if count < 0:
                    return False
                     
            return count == 0
        

        hSet = set()
        res = []
        q = deque([s])
        flag = False

        while q and not flag:
            for _ in range(len(q)):
                curr = q.popleft()
                if isValid(curr):
                    res.append(curr)
                    flag = True
                
                if not flag:
                    # process further deep
                    for i in range(len(curr)):
                        #skip the alpha char
                        if curr[i].isalpha():
                            continue

                        #skip the ith character
                        baby = curr[:i]+curr[i+1:]
                        if baby not in hSet:
                            q.append(baby)
                            hSet.add(baby)
                
        return res