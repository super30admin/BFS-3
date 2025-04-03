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
        Map1 = {}
        if node == None:
            return None
        visited = {}
        que = deque([node])
        visited[node] = Node(node.val)
        while que:
            old_node = que.popleft()
            for neighbour in old_node.neighbors:
                if neighbour not in visited:
                    visited[neighbour] = Node(neighbour.val) 
                    que.append(neighbour)
                visited[old_node].neighbors.append(visited[neighbour])
        return visited[node]