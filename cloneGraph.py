#Time Complexity : O(v+e) where v is number of vertices and e is number of edges
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : Yes

"""
# Definition for a Node.
class Node(object):
    def __init__(self, val, neighbors):
        self.val = val
        self.neighbors = neighbors
"""
from collections import deque
class Solution(object):

    def cloneGraph(self, node):
        """
        :type node: Node
        :rtype: Node
        """

        if not node:
            return node
        #create a mapping of original node and cloned node
        mapping = {}
        mapping[node] = Node(node.val, [])

        queue = deque([node])


        while queue:
            curr = queue.popleft()
            #iterate through neighbors of curr node
            for neighbor in curr.neighbors:
                #check if neighbor node has been cloned
                if neighbor not in mapping:
                    mapping[neighbor] = Node(neighbor.val, [])
                    queue.append(neighbor)
                #add the cloned neighbor to the cloned curr node
                mapping[curr].neighbors.append(mapping[neighbor])

        return mapping[node]
