# Time Complexity : O(V+E)
# Space Complexity : O(V)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using BFS Approach.
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
        if not node:
            return None
        dict = {}
        queue = deque([])
        copyNode = Node(node.val)
        queue.append(node)
        dict[node] = copyNode
        while queue:
            currNode = queue.popleft()
            #iterate over its neighbors
            for n in currNode.neighbors:
                #check if neighbor is in HashMap
                if n not in dict:
                    copyNeighbor = Node(n.val)
                    dict[n] = copyNeighbor
                    queue.append(n)
            #in the deep copy of my current node I have to add the deep copy of neighbor
            #for creating edges
                dict[currNode].neighbors.append(dict[n])

        return copyNode
