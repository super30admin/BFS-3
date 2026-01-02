"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

from typing import Optional
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if node is None: return None
        old_to_new = {}
        #old_to_new[node] = Node(node.val)

        # print(node)
        # print(old_to_new)
        #first part is create nodes and second part is traverse/link neighbors
        q = deque()
        q.append(node)
        visited = set()
        

        while q:
            cur = q.popleft()
            if cur in visited:
                continue
            
            #visited.add(cur)
            if cur not in old_to_new:
                old_to_new[cur] = Node(node.val) #first part

            #second part
            for nei in cur.neighbors:
                if nei not in old_to_new:
                    old_to_new[nei] = Node(nei.val)
                    q.append(nei)

                old_to_new[cur].neighbors.append(old_to_new[nei]) #actual linking
                
        
        return old_to_new[node]





        
