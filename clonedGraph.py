# Time Complexity : O(V+E)
# Space Complexity : O(E)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO

"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return None
        cloneNode = Node(node.val)
        #oldNode:clonedNode
        map = {}
        map[node] = cloneNode
        queue = [node]
        
        while queue:
            cur = queue.pop()
            for neigh in cur.neighbors:
                if neigh not in map:
                    clone_neigh = Node(neigh.val)
                    map[neigh] = clone_neigh
                    queue.append(neigh)
                map[cur].neighbors.append(map[neigh])
        
        return map[node]
                    
