#Time -> O(v+e)
#Space -> O(v)


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
        
        cloned={}
        cloned[node]=Node(node.val,[])
        
        q=[node]
        
        while q:
            cur=q.pop(-1)
            for nei in cur.neighbors:
                if nei not in cloned:
                    cloned[nei]=Node(nei.val,[])
                    q.append(nei)
                
                cloned[cur].neighbors.append(cloned[nei])
                
            
        
        return cloned[node]
        