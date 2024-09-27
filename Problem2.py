"""
# Definition for a Node.
class Node:
    def __init__(self, val, neighbors):
        self.val = val
        self.neighbors = neighbors
"""
from collections import deque
class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        # Time Complexity : O(n) where n is the number of nodes in the graph
        # Space Complexity : O(n) where n is the number of nodes in the graph, we store the every old to new node mapping in the dictionary which occupies more space
        # Accepted on leetcode
        oldToNew = dict()
        temp = Node(node.val, [])
        oldToNew[node] = temp
        queue = deque()
        queue.append(node)
        while len(queue) > 0:
            temp_node = queue.popleft()
            for i in temp_node.neighbors:
                if i not in oldToNew:
                    tNode = Node(i.val, [])
                    oldToNew[i] = tNode
                    queue.append(i)
                oldToNew[temp_node].neighbors.append(oldToNew[i])
        return oldToNew[node]