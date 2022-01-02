# // Time Complexity :O(v+e)
# // Space Complexity :O(v), hmap storing vertices, depth of stack will be less than this
"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def __init__(self):
        self.hmap={}
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return node
        self.hmap[node]=Node(node.val)
        self.dfs(node)
        return self.hmap[node]
    def dfs(self,node):
        #base
        #logic
        for i in node.neighbors:
            if i not in self.hmap.keys():
                self.hmap[i]=Node(i.val)
                self.dfs(i)
            self.hmap[node].neighbors.append(self.hmap[i])