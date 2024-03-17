#Time Complexity :O(V+E)
#Space Complexity :O(V)
#Did this code successfully run on Leetcode :Yes
#Any problem you faced while coding this :No

# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []


from typing import Optional
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if not node:
            return None
        
        map = {}
        q = []

        q.append(node)
        map[node] = Node(node.val, [])

        while q:
            h = q.pop(0)

            for neighbor in h.neighbors:
                if neighbor not in map:
                    map[neighbor] = Node(neighbor.val, [])
                    q.append(neighbor)
                map[h].neighbors.append(map[neighbor])
            
        return map[node]



        