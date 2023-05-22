"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""


class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':

        # Approah 1
        # Time Complexity: O(v+e)
        # Space Complexity: O(v)
        hmap = {}  # USED TO MAP NEW CLONE NODES TO OLD NODES TO CHECK AND PREVENT ANY DUPLICATES

        def cloneDFS(node):
            if node in hmap:
                return hmap[node]

            clonenode = Node(node.val)
            hmap[node] = clonenode
            for neigh in node.neighbors:
                clonenode.neighbors.append(cloneDFS(neigh))
            return clonenode

        return cloneDFS(node) if node else None

        # Approach 2
        # Time Complexity: O(v+e)
        # Space Complexity: O(v)
        # return copy.deepcopy(node)