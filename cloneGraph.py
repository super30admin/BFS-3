"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    
    """
    Description: Create a clone of a graph
    
    Time Complexity: O(V+E)
    Space Complexity: O(V)
    
    Approach:
    - create a dictionary with node and its copy first
    - initiate a queue to make connections
      + starting with first node (or any other node), pop the queue
      + find neighbors of the current item in the queue (coming from original graph)
      + append queue if node is not part of current queue and add connections reading from original graph under the loop
    """
    
    from collections import deque
    
    def cloneGraph(self, node: 'Node') -> 'Node':
        
        if node == None: return None
        node_dict = {}
        queue = deque()
        node_copy = Node(node.val)
        queue.append(node)
        node_dict[node] = node_copy
        
        while queue:
            curr_node = queue.popleft()
            for neighbor in curr_node.neighbors:
                if not neighbor in node_dict:
                    neighbor_copy = Node(neighbor.val)
                    node_dict[neighbor] = neighbor_copy
                    queue.append(neighbor)
                node_dict[curr_node].neighbors.append(node_dict[neighbor])
                
        return node_copy
