"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
    
        ## Approach 2 : BFS
        ## T.C = O(v + e)
        ## S.C = O(v)

        if not node:
            return node

        q = [node]
        hm = {}

        while q:
            x = q.pop(0)
            if x:
                if x not in hm.keys():
                    hm[x] = Node(x.val)
                for n in x.neighbors:
                    if n not in hm.keys():
                        hm[n] = Node(n.val)
                        q.append(n)
                    hm[x].neighbors.append(hm[n])
                    
        return hm[node]

        ## Approach 1 : DFS
        ## T.C = O(v + e)
        ## T.C = O(v)

        if not node:
            return node
        hm = {}

        def dfs(node):
            if node in hm.keys():
                return
            else:
                new_node = Node(node.val)
                hm[node] = new_node
                for neighbor in node.neighbors:
                    dfs(neighbor)
                    hm[node].neighbors.append(hm[neighbor])

        dfs(node)
        return hm[node]
		