"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if node==None or node==[]  : return
        if node==[[]]: return [[]]
       
        q=[]
        _hash={}
       
        copy=Node(node.val)
        _hash[node.val]=copy
       
        q.append(node)
        while q!=[]:
            newNode=q.pop(0)
            for n in newNode.neighbors:
                if not (n.val in _hash):
                    deepcopy=Node(n.val)
                    _hash[n.val]=deepcopy
                    q.append(n)
                _hash[newNode.val].neighbors.append(_hash[n.val])
        return  _hash[node.val]