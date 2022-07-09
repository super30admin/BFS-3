'''
time complexity:  O(V+E)
space compleixty: O(V+E)
'''
"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        
        clone = {}
        
        def dfs(node: object):
            if node in clone:
                return clone[node]
            
            clone_node = Node(node.val)
            clone[node] = clone_node
            for ngh in node.neighbors:
                clone_node.neighbors.append(dfs(ngh))
                
            return clone_node
        return dfs(node) if node else None