#Time Complexity:O(V+E)
#Space Complexity:O(V)

"""
# Definition for a Node.
class Node(object):
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution(object):
    def cloneGraph(self, node):
        """
        :type node: Node
        :rtype: Node
        """
        if not node:
            return node
        graphMap={node:Node(node.val)}
        dq=collections.deque([node])
        while dq:
            for i in range(len(dq)):
                currNode=dq.popleft()
                for nei in currNode.neighbors:
                    if nei not in graphMap:
                        graphMap[nei]=Node(nei.val)
                        dq.append(nei)
                    graphMap[currNode].neighbors.append(graphMap[nei])
        return graphMap[node]

        

        
            