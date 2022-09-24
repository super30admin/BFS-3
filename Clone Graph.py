# Time Complexity : O(V+E)
# Space Complexity : O(V+E)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':

        if not node : return
        old_new = {}
        q = deque()
        q.append(node)
        old_new[node] = Node(node.val)
        
        while q:
            cur = q.popleft()
            for neighbor in cur.neighbors:
                if neighbor not in old_new:
                    old_new[neighbor] = Node(neighbor.val)
                    q.append(neighbor)
                old_new[cur].neighbors.append(old_new[neighbor])
        return old_new[node]