#space: O(2^n)
#time: O(n*2^n)
class Solution:

    # using BFS
    def removeInvalidParentheses(self, s: str) -> List[str]:
        #creating visited set and adding initial queue to starting string
        visited=set([s])
        q=[s]
        result=list()
        found= False
        while len(q) != 0:
            curr= q.pop(0)
            #adding all the strings of the queue that are valid
            if self.isvalid(curr):
                result.append(curr)
                found= True
            if found == False:
                for i in range(len(curr)):
                    #removing brackets for the entire length and pusing it to the queue
                    if curr[i] == '(' or curr[i]==')':
                        sub= curr[:i]+curr[i+1:]
                        if sub not in visited:
                            visited.add(sub)
                            q.append(sub)
                    
        if len(result) ==0:
            return ['']
        return result

    def isvalid(self,s):
        cnt=0
        for i in range(len(s)):
            if s[i]=='(':
                cnt+=1
            elif s[i]==')':
                if cnt==0:
                    return False
                cnt-=1
        if cnt==0:
            return True
        return False
                
