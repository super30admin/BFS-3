# // Time Complexity :O(V+E) 
# // Space Complexity :O(V)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

# // Your code here along with comments explaining your approach


"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""
# BFS
from typing import Optional
from collections import deque
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if not node: return             # empty      

        q = deque()     
        q.append(node)                              

        seen = {}                       

        def clone(node):                            
            if node not in seen:            
                seen[node] = Node(node.val)
            return seen[node]

        while q:
            curr = q.popleft()
            copycurr = clone(curr)
            for n in curr.neighbors:
                if n not in seen:                       # if you see the node for the fisrt time, make a copy and store its location in seen
                    q.append(n)                         # also add it to queue
                copycurr.neighbors.append(clone(n))     # make a copy of its neighbours    
        
        return seen[node]                               # return copy pointer stored in seen map
        

