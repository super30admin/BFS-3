#Time complexity : O(N)
#Space complexity : O(N) 

from collections import deque
class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        queue = deque()
        result = []
        visited = set()
        found = False
        def valid(string):
            count = 0
            for index,item in enumerate(string):
                if item=='(':
                    count+=1
                elif item ==')':
                    count-=1
                else:
                    continue
                if count<0:
                    return False
            return count==0
        
        queue.append(s)
        visited.add(s)
        while(queue and not found):
            n = len(queue)
            for i in range(n):
                polled_string = queue.popleft()
                if valid(polled_string):
                    found = True
                    result.append(polled_string)
                if not found:
                    for i in range(len(polled_string)):
                        char = polled_string[i]
                        if char.isalpha():continue
                        newone = polled_string[:i]+polled_string[i+1:]
                        if newone not in visited:
                            queue.append(newone)
                            visited.add(newone)
                            
        return result

