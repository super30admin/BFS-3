"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""
from collections import deque


class Solution:
    hashMap = {}

    def cloneGraph(self, node: 'Node') -> 'Node':
        if node is None:
            return node
        self.hashMap = dict()
        q = deque()
        copyNode = self.clone(node)
        q.append(node)

        while len(q) > 0:
            curr = q.popleft()
            children = curr.neighbors

            for child in children:
                # check if the node is not present in the hashmap
                # if not present put the child in the queue and create a copy of the node
                # copy will be created by calling the clone function will add the
                # original node and copy of it as key value pair
                if child not in self.hashMap:
                    q.append(child)
                    # create a clone of the current node
                    self.clone(child)
                # create the edges of curr node copy
                # get the copied edges from hashMap
                # Add those edges in the copied node's list
                self.hashMap.get(curr).neighbors.append(self.hashMap.get(child))
        return copyNode

    def clone(self, node):
        copy = Node(node.val)
        self.hashMap[node] = copy
        return copy

# BFS
# Time Complexity: O(V + E)
# Space Complexity: O(V + E)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

