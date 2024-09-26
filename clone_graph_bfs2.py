# // Time Complexity :O(v+e)
# // Space Complexity :O(v), vertices in queue
"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def __init__(self):
        self.hmap={}
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return node
        q=[]
        op=[]
        q.append(node)
        self.hmap[node]=Node(node.val)
        
        while q:
            curr=q.pop(0)
            for i in curr.neighbors:
                if i not in self.hmap.keys():
                    q.append(i)
                    self.hmap[i]=Node(i.val)
                self.hmap[curr].neighbors.append(self.hmap[i])
                
        return self.hmap[node]