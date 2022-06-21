#Remove Invalid Parentheses
# // Time Complexity : exponential
# // Space Complexity :exponential too?
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no



class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        
        visited = set()
        queue=[s]
        found = False
        res=[]
        def valid(s):
            count=0
            for i in s:
                
                if i=='(':
                    count+=1
                elif i ==')':
                    count-=1
                    if(count<0): return False
            return count==0
            
        
        while(queue and not found):
            size = len(queue)
            for i in range(size):
                st = queue.pop(0)               #for every string, take one of the substring out and add it to the visited and queue 
                if (valid(st)):                    #if the substring is valid, add to the result and go no more below that the current level
                    res.append(st)
                    found = True
                else:
                    if found==False:
                        for j in range(len(st)):
                            if st[j] not in ['(',')']: 
                                continue
                            new_string = st[:j] + st[j+1:]              #check for substring by removing one element from each index
                            if (new_string not in visited):
                                queue.append(new_string)
                                visited.add(new_string)
        return res
                
        