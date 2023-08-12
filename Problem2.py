"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""


class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        '''
        The code performs a BFS traversal of the original graph and creates a cloned graph.
        Time Complexity: O(N + E), where N is the number of nodes and E is the number of edges.
        Space Complexity: O(N), for the clone_map and the queue.
        '''
        if not node:
            return None

        # Create a dictionary to map original nodes to their cloned counterparts
        clone_map = {}

        # Create a queue for BFS traversal
        queue = collections.deque([node])

        # Create the cloned node for the starting node
        clone_node = Node(node.val)
        clone_map[node] = clone_node

        while queue:
            current = queue.popleft()

            # Traverse through the neighbors of the current node
            for neighbor in current.neighbors:
                if neighbor not in clone_map:
                    # If the neighbor is not cloned yet, create a clone and add it to the queue
                    clone_neighbor = Node(neighbor.val)
                    clone_map[neighbor] = clone_neighbor
                    queue.append(neighbor)

                # Add the cloned neighbor to the neighbors list of the cloned current node
                clone_map[current].neighbors.append(clone_map[neighbor])

        return clone_node
