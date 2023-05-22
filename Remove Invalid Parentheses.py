class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        # BFS APPROACH Optimal Approach
        # Time Complexity: O(H) where H is the height of the tree
        # Space Complexity: O(n*n)
        visited = set()

        def valid(t):
            count = 0
            for i in range(len(t)):
                if t[i] == '(':
                    count += 1
                elif t[i] == ')':
                    if count == 0:
                        return False
                    else:
                        count -= 1
            return count == 0

        if valid(s):
            return [s]
        dq = deque()
        dq.append((s, 0))
        flag = [True, -1]
        res = []
        while dq:
            curr, lvl = dq.popleft()
            if not flag[0] and flag[1] < lvl:
                return res
            if curr in visited:
                continue
            if valid(curr):
                # print("valid", curr)
                res.append(curr)
                flag = [False, lvl]
            else:
                # print("Not valid", curr)
                for i in range(len(curr)):
                    temp = curr[:i] + curr[i + 1:]
                    dq.append((temp, lvl + 1))
            visited.add(curr)

        # print(dq)
        return res

