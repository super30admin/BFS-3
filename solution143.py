#Time Complexity:O(2^n)
#Space Complexity:O(n*2^n)
class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        result=[]                                               #use an output array that stores valid strings
        if not s:
            result.append("")
            return result                                       #if s is empty return output array with empty string
        hset=[]
        q=deque()                                               #use a queue and a hashset to store the possible string combinations
        q.append(s)
        hset.append(s)
        flag=False                                              #flag is used to store the occurance of a valid string
        while q:                                                #while the queue is populated
            size=len(q)                                         #parse through elemnts of queue at this point
            for i in range(size):
                curr=q.popleft()
                if self.isValid(curr):                          #if the current string is valid, st flag to true and append it to output array
                    flag=True
                    result.append(curr)
                if not flag:                                    #if the flag is not set, parse through the current string, if a character is alphabet continue
                    for j in range(len(curr)):
                        if curr[j].isalpha():
                            continue
                        child=curr[:j]+curr[j+1:]               #else try possible combinations of current string and append it to the queue as well as the hashset
                        if child not in hset:
                            q.append(child)
                            hset.append(child)
        return result                                           #return the output array once all possibilities are parsed
    
    def isValid(self,s:str)->bool:                              #to check if a string is valid or not , use count to see of the number of braces match
        count=0
        for i in range(len(s)):
            c=s[i]
            if c=='(':                                          #if opening brace is encountered increment count
                count+=1
            elif c==')':                                        #if closing brace is matched  and count is not zero, decrement count
                if count==0:
                    return False
                count-=1
        return count==0                                         #return boolean of count equals zero