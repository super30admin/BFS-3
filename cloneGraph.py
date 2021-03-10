# Time Complexity : O(V +E)
# Space Complexity : O(V)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        hm = {}
        if not node:
            return None
        queue = deque([])
        copy = Node(node.val)
        queue.append(node)
        hm[node] = copy
        
        while queue:
            curr = queue.popleft()
            
            for n in curr.neighbors:
                if n not in hm:
                    copyNeighbor = Node(n.val)
                    hm[n] = copyNeighbor
                    queue.append(n)
                hm[curr].neighbors.append(hm[n])
        return copy #can also return hm[node]