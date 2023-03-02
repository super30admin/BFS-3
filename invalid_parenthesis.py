# Time Complexity : O(2^n)
# Space Complexity : O(2^n)

class Solution:
    # Approach 1
    def __init__(self):
        self.out = set()
        self.max_string = 0

    def removeInvalidParentheses(self, s: str) -> List[str]:
        def checker(string):
            count = 0
            if not string:
                return True
            for i in range(len(string)):
                if string[i] == "(":
                    count += 1
                elif string[i] == ")":
                    count -= 1
                if count < 0:
                    return False
            return count == 0

        @lru_cache(None)
        def helper(string):
            # Base
            if string in self.out or len(string) < self.max_string:
                return
            if checker(string):
                if len(string) > self.max_string:
                    self.max_string = len(string)
                    self.out = set()
                    self.out.add(string)
                elif len(string) == self.max_string:
                    self.out.add(string)
            # Logic
            for i in range(len(string)):
                if string[i].isalpha():
                    continue
                new_str = string[:i] + string[i+1:]
                helper(new_str)

        helper(s)
        return self.out

        # Approach 2
        # flag = False
        # q = deque()
        # q.append(s)
        # while q:
        #     size = len(q)
        #     for _ in range(size):
        #         x = q.popleft()
        #         if checker(x):
        #             self.out.add(x)
        #             flag = True
        #         else:
        #             if not flag:
        #                 for i in range(len(x)):
        #                     if x[i].isalpha(): continue
        #                     new_str = x[:i] + x[i+1:]
        #                     if new_str not in self.out: q.append(new_str)
        #     if flag: break
        # return self.out
