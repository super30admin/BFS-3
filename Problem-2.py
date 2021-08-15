"""
Approach: BFS + hash map

TC: O(V+E) V -> numder of nodes, E -> connections/neighbors
SC: O(V)
"""
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
        if not node: return node
        q = deque()
        hash_map = {}
        copy_node = Node(node.val)
        hash_map[node] = copy_node
        q.append(node)
        while q:
            curr = q.pop()
            for neighbor in curr.neighbors:
                if neighbor not in hash_map:
                    copy_node = Node(neighbor.val)
                    hash_map[neighbor] = copy_node
                    q.append(neighbor)
                hash_map[curr].neighbors.append(hash_map[neighbor])
        return hash_map[node]