class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        result = []
        if not s:  # Check if the input string is empty
            return result
        if self.isValid(s): # If the give input is itself valid
            return [s]
        sett = set()
        q = deque()
        q.append(s)
        sett.add(s)
        found = False # Flag to check if we have already found the 
        # bigger valid string
        while q and not found:
            size = len(q)
            for k in range(size): # To form the child of 
            # every string in the queue
                curr = q.popleft()
                if self.isValid(curr):
                    # Input is 5 char and we formed 4 char child
                    # If we found one of them is valid we will not produce
                    # Child of other strings. Just check if to append or not
                    result.append(curr)
                    found = True
                if not found:
                    for i in range(len(curr)):
                        child = curr[:i] + curr[i+1:]
                        if child not in sett:
                            sett.add(child)
                            q.append(child)
        return result

    def isValid(self, s) -> bool:
        count = 0
        for i in range(len(s)):
            c = s[i]
            if c != '(' and c != ')': continue #if its character continue
            elif c == '(': count+=1
            else:
                if count == 0: return False
                count-=1
        return count == 0