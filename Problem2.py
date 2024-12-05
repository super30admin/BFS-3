# Problem 2: Clone Graph
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
        if not node: return None
        Map = {}
        q = deque()
        q.append(node)

        def clone(node):
            if node not in Map:
                Map[node] = Node(node.val)
            return Map[node]

        copyNode = clone(node)

        while q:
            currNode = q.popleft()
            for ne in currNode.neighbors:
                if ne not in Map:
                    q.append(ne)
                Map[currNode].neighbors.append(clone(ne))

        return copyNode
            

        