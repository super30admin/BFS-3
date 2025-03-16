"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""
# Time:O(v+e)
# Space:O(v)
from typing import Optional
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if node is None:
            return 
        self.nmap= dict()
        q=[node]
        visited=set(q)
        while len(q) != 0:
            size= len(q)
            for i in range(size):
                curr= q.pop(0)
                new_node= self.clone(curr)
                for n in curr.neighbors:
                    if n not in visited:
                        q.append(n)
                        visited.add(n)
                    new_node.neighbors.append(self.clone(n))
        return self.nmap[node]

    def clone(self, node):
        if node not in self.nmap:
            new_node= Node(node.val)
            self.nmap[node]=new_node
        return self.nmap[node]
        
