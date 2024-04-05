"""
Time Complexity : O(v+e) where v is the total number of vertex/node of the graph and e are the edges of the graph
Space Complexity : O(v) where v is the total number of vertex/node of the graph. This is because hashMap will contain entries of all the nodes/vertexes of the graph

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




from typing import Optional
from collections import defaultdict
class Solution:
    def __init__(self):
        self.hashMap = defaultdict(Node)

    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if node == None:
            return node
        self.dfs(node)
        return self.hashMap[node]

    def dfs(self, node):
        # base
        if node in self.hashMap:
            return

        # logic
        newNode = Node(node.val)
        self.hashMap[node] = newNode
        neighbors = node.neighbors
        for neighbor in neighbors:
            self.dfs(neighbor)
            self.hashMap[node].neighbors.append(self.hashMap[neighbor])
