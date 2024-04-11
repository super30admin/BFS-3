'''
TC: O(E+V) - vertices and edges in a graph
SC: O(V+E) - since we are using a map for queue and map
'''
from collections import deque
from typing import Optional

# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []

class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if not node:
            return
        res = node
        q = deque()
        #acts as visited and stores original to copy nodes
        dmap = {}
        q.append(node)
        while q:
            original = q.popleft()
            if original not in dmap:
                dmap[original] = Node(original.val)
            for child in original.neighbors:
                if child not in dmap:
                    copyChild = Node(child.val)
                    dmap[child] = copyChild
                    q.append(child)
                dmap[original].neighbors.append(dmap[child])
        return dmap[res]