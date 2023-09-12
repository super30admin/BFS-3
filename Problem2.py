#Time Complexity :O(V+E) 
#Space Complexity :O(V)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

from typing import Optional
from collections import deque
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if not node:
            return None
        self.map={}
        q=deque()
        newNode=self.clone(node)
        q.append(node)
        while q:
            curr=q.popleft()
            for neighbor in curr.neighbors:
                if neighbor not in self.map.keys():
                    q.append(neighbor)
                newNeighbor=self.clone(neighbor)
                self.map.get(curr).neighbors.append(newNeighbor)
        return newNode      

    def clone(self,node):
        if node not in self.map:
            nodeCopy=Node(node.val)
            self.map[node]=nodeCopy
        return self.map[node]