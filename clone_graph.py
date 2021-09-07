
#Time Complexity: O(N+E)

#Space Complexity: O(N) 
from collections import deque
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
        
        queue = deque()
        queue.append(node)
        hashmap = {}
        hashmap[node] = Node(node.val)
        while(queue):
            popped = queue.popleft()
            # print(popped.neighbors)
            for child in popped.neighbors:
                if child not in hashmap:
                    hashmap[child] = Node(child.val)
                    queue.append(child)
                hashmap[popped].neighbors.append(hashmap[child])
        return hashmap[node]
                    
                

