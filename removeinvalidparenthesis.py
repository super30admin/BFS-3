#Time Complexity: O(n*n)
#Space Complexity: O(n)
class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        q = deque()
        lst = []
        if self.check(s):
            lst.append(s)
            return lst
        st = set()
        q.append(s)
        st.add(s)
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                length = len(curr)
                for i in range(length):
                    string = curr[:i] + curr[i+1:]
                    if self.check(string) and string not in st:
                        lst.append(string)
                        st.add(string)
                        
                    if string not in st:
                        q.append(string)
                        st.add(string)
            if lst:
                return lst
        
            
    def check(self,string):
        count = 0
        for i in range(len(string)):
            if string[i] == '(':
                count += 1
            if string[i] == ')':
                count -= 1
                if count<0:
                    return False
         
        return True if count == 0 else False
            