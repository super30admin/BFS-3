# Time Complexity: O(2^n)
# Space Complexity: O(n + |level|)
# Did this problem run on Leetcode: Yes
# Any issues faced doing this problem: No

class Solution(object):
    def removeInvalidParentheses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        level = {s}
        while True:
            valid = []
            for s in level:
                try:
                    eval('0,' + filter('()'.count, s).replace(')', '),'))
                    valid.append(s)
                except:
                    pass
            if valid:
                return valid
            level = {s[:i] + s[i + 1:] for s in level for i in range(len(s))}