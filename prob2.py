# Time Complexity : O(v+e)
# Space Complexity :O(v+e)
# Passed on Leetcode: yes

"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""
from collections import deque

class Node:
    def __init__(self, val=0, neighbors=None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []


class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return None
        
        clone_mapping = {}  # Maps original nodes to their clones
        clone_root = Node(node.val)  # Clone of the root node
        
        queue = deque([(node, clone_root)])
        clone_mapping[node] = clone_root
        
        while queue:
            original, clone = queue.popleft()
            for neighbor in original.neighbors:
                if neighbor not in clone_mapping:
                    clone_mapping[neighbor] = Node(neighbor.val)
                    queue.append((neighbor, clone_mapping[neighbor]))
                clone.neighbors.append(clone_mapping[neighbor])
        
        return clone_root
