# Time Complexity: O(V+E) - Number of vertices + edges
# Space Complexity: O(V)
"""
# Definition for a Node.
class Node(object):
    def __init__(self, val = 0, neighbors = []):
        self.val = val
        self.neighbors = neighbors
"""


class Solution(object):
    def cloneGraph(self, node):
        """
        :type node: Node
        :rtype: Node
        """
        # DFS
        if not node:
            return None
        # Map to hold clone nodes
        # As every node is visited, add a deep copy of the node to clone
        clone = collections.defaultdict(lambda: Node)

        def dfs(node):
            # Base Case
            # If node is already cloned, return clone
            if node in clone:
                return clone[node]
            
            # Logic
            # Create a clone of current node
            clone[node] = Node(node.val, [])
            
            # Recursively create clones of neighbors and add them to node's neighbor list
            for neighbor in node.neighbors:
                clone[node].neighbors.append(dfs(neighbor))
            return clone[node]

        return dfs(node)
