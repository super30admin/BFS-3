"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = []):
        self.val = val
        self.neighbors = neighbors
"""
# Keep the mapping of node value and the new node created in a hash map.
# Insert the nodes in a queue. Insert the node only when it is created so that it is traversed only once.
# For every neighbor of that node, find if the node exists in the hashmap. Add the cloned node to the neighbors of the current cloned node.
# Space complexity - O(2V) -- for hash map and queue
# Time complexity - O(V+E) 
from collections import deque
class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node: return
        
        hashMap = dict()
        queue = deque([node])
        hashMap[node.val] = Node(node.val)
        copy_root = hashMap[node.val]
        
        while queue:    # O(V)
            curr = queue.popleft()
            
            # add it's children
            for neigh in curr.neighbors:    # O(E)
                if neigh.val not in hashMap:
                    hashMap[neigh.val] = Node(neigh.val)
                    queue.append(neigh)
                hashMap[curr.val].neighbors.append(hashMap[neigh.val])
                
        return copy_root
        

# Recursive solution
# Space complexity - O(2V) -- for hash map and recursive stack (worst case recursive stack - O(n))
# Time complexity - O(V+E) 
class Solution:
    def __init__(self):
        self.hashNodes = dict()
        
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node: return 
        
        if node.val in self.hashNodes:
            return self.hashNodes[node.val]
        
        # keep a copy of the node
        clone_node = Node(node.val)
        self.hashNodes[node.val] = clone_node
        
        # assign neighbors to the cloned node.
        clone_node.neighbors = [self.cloneGraph(neigh) for neigh in node.neighbors]
            
        return clone_node
    
    
