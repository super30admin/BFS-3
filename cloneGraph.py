# Time Complexity : O(v+e) where v is the vertices of the graph and e is the edges
# Space Complexity : O(v+e)
# Did this code successfully run on Leetcode : Yes
"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        queue = []
        nodeMap = {}
        if node:
            queue.append(node)

        while len(queue) != 0:
            old = queue.pop(0)
            if old not in nodeMap:
                nodeMap[old] = Node(old.val)
            new = nodeMap[old]
            for neighbor in old.neighbors:
                if neighbor not in nodeMap:
                    newNeighbor = Node(neighbor.val)
                    nodeMap[neighbor] = newNeighbor
                    new.neighbors.append(newNeighbor)
                    queue.append(neighbor)
                else:
                    new.neighbors.append(nodeMap[neighbor])

        return nodeMap[node] if node else None
