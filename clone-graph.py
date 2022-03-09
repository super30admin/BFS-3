'''
TC: O(V+E)
SC: O(V)
'''
"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

from collections import deque

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return 
        
        q = deque()
        q.append(node)
        q.append(None)
        hmap = {
            node: Node(node.val)
        }
        visited = set()
        visited.add(node)
        
        while q:
            top = q.popleft()
            if not top:
                if not q:
                    break
                q.append(None)
                continue
            for child in top.neighbors:
                if child not in visited:
                    visited.add(child)
                    q.append(child)
                hmap[child] = hmap.get(child, Node(child.val))
                hmap[top].neighbors.append(hmap[child])
        
        return hmap[node]