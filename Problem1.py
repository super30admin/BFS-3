# Problem1 Remove Invalid Parentheses(https://leetcode.com/problems/remove-invalid-parentheses/)
# Time Complexity: O(2^n), in the worst case, every character could be a parenthesis and at each level of BFS we branch by removing one character at a time. This can generate up to 2^n distinct strings (each character is either kept or removed), where n is the length of the string.
# Space Complexity: O(2^n * n),the visited set can hold up to O(2^n) unique strings and each string takes O(n) space to store, so total space is O(2^n * n). The queue also holds strings from the current BFS level, which is bounded by the same amount.
# Approach:
# We use BFS to explore all possible strings formed by removing one parenthesis at a time. 
#Each level of BFS represents strings with one more character removed than the previous level. Because BFS explores level by level, the first level where we find any valid string automatically has the minimum number of removals.
# We let that entire level finish processing so we collect all valid strings at that same minimum removal count, then we stop generating new children so we never go deeper than necessary. 
#A visited set prevents us from reprocessing the same string twice if different removals produce the same result.

from collections import deque

class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        result = []            # this will store all valid strings found at the minimum removal level

        queue = deque([s])  
        # BFS queue starts with just the original string, deque lets us pop from
        # the front in O(1) time, which a normal list cannot do efficiently

        visited = set([s])  
        # tracks strings we have already generated so we do not process duplicates
        # the original string s is added here right away so we never re add it later

        found = False  
        # flag to track whether we have found at least one valid string yet once True, we stop branching further since that would remove more characters than the minimum needed

        while queue:  
            # keep going as long as there are strings left to process

            current = queue.popleft()  
            # pop the oldest string from the front of the queue, this is what
            # makes it BFS, we always process strings in the order they were added

            if self.isvalid(current):  
                # check if this string has balanced parentheses

                result.append(current)  
                # if valid, save it as one of our answers

                found = True  
                # mark that we found a valid string, this will stop future branching
                # note we do not return or break here, other strings at this same
                # level might also be valid and we want all of them

            elif not found:  
                # only try removing more characters if we have not found any valid
                # string yet at any level, this avoids going deeper than needed

                for i in range(len(current)):  
                    # check every index position in the current string

                    if current[i].isalpha():  
                        continue  
                        # skip letters, we are only allowed to remove parentheses
                        # continue moves on to the next index immediately

                    new_bee = current[:i]+ current[i+1:]  
                    # build a new string with the character at index i removed
                    # current[:i] is everything before index i
                    # current[i+1:] is everything after index i
                    # joining them together skips over index i entirely

                    if new_bee not in visited:  
                        # only proceed if we have not already generated this exact string before, avoids duplicate work

                        queue.append(new_bee)  
                        # add this new candidate to the back of the queue so it gets processed in the next BFS level

                        visited.add(new_bee)  
                        # mark it as seen so we do not regenerate it again later

        return result  
        # after the queue empties, return all valid strings found at the minimum removal level

    def isvalid(self,s: str) -> List[str]:
        count = 0  
        # running counter, tracks unmatched open parentheses

        for char in s:  
            # walk through the string left to right

            if char.isalpha():
                continue  
                # letters do not affect balance, skip them

            if char =='(':
                count +=1  
                # an open bracket increases the count of unmatched opens
            else:
                count -=1  
                # a close bracket decreases the count, it is trying to match an earlier open bracket

            if count < 0:
                return False  
                # if count goes negative, we hit a close bracket with no open bracket to match it, the string is invalid right away

        return count == 0  
        # after scanning the whole string, it is only valid if every open bracket was matched, meaning count is exactly 0 at the end