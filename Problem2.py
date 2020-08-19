"""
// Time Complexity : o(n)
// Space Complexity : o(n), queue
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
"""
from collections import deque, defaultdict
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
            return None
        
        q = deque()
        
        d = defaultdict(Node) #val with refernce to the copy node
        
        node_copy = Node(node.val) #create copy of current node
        d[node.val] = node_copy
        
        q.append(node)
        
        while q:
            cur = q.popleft()
            
            for n in cur.neighbors: #iterate over the neighbors
                if n.val not in d: #if node hasnt been created alredy, create a new node for the neighbor
                    d[n.val] = Node(n.val)
                    q.append(n)
                    
                d[cur.val].neighbors.append(d[n.val]) #add the neighbors to the neighbors list of current node copy
                
          
        return node_copy
        
        