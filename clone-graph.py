"""
# Definition for a Node.
class Node(object):
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution(object):
    def cloneGraph(self, node):
        """
        :type node: Node
        :rtype: Node
        """
        if not node:
            return None
        clone_map = {}
        clone_map[node] = Node(node.val)
        queue = [node]
        while queue:
            current = queue.pop(0) 
            for neighbor in current.neighbors:
                if neighbor not in clone_map:
                    clone_map[neighbor] = Node(neighbor.val)
                    queue.append(neighbor)
                clone_map[current].neighbors.append(clone_map[neighbor])
        return clone_map[node]