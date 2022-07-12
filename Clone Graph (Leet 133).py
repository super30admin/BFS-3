'''
Using BFS
Time: O(n)
Space: O(n)
'''

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
        
        q = collections.deque()
        nnode = Node(node.val)
        hm = dict()
        hm[node] = nnode
        q.append(node)
        
        while len(q) != 0:
            
            curr = q.popleft()
            
            for neigh in curr.neighbors:
                if neigh not in hm:
                    hm[neigh] = Node(neigh.val)
                    q.append(neigh)
                hm[curr].neighbors.append(hm[neigh])
        
        return nnode


'''
Using DFS
Time: O(n)
Space: O(n) and recursive stack
'''

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
        
        self.hm = dict()
        
        
        self.dfs(node)
        
        return self.hm[node]
    
    def dfs(self, node):
        # base
        if node in self.hm:
            return
        
        # logic
        nnode = Node(node.val)
        self.hm[node] = nnode
        for neigh in node.neighbors:
            self.dfs(neigh)
            self.hm[node].neighbors.append(self.hm[neigh])




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
        
        self.hm = dict()
        
        
        self.dfs(node)
        
        return self.hm[node]
    
    def dfs(self, node):
        # base
        # if node in self.hm:
        #     return
        
        # logic
        nnode = Node(node.val)
        self.hm[node] = nnode
        for neigh in node.neighbors:
            if neigh not in self.hm:
                self.dfs(neigh)
            self.hm[node].neighbors.append(self.hm[neigh])
        
    
    
        