class Solution:
    # queue bfs approach
    # TC : exponential
    def isValid(self, s: str) -> bool:
        count = 0
        for ch in s:
            if ch == '(':
                count += 1
            elif ch == ')':
                count -= 1
                if count < 0:
                    return False
        return count == 0
    def removeInvalidParentheses(self, s: str) -> List[str]:
        if s is None:
            return [""]
        q = deque()
        hset = set()
        res = []
        q.append(s)
        hset.add(s)
        flag = False
        # start bfs
        while q and not flag:
            size = len(q)
            for i in range(size):
                cur = q.popleft()
                if self.isValid(cur):
                    flag = True
                    # if cur not in hset:
                    res.append(cur)
                    hset.add(cur)
                elif flag == False:
                    for j in range(len(cur)):
                        c = cur[j]
                        if c.isalpha():
                            continue
                        child = cur[:j]+cur[j+1:]
                        if child not in hset:
                            hset.add(child)
                            q.append(child)
        return res
        