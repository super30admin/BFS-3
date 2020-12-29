"""
TC= O(V+E)
SC=O(V) in queue

BFS solution to process each node and its nei level by level 

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
        nodeMap= {} #key: value node:node 
        q = [node]
        copy=Node(node.val)
        nodeMap[node]=copy
        while q:
            curr = q.pop(0)
            for nei in curr.neighbors:
                if nei not in nodeMap:
                    copyNode=Node(nei.val)
                    nodeMap[nei]=copyNode
                    q.append(nei)
            #Take the curr node deepcopy's neighbour list and add the deep copy of the neighbour nodes
                nodeMap[curr].neighbors.append(nodeMap[nei])
        
        return copy