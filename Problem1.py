#time complexity o(2^n)
#space complexity o(2^n)

class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        hset = set()
        result = []
        q = deque()

        q.append(s)
        hset.add(s)
        flag = False
        while q and not flag:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                if self.isValid(curr):
                    result.append(curr)
                    flag = True

                #make all the children
                if not flag:
                    for i in range(len(curr)):
                        if curr[i] not in '()':
                            continue
                        baby = curr[:i] + curr[i+1:]
                        if baby not in hset:
                            q.append(baby)
                            hset.add(baby)
        return result

    def isValid(self,s: str) -> bool:
        count = 0
        for i in range(len(s)):
            if s[i] not in '()':
                continue
            if s[i] == '(':
                count += 1
            else:
                if count == 0:
                    return False
                count -= 1

        return count == 0

                
                

        