#Time: O(V+E)
#Space: O(V+E)
#Program ran on leetcode successfully

"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        
        if node is None:
            return None
        
        nodeMap = {}
        q = []
        new_node = Node(node.val)
        q.append(node)
        nodeMap[node] = new_node
        
        while q:
            curr = q.pop(0)
            neighbors = curr.neighbors
            for n in neighbors:
                if n not in nodeMap:
                    deepcopy = Node(n.val)
                    nodeMap[n] = deepcopy
                    q.append(n)
                nodeMap[curr].neighbors.append(nodeMap[n])
        
        return new_node
                    
        