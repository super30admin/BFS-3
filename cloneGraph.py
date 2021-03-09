"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        '''
        Time Complexity: O(V+E)
        Space Complexity: O(V)
        '''
        if(node==None):
            return
        x = {}
        q = deque([node])
        if(not node in x.keys()):
            x[node] = Node(node.val)
        while(len(q)>0):
            z = q.popleft()
            for i in z.neighbors:
                if(not i in x.keys()):
                    x[i] = Node(i.val)
                    x[z].neighbors.append(x[i])
                    q.append(i)
                else:
                    x[z].neighbors.append(x[i])
        return x[node]
