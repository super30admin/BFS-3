#Time Complexity : O(V+E)
#Space Complexity : O(N)
from typing import Optional
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        oldtonew = dict()
        if(node==None):
            return None
        def clone(node):
            if node in oldtonew:
                return oldtonew[node]
            copy = Node(node.val)
            oldtonew[node] = copy
            for nei in node.neighbors:
                copy.neighbors.append(clone(nei))
            return copy
        return clone(node)