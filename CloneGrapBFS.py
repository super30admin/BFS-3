'''
time complexity:  O(V+E)
space compleixty: O(V+E)
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
        if node == None: return None
        cpdict = {}
        q = deque([])
        
        NewNode = Node(node.val)
        cpdict[node] = NewNode
        q.append(node)
        
        while(len(q)!=0):
            
            curr = q.popleft()
            
            for ngb in curr.neighbors:
                if ngb not in cpdict:
                    cloneNode = Node(ngb.val)
                    cpdict[ngb] = cloneNode
                    q.append(ngb)
                
                cpdict[curr].neighbors.append(cpdict[ngb])
        return NewNode