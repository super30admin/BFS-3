"""133. Clone Graph
Time Complexity: O(V+E)
Space Complexity: O(V)"""

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
        
        hmap = {}#1 to 1 relation between node and deep copy node
        queue = deque()
        
        queue.append(node)
        
        # create a copy node 
        copyNode = Node(node.val)
        #create 1:1 mapping
        hmap[node] = copyNode
        
        while queue:
            curr = queue.popleft()
            for n in curr.neighbors:
                if n not in hmap:
                    deepcopy = Node(n.val)
                    hmap[n] = deepcopy
                    queue.append(n)
                hmap[curr].neighbors.append(hmap[n])
        return copyNode
            
        