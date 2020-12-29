"""
TC=O(V+E)
SC=O(N) recursive stack

DFS approach 
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
        if(node is None):
            return node
        
        self.nodeMap={}
        self.dfs(node)
        return self.nodeMap[node]
    
    def dfs(self,node):
        #base
        if(node in self.nodeMap): #if node is already cloned return that node
            return self.nodeMap[node]
        
        #logic
        copyNode=Node(node.val)
        self.nodeMap[node]=copyNode
        for nei in node.neighbors:
            self.dfs(nei)
             #Take the curr node deepcopy's neighbour list and add the deep copy of the neighbour nodes
            self.nodeMap[node].neighbors.append(self.nodeMap[nei])
        
       
       
        