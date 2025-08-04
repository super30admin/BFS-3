"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""
# Time Complexity: O(V+E)
# Space Complexity: O(V)
# BFS Approach
# from typing import Optional
# class Solution:
#     def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
#         if node is None:
#             return None
#         self.map = {}
#         q = deque([node])
#         while q:
#             curr = q.popleft()
#             currCopy = self.clone(curr)

#             for ne in curr.neighbors:
#                 if ne not in self.map:
#                     q.append(ne)
#                 currCopy.neighbors.append(self.clone(ne))
#         return self.map[node]
#     def clone(self, node):
#         if node is None:
#             return None
#         if node in self.map:
#             return self.map[node]
#         self.map[node] = Node(node.val)
#         return self.map[node]

# Time Complexity: O(V+E)
# Space Complexity: O(V)
# DFS Approach
from typing import Optional
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if node is None:
            return None

        self.map = {}
        self.dfs(node)
        return self.map[node]

    def dfs(self, curr):
        copyCurr = self.clone(curr)

        for ne in curr.neighbors:
            if ne not in self.map:
                self.dfs(ne)
            copyCurr.neighbors.append(self.clone(ne))

    def clone(self, node):
        if node is None:
            return None
        if node in self.map:
            return self.map[node]
        self.map[node] = Node(node.val)
        return self.map[node]