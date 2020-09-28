# Time complexity : O(n*2^n)
# Space complexity : O(n*2^n)
# Works on leetcode : Yes
#Approach - We use BFS here, by starting with s as first level. We validate each string in level and if it's valid, we save it
# and return the valid strings. Otherwise we create new level by removing one element from each string in the current level

def removeInvalidParentheses(self, s: str) -> List[str]:
        # initialize a set with one element
        # set is used here in order to avoid duplicate element
        level = {s}
        while True:
            valid = []
            for elem in level:
                if self.isValid(elem):
                    valid.append(elem)
            if valid:
                return valid
            # initialize an empty set
            new_level = set()
            # BFS
            for elem in level:
                for i in range(len(elem)):
                    new_level.add(elem[:i] + elem[i + 1:])
            level = new_level
    
    def isValid(self,s):
        count = 0
        for c in s:
            if c == '(':
                count += 1
            elif c == ')':
                count -= 1
                if count < 0:
                    return False
        return count == 0