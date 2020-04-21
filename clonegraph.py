# Time Complexity : O(V+E) 
# Space Complexity : O(V)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = []):
        self.val = val
        self.neighbors = neighbors
"""

# BFS APPROACH

from collections import deque,defaultdict
class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        
        if node == None:
            return None
        
        queue = deque()
        store = defaultdict(Node)
        currentnode = node
        queue.append(currentnode)
        store[currentnode.val] = Node(currentnode.val)
        cloned = store[currentnode.val]
        
        while queue:
            currentnode = queue.popleft()
            clonenode = store[currentnode.val]
            for neighbor in currentnode.neighbors:
                if neighbor.val not in store:
                    store[neighbor.val] = Node(neighbor.val)
                    queue.append(neighbor)
                clonenode.neighbors.append(store[neighbor.val])
        
        return cloned
                    
                
                
        
        
        
        