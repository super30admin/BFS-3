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
        self.unique = {}
        if not node:
            return None
        return self.recurse(node)
   
    def recurse(self, node):
        if node in self.unique:
            return self.unique[node]
        newNode = Node(node.val)
        self.unique[node] = newNode  

        for i in node.neighbors: 
            newNode.neighbors.append(self.recurse(i))
        
        return newNode
