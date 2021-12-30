# 133. Clone Graph
# https://leetcode.com/problems/clone-graph/

# Logic: We make a hashmap with original node as key and a copy node as value. 
# We will use the hashmap as a visited set also. Start from node given and 
# create its children if copy is not created. Only visit nodes who's copy 
# has not been cretaed. When the copy is created only then we add it to 
# queue as it has not been visted so far.

# Time Complexity: O(V+E)
# Space Complexity: O(V)

"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""
from collections import deque
class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if node is None:
            return None
        
        hashmap = dict()
        hashmap[node] = Node(node.val)
        
        q = deque()
        q.append(node)
        
        while q:
            curNode = q.popleft()
            neigh = curNode.neighbors
            
            for i in neigh:
                if i not in hashmap:
                    hashmap[i] = Node(i.val)
                    q.append(i)
                hashmap[curNode].neighbors.append(hashmap[i])
        
        return hashmap[node]