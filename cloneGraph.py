#Time complexity: O(V+E)
#Space complexity: O(V)
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
            return node
        hMap = {}
        q = deque()
        q.append(node)
        # hMap.add(node)
        newNode = Node(node.val)
        hMap[node] = newNode
        while q:
            size = len(q)
            for i in range(size):
                currNode = q.popleft()
                for nei in currNode.neighbors:
                    if nei not in hMap:
                        n = Node(nei.val)
                        hMap[nei] = n
                        q.append(nei)
                    hMap[currNode].neighbors.append(hMap[nei])
        return hMap[node]
                
                        
        
