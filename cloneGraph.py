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
        cloneNodes = collections.defaultdict(Node)
        def create(node):
            if not node:
                return None
                
            if node in cloneNodes:
                return cloneNodes[node]

            clone = Node(node.val)
            cloneNodes[node] = clone
            for nei in node.neighbors:
                clone.neighbors.append(create(nei))
            return clone
        return create(node)
