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
        # BFS
        if not node:
            return None
        # Map to hold clone nodes
        # As every node is visited, add a deep copy of the node to clone
        clone = collections.defaultdict(lambda: Node)

        # Initialize a BFS queue
        q = collections.deque([node])
        clone[node] = Node(node.val, [])

        while q:
            # Pop node from queue and mark it as visited
            current_node = q.popleft()

            # Explore the neighbors
            for neighbor in current_node.neighbors:
                if neighbor not in clone:
                    # Create a new node corresponding to every node
                    clone[neighbor] = Node(neighbor.val, [])
                    q.append(neighbor)
                # Append the neighbors
                clone[current_node].neighbors.append(clone[neighbor])
        return clone[node]
