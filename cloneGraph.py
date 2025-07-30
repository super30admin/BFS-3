# TimeComplexity:O(v+e)
# SpaceComplexity:O(v)
# Approach:
# go through each node ,start from given node and then make a copy of each one just vals not neighbours.but to get this copy in future in O(1) we use hashmap /dict.we vist each edge
# we add each vertex in set after processing its children



"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

from typing import Optional
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        hmap=dict()
        if node==None:return None
        dnode=Node(node.val)
        hmap[node]=dnode
        visted=set()
        
        #bfs
        q=deque([node])
        while(len(q)):
            currNode=q.popleft()
            
            if currNode in visted:
                continue
            visted.add(currNode)
            if currNode not in hmap:
                hmap[currNode]=Node(currNode.val)

            for n in currNode.neighbors:
                
                
                if n in hmap:
                    hmap[currNode].neighbors.append(hmap[n])
                else:
                    hmap[n]=Node(n.val)
                    hmap[currNode].neighbors.append(hmap[n])
                if n not in visted:
                    q.append(n)
        return dnode
                    
            

                





        
