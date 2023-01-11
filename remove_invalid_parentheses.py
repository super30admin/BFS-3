class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:

        ## Approach 2 : DFS

        res = []
        hs = set()
        mx = [0]

        def is_valid(s):
            cnt = 0
            for i in s:
                if i == '(':
                    cnt += 1
                elif i == ')':
                    cnt -= 1
                    if cnt < 0:
                        return False
            if cnt == 0:
                return True


        def dfs(s):
            nonlocal res

            # base case
            if len(s) < mx[-1]:
                return

            # logic
            
            if is_valid(s):
                if len(s) > mx[-1]:
                    res = [s]
                    mx[-1] = len(s)
                    return
                elif len(s) == mx[-1]:
                    res.append(s)
                    return
            else:
                for i in range(len(s)):
                    if s[i] not in ['(', ')']:
                        continue
                    new_str = s[:i] + s[i+1:]
                    if new_str not in hs:
                        hs.add(new_str)
                        dfs(new_str)
        
        dfs(s)

        return res
            

        # Approach 1 : BFS
        # T.C = O(2^n)

        def is_valid(s):
            cnt = 0
            for i in s:
                if i == '(':
                    cnt += 1
                elif i == ')':
                    cnt -= 1
                    if cnt < 0:
                        return False
            if cnt == 0:
                return True
        

        hs = set()
        result = []
        q = [s]
        flag = False

        while q and not flag:
            size = len(q)
            for i in range(size):
                string = q.pop(0)
                if is_valid(string):
                    result.append(string)
                    flag = True
                elif flag != True:
                    for j in range(len(string)):
                        if string[j] not in ['(', ')']:
                            continue
                        new_str = string[:j] + string[j+1:]
                        if new_str not in hs:
                            hs.add(new_str)
                            q.append(new_str)
            
            
        
        #print(result)
        return result

                    

            