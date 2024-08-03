# Time Complexity :
# O(n*2^n) 

# Space Complexity :  
# O(n*2^n) 




class Solution(object):
    def removeInvalidParentheses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        if not s or len(s)==0:
            return []

        queue = []
        hashSet = set()
        result = []
        flag = False
        queue.append(s)
        hashSet.add(s)

        while(queue and not flag):
            qSize = len(queue)
            for i in range(qSize):
                curr = queue.pop(0)
                if (self.isValid(curr)):
                    flag = True
                    result.append(curr)
                elif(flag == False):
                    # process the childs of curr string by removing "("" or ")" one by one
                    for j in range(len(curr)):
                        c = curr[j]
                        if c >= 'a' and c<= 'z':
                            continue
                        newStr = curr[0:j] + curr[j+1:]
                        if newStr not in hashSet:
                            hashSet.add(newStr)
                            queue.append(newStr)
        
        # return the result List
        return result
    
    def isValid(self, s):
        count = 0
        for i in range(len(s)):
            if s[i] == '(':
                count += 1
            elif s[i] == ')':
                count -= 1  
                if(count < 0):
                    return False
        return count == 0      