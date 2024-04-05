"""
Time Complexity : O(v+e) where v is the total number of vertex/node of the graph and e are the edges of the graph
Space Complexity : O(v) where v is the total number of vertex/node of the graph. This is because hashMap will contain entries of all the nodes/vertexes of the graph

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""

"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""




from typing import Optional
from collections import deque
from collections import defaultdict
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if node == None:
            return None
        hashMap = defaultdict(Node)
        queue = deque()

        queue.append(node)
        newNode = Node(node.val)
        hashMap[node] = newNode

        while queue:
            node = queue.popleft()
            adjList = node.neighbors
            currNode = hashMap[node]
            for node in adjList:
                if node not in hashMap:
                    hashMap[node] = Node(node.val)
                    queue.append(node)
                neighbour = hashMap[node]
                currNode.neighbors.append(neighbour)

        return newNode
