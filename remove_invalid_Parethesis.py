class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        if len(s) == 0:
            return []
        que = deque()
        set1 = set()
        result = []
        que.append(s)
        flag1 = False
        # start BFS
        def isValid(s):
            count = 0
            for char in s:
                if char == "(":
                    count = count +1
                elif char == ")":
                    count = count -1
                    if count < 0:
                        return False
            return count == 0


        while que and not flag1:
            size = len(que)
            
            for i in range(size):
                set1.add(s)
                curr = que.popleft()
                if isValid(curr):
                    flag1 = True
                    result.append(curr)
                elif flag1 == False:
                    for j in range(len(curr)):
                        c = curr[j]
                        if c >= "a" and c<="z":
                            continue
                        child = curr[:j] + curr[j+1:]
                        if child not in set1:
                            set1.add(child)
                            que.append(child)
        return result
