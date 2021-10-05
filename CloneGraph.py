"""
Time Complexity : O(V + E) where V is the no. of vertices and E is the no. of edges
Space Complexity : O(V) where V is the no. of vertices. 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return node
        # Dictionary to keep copy of the node and its connections
        self.hashMap = {}
        self.dfs(node)
        return self.hashMap[node]
    def dfs(self, node):
        # Basic
        if node in self.hashMap: return 
        # Logic
        self.hashMap[node] = Node(node.val, [])
        for neighbor in node.neighbors:
            self.dfs(neighbor)
            self.hashMap[node].neighbors.append(self.hashMap[neighbor])