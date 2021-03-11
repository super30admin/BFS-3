"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""
# Approach - to avoid cycles we use a hashmap to see if we have already visited the nodes
# Time - O( V + E)
# Space - O(V + E)

# Adj list problem -- this is a graph problem so Time & Space is in terms of V & E
class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        
        if not node:
            return node
        
        self.hashmap = {}
        self.dfs(node)
        

        return self.hashmap[node]
    
    
    def dfs(self, node):
        
        # base case
        # if already in map
        if node in self.hashmap:
            return
        

        # logic
        
        cloned_node = Node(node.val)
        self.hashmap[node] = cloned_node
        
        
        for neighbor in node.neighbors:
            self.dfs(neighbor)
            
            #once dfs finished add to neighbors list of cloned node the neighbors of the current node we processed
            
            self.hashmap[node].neighbors.append(self.hashmap[neighbor])
           
            
                                         
    
        
    
    