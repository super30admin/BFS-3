"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

from typing import Optional
class Solution:
    # bfs approach
    # TC : O(v+e) v,e : number of vertices,edges
    # SC : O(v)
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if not node: 
            return node
        q = deque([node])
        clones = {node.val : Node(node.val)}
        while q:
            curnode = q.popleft()
            curclones = clones[curnode.val]
            for nei_node in curnode.neighbors:
                if nei_node.val not in clones:
                    clones[nei_node.val] = Node(nei_node.val)
                    q.append(nei_node)
                curclones.neighbors.append(clones[nei_node.val])
        return clones[node.val]
        