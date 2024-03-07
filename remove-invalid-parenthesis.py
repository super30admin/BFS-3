#Time complexity : O(N.2^N) (For isValid and 2^N possible strings)
#Space complexity: O(N.2^N) 


class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        def isValid(s):
            count = 0
            for char in s:
                if char == '(':
                    count += 1
                elif char == ')':
                    count -= 1
                if count < 0:
                    return False
            return count == 0

        result = []
        seen = set([s])
        queue = deque([s])
        found = False

        while queue:
            for _ in range(len(queue)):
                curr = queue.popleft()
                if isValid(curr):
                    result.append(curr)
                    found = True
                if found:
                    continue # Stop if valid string found at current level

                # Generate all possible states
                for i in range(len(curr)):
                    if curr[i] in "()": # Only consider parentheses
                        next_str = curr[:i] + curr[i+1:]
                        if next_str not in seen:
                            seen.add(next_str)
                            queue.append(next_str)

            if found:
                break # Stop if valid strings have been found at this level

        return result
