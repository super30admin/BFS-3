
# TC = O(2 ^ n)
# SC = O(n)

class Solution(object):
    def removeInvalidParentheses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        queue = deque([s])
        visited = set()
        result = []
        visited.add(s)
        isFound = False

        # this will make sure, if a valid string is found on one level,
        # we needn't push the next level items

        def isValid(string):
            count = 0
            for ch in string:
                if ch == "(":
                    count += 1
                elif ch == ")":
                    count -= 1
                    if count < 0:
                        return False
            return count == 0

        while queue:
            current = queue.popleft()

            if isValid(current):
                result.append(current)
                isFound = True
            else:
                if not isFound:
                    for i in range(len(current)):
                        if current[i].isalpha():
                            continue
                        substring = current[0:i] + current[i+1:]
                        if substring not in visited:
                            queue.append(substring)
                            visited.add(substring)

        return result
