"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""
#TC:O(m+n)
#SC:O(m+n)
from collections import defaultdict
from collections import deque
class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return node
        dict_address = defaultdict()
        new_node = Node(node.val, [])
        dict_address[node]=new_node
        queue = deque()
        queue.append(node)
        while(queue):
            node_curr = queue.popleft()
            for node_neighbor in node_curr.neighbors:
                if node_neighbor in dict_address:
                    dict_address[node_curr].neighbors.append(dict_address[node_neighbor])
                else:
                    new_node_neighbor = Node(node_neighbor.val, [])
                    dict_address[node_neighbor]=new_node_neighbor
                    dict_address[node_curr].neighbors.append(new_node_neighbor)
                    queue.append(node_neighbor)
        return dict_address[node]