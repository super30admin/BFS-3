
# Time Complexity : O(V+E)
# Space Complexity : O(V+E)

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
        d = {}
        q = deque([node])
        d[node.val] = Node(node.val)
        while q:
            cur = q.popleft()
            for neighbor in cur.neighbors:
                if neighbor.val not in d:
                    q.append(neighbor)
                    d[neighbor.val] = Node(neighbor.val)
                d[cur.val].neighbors.append(d[neighbor.val])
        return d[1]
