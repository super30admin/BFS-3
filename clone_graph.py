# // Time Complexity :O(V+E)
# // Space Complexity :O(V),vertices in queue
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach


# Definition for a Node.
"""
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def __init__(self):
        self.hmap={}
    def cloneGraph(self, node: 'Node') -> 'Node':
        if node is None:
            return node
        q=[]
        copynode=self.clone(node)
        q.append(node)
        result=[]
        
        self.hmap[node]=self.clone(node)
        while q:
            print(q)
            curr=q.pop(0)
            children=curr.neighbors
            li=[]
            
            for child in children:
                if child not in self.hmap.keys():
                    copychild=self.clone(child)
                    q.append(child)
                
                self.hmap[curr].neighbors.append(self.hmap[child])
               
        return copynode
                    
                        
                
    def clone(self,node):
        if node in self.hmap.keys():
            return self.hmap[node]
        copy=Node(node.val)
        self.hmap[node]=copy
        return copy
        