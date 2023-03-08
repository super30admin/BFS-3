#time O(N)
#space O(N)
"""
# Definition for a Node.
class Node:
    def __init__(self, val, neighbors):
        self.val = val
        self.neighbors = neighbors
"""
class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if node == None:
            return node
        
        clonedMap = dict()
        
        def createNode(node, clonedMap):
            if (node in clonedMap):
                return clonedMap[node]
            
            clone = Node(node.val, [])
            clonedMap[node] = clone
            
            for n in node.neighbors:
                clone.neighbors.append(createNode(n, clonedMap))
                
            return clone

        return createNode(node, clonedMap)
        