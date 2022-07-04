""""
Approach: BFS
1) Create a hashMap of emp.id:employee obj mapping, init result =0, and add given emp.id to queue
2) while q not empty, popleft, read id, get its importance add to result and subordinates from the map
3) iterate over subordinates, add them to queue, finally return result
TC: O(N) where N is employee ID. Although you can see that it is a graph like problem and hashmap is nothing but adj list we are creating. 
         Hence we can say its O(V+E) just that there are no edges. So it is O(V+V)
SC: O(N) for hashMap


"""

# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates

from collections import deque

class Solution(self, employees:List["Employee"],id : int) -> int :
    hashmap = {emp.id : emp for emp in employees}
    result = 0
    q = deque()

    q.append(id)
    while q:
        empid = q.popleft()
        emp = hashmap[empid]
        result+= emp.importance
        for sub in emp.subordinates:
            q.append(sub)

    return result



# Approach: DFS
# 1) Create a hashMap of emp.id:employee obj mapping, init result =0, and add given emp.id to stack
# 2) while stack not empty, popleft, read id, get its importance add to result and subordinates from the map
# 3) iterate over subordinates, add them to stack, finally return result

# TC: O(N) where N is employee ID. Although you can see that it is a graph like problem and hashmap is nothing but adj list we are creating. Hence we can say its O(V+E) just that there are no edges. So its O(V+V)
# SC: O(N)



# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates



class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        hashmap = {emp.id : emp for emp in employees}
        result = 0
        stack = list()
        
        stack.append(id)
        
        while stack:
            empid = stack.pop()
            emp = hashmap[empid]
            print(emp.id)
            result += emp.importance
            for sub in emp.subordinates:
                stack.append(sub)
        return result


"""
Approach: DFS
Recursive
TC: O(N) where N is employee ID. Although you can see that it is a graph like problem and hashmap is nothing but adj list we are creating. Hence we can say its O(V+E) just that there are no edges. So its O(V+V)
SC: O(N)
"""




class Solution:
    hashmap = None
    result = 0
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        self.hashmap = {emp.id : emp for emp in employees}
        self.dfs(id)
        return self.result

    def dfs(self, id):
        emp = self.hashmap[id]
        
        self.result += emp.importance
        for sub in emp.subordinates:
            self.dfs(sub)

    
