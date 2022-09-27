# Time Complexity : O(V+E) where is V is number of vertics in the graph and E is number of edges in the graph
# Space Complexity : O(V)  where is V is number of vertics 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

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
        if node == None:
            return
        hashmap = {}
        
        q = deque()
        headClone = Node(node.val)
        
        hashmap[node] = headClone
        q.appendleft(node)
        
        
        
        while len(q) > 0:
            curr = q.pop()
            cloneCurr = hashmap[curr] 
            for neighbor in curr.neighbors:
                if neighbor not in hashmap:
                    nClone = Node(neighbor.val)
                    hashmap[neighbor] = nClone
                    q.appendleft(neighbor)
                cloneCurr.neighbors.append(hashmap[neighbor])
                
        return headClone
                