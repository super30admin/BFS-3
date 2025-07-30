"""
I implemented the graph cloning using the BFS technique. A visited hashmap is used to keep track of already cloned nodes, mapping each original node to its clone. We start by cloning the input node and enqueue it. While traversing, we clone each neighbor if it hasn't been visited, and add the clone to the current node's neighbor list. This ensures all nodes and their connections are copied accurately.
Time Complexity: O(V+E)
Space Compelxity: O(V)
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
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if not node:
            return None

        visited = {}
        queue = deque([node])
        visited[node] = Node(node.val)

        while queue:
            curr = queue.popleft()
            for neighbour in curr.neighbors:
                if neighbour not in visited:
                    visited[neighbour] = Node(neighbour.val)
                    queue.append(neighbour)
                visited[curr].neighbors.append(visited[neighbour])
        return visited[node]