'''
Time Complexity - O( V + E)
Space Complexity - O(V + E)
Approach : BFS Approach
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
        
        if not node:
            return node
        hashmap = {}
        queue = collections.deque()
        cloned = Node(node.val)
        hashmap[node] = cloned
        queue.append(node)
        while queue:
            
            current = queue.popleft()
            for neighbor in current.neighbors:
                if neighbor not in hashmap:
                    copy = Node(neighbor.val)
                    hashmap[neighbor] = copy
                    queue.append(neighbor)
                hashmap[current].neighbors.append(hashmap[neighbor])
                
        return cloned
            