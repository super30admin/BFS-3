"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

    """
    
        Name : Shahreen Shahjahan Psyche
        Time : O(V+E) 
        Space: O(V)
        
        Passed All Test Cases in LC : Yes
        
        Approach : # Initilize a hash map and create a new node wrt to the original node and savee it in map. Initilize the queue and push the original node
                   # Travarse the graph in BFS manner. 
                   # Pop the node from queue and start travarsing its neeighbours. Check in the map whether the neeighbour has already beeen created or not. If not 
                     create a new one and add to the map. 
                   # Then, append this created new node with the popped once copied veersion
                   # Add the neighbour to the queue if already not has been visited
                   # Return the new root
    
    
    """
    

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        
        # edgee case
        if not node:
            return node
        records = {}
        
        from collections import deque 
        q = deque()
        q.append(node)
        new_node = Node(node.val, [])
        visited = set()
        records[node] = new_node
        
        while q:
            curr = q.popleft()
            visited.add(curr)
            curr_new = records[curr]
            neighbours = curr.neighbors
            for i in neighbours:
                if i not in records.keys():
                    records[i] = Node(i.val, [])
                    curr_new.neighbors.append(records[i])
                else:
                    curr_new.neighbors.append(records[i])
                if i not in visited:
                    visited.add(i)
                    q.append(i)
                    
        return records[node]
                
                
                
            
        
        
        
        
