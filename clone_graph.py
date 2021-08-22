# Time Complexity: O(V+E)
# Space Complexity:O(V)

# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []

from collections import defaultdict


class Solution:
    def __init__(self):
        self.visited = defaultdict()

    def cloneGraph(self, node):

        if not node:
            return node

        if node in self.visited:
            return self.visited[node]

        cnode = Node(node.val, [])

        self.visited[node] = cnode

        if node.neighbors:
            for i in node.neighbors:
                cnode.neighbors.append(self.cloneGraph(i))

        return cnode
