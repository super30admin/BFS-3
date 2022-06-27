"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if(node==None):
            return None
        hm= dict()
        dummy = Node(node.val)
        hm[node]= dummy
        queue = [node]
        hs = set()
        hs.add(node)
        while(len(queue)!=0):
            curr = queue.pop(0)
            if(curr not in hm):
                hm[curr] = Node(curr.val)
            if(curr.neighbors!=None):
                
                for i in curr.neighbors:
                    if(i not in hm):
                        hm[i]=Node(i.val)
                    hm[curr].neighbors.append(hm[i])
                    if(i not in hs):
                        queue.append(i)
                        hs.add(i)
                
        return dummy