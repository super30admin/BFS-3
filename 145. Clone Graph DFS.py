"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""
from collections import deque


class Solution:
    hashMap = {}

    def cloneGraph(self, node: 'Node') -> 'Node':
        if node is None:
            return node
        self.hashMap = dict()
        # copyNode = self.clone(node)
        self.dfs(node)
        return self.hashMap.get(node)

    def dfs(self, node):
        # print("this")
        # if node in self.hashMap:
        #     return
        self.clone(node)
        children = node.neighbors
        # edges
        for child in children:
            if child not in self.hashMap.keys():
                self.clone(child)
                self.dfs(child)
            self.hashMap.get(node).neighbors.append(self.hashMap.get(child))

    def clone(self, node):
        copy = Node(node.val)
        self.hashMap[node] = copy
        return copy

# DFS
# Time Complexity: O(V + E)
# Space Complexity: O(V + E)
