"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""
#time complexity o(v+e)
#space complexity o(v+e)
from typing import Optional
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if not node:
            return None
        hmap = {}
        q = deque()

        newNode = Node(node.val)
        hmap[node] = newNode
        q.append(node)

        while q:
            curr = q.popleft()
            neighbors = curr.neighbors
            for ne in neighbors:
                if ne not in hmap:
                    copyNode = Node(ne.val)
                    hmap[ne] = copyNode
                    q.append(ne)
                
                hmap[curr].neighbors.append(hmap[ne])
        
        return newNode
        


        