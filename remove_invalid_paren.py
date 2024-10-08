# Time complexity - O(2^n * n) -> 2^n for each recursion and n for validating
# Space complexity O(s)
class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        result = []
        q = deque([s])
        visited = set()
        flag = False
        def is_balanced(t):
            count = 0
            for ch in t:
                if ch == '(':
                    count += 1
                elif ch == ')':
                    count -= 1
                    if count < 0:
                        return False
            return count == 0
        if is_balanced(s): return [s]
        while q and not flag:
            for _ in range(len(q)):
                st = q.popleft()
                if is_balanced(st): 
                    result.append(st) 
                    flag = True
                if not flag:
                    for i,ch in enumerate(st):
                        if ch not in ['(',')']: continue
                        child = st[:i] + st[i+1:]
                        if child not in visited:
                            visited.add(child)
                            q.append(child)
        return result

