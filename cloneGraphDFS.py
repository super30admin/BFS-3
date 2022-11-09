#Time: O(V+E)
#Space: O(V+E)
#Program ran on leetcode successfully

"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if node is None:
            return None
        
        nodeMap = {}
        self.dfs(node, nodeMap)
        return nodeMap[node]
    
    def dfs(self, node, nodeMap):
        
        if node in nodeMap:
            return
        
        new_node = Node(node.val)
        nodeMap[node] = new_node
        for n in node.neighbors:
            self.dfs(n, nodeMap)
            nodeMap[node].neighbors.append(nodeMap[n])
        