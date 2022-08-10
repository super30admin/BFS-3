"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""
# Time Complexity: O(V+E)
# Space Complexity: O(V+E)
# BFS
class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if node==None: return None
        from collections import deque
        q=deque()
        hmap={}
        q.append(node)
        hmap[node]=Node(node.val)
        while len(q)!=0:
            cur=q.popleft()
            for n in cur.neighbors:
                if n not in hmap:
                    hmap[n]=Node(n.val)
                    q.append(n)
                hmap[cur].neighbors.append(hmap[n])
        return hmap[node]
# DFS
# Time Complexity: O(V+E)
# Space Complexity: O(V+E)
#     def cloneGraph(self, node: 'Node') -> 'Node':
#         if node==None: return None
#         self.hmap={}
#         self.dfs(node)
#         return self.hmap[node]
    
#     def dfs(self,node):
#         if node in self.hmap: return
#         if node not in self.hmap:
#             self.hmap[node]=Node(node.val)     
#         for n in node.neighbors:
#             # if n not in self.hmap:
#             # self.hmap[n]=Node(n.val)
#             self.dfs(n)
#             self.hmap[node].neighbors.append(self.hmap[n])


#     def cloneGraph(self, node: 'Node') -> 'Node':
#         if node==None: return None
#         self.hmap={}
#         self.dfs(node)
#         return self.hmap[node]
    
#     def dfs(self,node):
#         # if node in self.hmap: return
#         if node not in self.hmap:
#             self.hmap[node]=Node(node.val)     
#         for n in node.neighbors:
#             if n not in self.hmap:
#                 self.hmap[n]=Node(n.val)
#                 self.dfs(n)
#             self.hmap[node].neighbors.append(self.hmap[n])

        
                
                    
            
            
        
        
        