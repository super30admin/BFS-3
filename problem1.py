# TC: EXpornential
# SC:(n)

class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        if s is None or len(s) == 0:
            return []

        _set = set()
        queue = []
        result = []
        flag = False
        queue.append(s)
        _set.add(s)

        while queue and flag == False:
            size = len(queue)

            for i in range(0, size):
                curr = queue.pop(0)
                if self.isValid(curr):
                    flag = True
                    result.append(curr)
                elif flag == False:
                    for j in range(0, len(curr)):
                        if curr[j].isalpha():
                            continue
                        sub = curr[:j] + curr[j + 1:]
                        if sub not in _set:
                            _set.add(sub)
                            queue.append(sub)

        return result

    def isValid(self, curr):
        count = 0
        for i in range(0, len(curr)):
            if curr[i] == "(":
                count += 1
            elif curr[i] == ")":
                count -= 1
            if count < 0:
                return False

        return count == 0


