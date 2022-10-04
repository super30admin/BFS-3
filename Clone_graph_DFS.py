"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""
# DFS Approach
# Time complexity : O(V + E)
# Space complexity : O(V)
# Leetcode : Solved and submitted

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        # check for null case
        if not node:
            return None
        
        # create hashmap to keep track of mapping
        self.graph = {}
        newNode = Node(node.val)
        self.graph[node] = newNode
        # calling dfs function
        self.dfs(node)
        
        # return the cloned node
        return self.graph[node]
    
    def dfs(self, node):
        # traverse over all the neighbors of the node
        for child in node.neighbors:
            if child not in self.graph:
                # clone the node and put it in the hashmap
                newNode = Node(child.val)
                self.graph[child] = newNode
                # recursively call the dfs on the child
                self.dfs(child)
                # add the neighbors to the cloned nodes
            self.graph[node].neighbors.append(self.graph[child])
