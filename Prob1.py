#Method 1 - BFS, remove 1 character from left at each level, and the moment it's valid, set flag to True and stop processing at the end of current level.

#TC - n^n, each n-1 baby in level 1 has n-2 babies and so forth -> n^n.

#Method 2 - DFS, same logic, it's just the difference in iterating the tree. 
#Here, if current len of s is smaller than max_val we have found, no need to compute anything-> return
#If not smaller check if valid, if len(s) is bigger than max we have found so far, that means we have found new valid string with minimum changes, so empty the res and append it
#Then, if it's equal, just add it to existing res
#Then call DFS on all it's babies.

#TC - n^n, each n-1 baby in level 1 has n-2 babies and so forth -> n^n.

class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:

        #Method 1 - BFS

        # q = deque()
        # h = set()

        # def isvalid(s):
        #     count = 0
        #     for c in s:
        #         if c == '(':
        #             count += 1
        #         elif c == ')':
        #             count -= 1
        #             if count < 0:
        #                 return False
        #     return count == 0

        # res = []
        # if not s or len(s) == 0:
        #     return [""]

        # q.append(s)
        # h.add(s)
        # found = False

        # while q:
        #     curr = q.popleft()
        #     if isvalid(curr):
        #         found = True #we don't want to further compute the child of current valid string and any of next level. Since we want minimum removal, so if there's any more valid string, it should be in this level itself.
        #         res.append(curr)
        #     elif not found:
        #         for k in range(len(curr)):
        #             c = curr[k]
        #             if c == '(' or c == ')':
        #                 baby = curr[:k] + curr[k + 1:]
        #                 if baby not in h:
        #                     h.add(baby)
        #                     q.append(baby)

        # return res if res else [""]

        #Method 2 - DFS,
        res = []
        h = set()
        max_val=0
        
        if not s or len(s) == 0:
            return [""]

        def isvalid(s):
            count = 0
            for c in s:
                if c == '(':
                    count += 1
                elif c == ')':
                    count -= 1
                    if count < 0:
                        return False
            return count == 0

        def dfs(s):
            nonlocal res,max_val #these 2 are global variables
            #base
            if len(s)<max_val: return #if current len of s is smaller than max_val we have found, no need to compute anything-> return
            if isvalid(s):#else, if it's equal or smaller, check if's valid
                if len(s)>max_val: #if valid, if len(s) is bigger than max we have found so far, that means we have found new valid string with minimum changes, so empty the res and append it
                    max_val=len(s)
                    res=[]
                res.append(s) #now, if it's equal, just add it to existing res
                return
            #logic
            for k in range(len(s)): #same logic as BFS, just call DFS on the baby.
                    c = s[k]
                    if c == '(' or c == ')':
                        baby = s[:k] + s[k + 1:]
                        if baby not in h:
                            h.add(baby)
                            dfs(baby)
            
        dfs(s)
        return res

            