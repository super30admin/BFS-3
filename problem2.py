# problem 2 

## Problem2 Clone graph (https://leetcode.com/problems/clone-graph/)


"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

from typing import Optional
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if not node:
            return None
        self.my_node = {}
        self.dfs(node)
        return self.my_node[node]

    def dfs(self,node):
        copy_node =  self.clone(node)
        for ne in node.neighbors:
            if ne not in self.my_node:
                self.dfs(ne)
            copy_node.neighbors.append(self.my_node[ne])

    
    def clone(self,node):
        if node is None:
            return None 
        if node in self.my_node:
            return self.my_node[node]
        self.my_node[node] =  Node(node.val)
        return self.my_node[node]