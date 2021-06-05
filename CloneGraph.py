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
        
        h = {}
        q = deque()
        q.append(node)        
        copyNode = Node(node.val)
        h[node] = copyNode
        
        while q:            
            curr = q.popleft()            
            for n in curr.neighbors:
                if n not in h:
                    newnode = Node(n.val)
                    h[n] = newnode
                    q.append(n)
                h[curr].neighbors.append(h[n])
                
        return copyNode
                
            
