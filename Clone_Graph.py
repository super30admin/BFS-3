# Time Complexity : O(V+E), where V is the number of vertices (nodes) in the graph and E is the number of edges
# Space Complexity : O(V), where V is the number of vertices (nodes) in the graph.

# Definition for a Node.
from typing import Collection


class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []


class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return node
        
        queue = Collection.deque()
        queue.append(node)
        clone_dict = {node: Node(node.val)}
        
        while queue:
            curr_node = queue.popleft()
            for neighbor in curr_node.neighbors:
                if neighbor not in clone_dict:
                    clone_dict[neighbor] = Node(neighbor.val)
                    queue.append(neighbor)
                clone_dict[curr_node].neighbors.append(clone_dict[neighbor])
        
        return clone_dict[node]