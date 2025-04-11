# Time Complexity : O(V+E)
# Space Complexity : O(V+E)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO

"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""
import collections
from typing import Optional
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if not node:
            return None
        node_map = {}
        queue = collections.deque()
        queue.append(node)
        while queue:
            cur = queue.popleft()
            if cur not in node_map:
                cur_copy = Node(cur.val,[])
                node_map[cur] = cur_copy
            else:
                cur_copy = node_map[cur]
            for neib in cur.neighbors:
                if neib not in node_map:
                    neib_copy = Node(neib.val,[])
                    node_map[neib] = neib_copy
                    queue.append(neib)
                cur_copy.neighbors.append(node_map[neib])
        
        return node_map[node]