# Problem 1: Remove Invalid Parentheses
class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        result = []
        q = deque()
        seen = set()
        flag = False
        q.append(s)
        seen.add(s)

        def isValid(currStr):
            count = 0
            for c in currStr:
                if c == "(": count += 1
                elif c == ")": count -= 1
                if count < 0: return False
            return count == 0

        while q and not flag:
            size = len(q)
            for i in range(size):
                currStr = q.popleft()
                if isValid(currStr):
                    result.append(currStr)
                    flag = True
                elif not flag:
                        for k in range(len(currStr)):
                            if currStr[k] not in "()": continue
                            baby = currStr[0:k] + currStr[k+1:]
                            if baby not in seen:
                                q.append(baby)
                                seen.add(baby)
               

        return result if result else [""]


        