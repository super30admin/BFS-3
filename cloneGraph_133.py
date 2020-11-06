# Time Complexity : O(V+E)
# Space Complexity : O(V+E)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach/Intuition:
# Shallow copy: Two objects(original and clone) both point to same referencing object. If you update one, other updates itself. Deep Copy: Obj has a reference object and clone obj also has a diff reference object, one-to-one mapping. 
# In a graph, following a DFS/BFS would give the answer. DFS: Have a hashmap: with a new node and a list which is initially empty list of neighbors. {1: 1:[], 2: 2:[] and so on}
# if node is already present in the hashmap, return the node and add it to the neighbors list of that node(recursion).

"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""
class Solution:
    def __init__(self):
        self.hmap = {}
    
    def cloneGraph(self, node: 'Node') -> 'Node':
        if node == None:
            return None
        
        self.hmap = {}
        return self.dfs(node)
    
    def dfs(self, node:'Node'):
        
        if node.val in self.hmap.keys():
            return self.hmap[node.val]
        
        newNode = Node(node.val, [])
        self.hmap[node.val] = newNode
        
        newNode.neighbors = [self.dfs(n) for n in node.neighbors]
            
        return newNode
