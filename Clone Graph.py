"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

from collections import deque

class Solution:
    #Solution 1
    def cloneGraph(self, node: 'Node') -> 'Node':
        #Approach: BFS
        #Time Complexity: O(V + E)
        #Space Complexity: O(V)
        #where, V is the number of vertices/nodes, and E is the number of edges
        
        if not node:
            return None
        
        de = deque()
        nodeMap = {}   #also used to track visited
        
        de.append(node)
        nodeMap[node] = Node(node.val)
        
        while de:
            popped = de.pop()
                
            for neighbor in popped.neighbors:
                if neighbor not in nodeMap:
                    nodeMap[neighbor] = Node(neighbor.val)
                    de.append(neighbor)
                
                nodeMap[popped].neighbors.append(nodeMap[neighbor])
                
        return nodeMap[node]
    
    #Solution 2
    """
    def __init__(self):
        self.nodeMap = {}   #also used to track visited
    
    def cloneGraph(self, node: 'Node') -> 'Node':
        #Approach: DFS  //  Recursion
        #Time Complexity: O(V + E)
        #Space Complexity: O(V)
        #where, V is the number of vertices/nodes, and E is the number of edges
        
        if not node:
            return None
        
        if node in self.nodeMap:
            return self.nodeMap[node]
        
        newNode = Node(node.val)
        self.nodeMap[node] = newNode
        
        for neighbor in node.neighbors:
            newNode.neighbors.append(self.cloneGraph(neighbor))
            
        return newNode
    """