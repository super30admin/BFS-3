"""
Iterate through the vertices and create a clone and map it to original, Next iterate through the neighbors and assign neighbors to newNodes  
TC: O(V+E)
SP: O(V)
"""
"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

from typing import Optional


class Solution:
    def cloneGraph(self, node: Optional["Node"]) -> Optional["Node"]:
        if not node:
            return node
        hmap = {}
        q = deque([node])
        while q:
            curr = q.popleft()
            newNode = Node(curr.val)
            hmap[curr] = newNode
            for n in curr.neighbors:
                if n not in hmap:
                    q.append(n)
        for k, v in hmap.items():
            for n in k.neighbors:
                v.neighbors.append(hmap[n])

        return hmap[node]
