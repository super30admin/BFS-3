#Time Complexity : O(N^N * N)
#Space Complexity : O(N^N)
class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        result = list()
        q = deque()
        q.append(s)
        hashset = set()
        flag = False
        def isValid(s):
            count = 0
            for c in s:
                if(c=="("):
                    count+=1
                elif(c==")"):
                    count-=1
                    if(count<0):
                        return False
            return (count==0)
        while q:
            size = len(q)
            for i in range(0,size):
                curr = q.popleft()
                if(isValid(curr)):
                    result.append(curr)
                    flag = True
                else:
                    if(flag==False):
                        for j in range(0,len(curr)):
                            if(curr[j].isalpha()):
                                continue
                            baby = curr[:j]+curr[j+1:]
                            if(baby not in hashset):
                                hashset.add(baby)
                                q.append(baby)
        return result
                            



        