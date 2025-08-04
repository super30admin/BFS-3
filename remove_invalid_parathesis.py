from collections import deque

def removeInvalidParentheses(s):
    def is_valid(s):
        count = 0
        for char in s:
            if char == '(':
                count += 1
            elif char == ')':
                count -= 1
                if count < 0:
                    return False
        return count == 0

    queue = deque([s])
    visited = {s}
    found = False
    result = []

    while queue:
        cur = queue.popleft()
        if is_valid(cur):
            found = True
            result.append(cur)
        elif not found:
            for i in range(len(cur)):
                if cur[i] in ('(', ')'):
                    t = cur[:i] + cur[i+1:]
                    if t not in visited:
                        visited.add(t)
                        queue.append(t)

    return result

# Time complexity: O(n * 2^n) in the worst case
# Space complexity: O(n * 2^n) in the worst case
