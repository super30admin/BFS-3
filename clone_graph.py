# Time Complexity : O(V + E)
# Space Complexity : O(V)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :Yes

# Your code here along with comments explaining your approach

"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

from typing import Deque
from django.template import Node


class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return None

        head = Node(node.val)
        q = Deque([(node, head)])  # put the first node in the queue
        nodeToClone = {node: head}

        # start BFS traversal
        while q:
            real, clone = q.popleft()

            for realNeigh in real.neighbors:
                if realNeigh in nodeToClone:
                    # get reference of a existing cloned node from dictionary and append to list of neighbors
                    clone.neighbors.append(nodeToClone[realNeigh])
                else:
                    # create a clone of the real neighbor and add it to list of neighbors and the dictionary
                    clonedNeigh = Node(realNeigh.val)
                    clone.neighbors.append(clonedNeigh)
                    nodeToClone[realNeigh] = clonedNeigh

                    q.append((realNeigh, clonedNeigh))

        return head
