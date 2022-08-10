#133. Clone Graph
"""
Time Complexity : O(V+E)
Space Complexity : O(V)
"""

"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if node == None:
            return None
        #copy given node
        copyNode = Node(node.val) 
        #copyNode = 1' and node = 1
        
        d = dict()
        q = deque()
        d.update({node : copyNode})
        q.append(node)
        
        while len(q) != 0:
            curr = q.popleft()
            
            for n in curr.neighbors:
                if n not in d:
                    copyNode = Node(n.val)
                    d.update({n : copyNode})
                    q.append(n)
                    
                #print(curr.val, n.val)
                d.get(curr).neighbors.append(d.get(n))
                #print(temp)
                #temp.neighbors.append(d.get(n))
                #tempList.append(d.get(n))
        
        return d.get(node)
        
