#Time Complexity:O(v+e)
#Space COmplexity:O(v)
"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not  node:
            return None
        q = []
        q.append(node)
        copydict ={}
        copynode = Node(node.val)
        copydict[node] = copynode
        
        while(len(q)!=0):
            curr = q.pop()
            for n in curr.neighbors:
                if n not in copydict:
                    copydict[n] = Node(n.val)
                    q.append(n)
                copydict[curr].neighbors.append(copydict[n])
        return copynode
===============================================================================
"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not  node:
            return None
        copydict ={}
        def dfs(node):
            if node in copydict:
                return
            copynode = Node(node.val)
            copydict[node] = copynode
            for n in node.neighbors:
                dfs(n)
                copydict[node].neighbors.append(copydict[n])
        
        dfs(node)
        return copydict[node]

                
        

                
        

