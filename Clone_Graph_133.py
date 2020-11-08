"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""
Algo-

#Used map to store the deep copy and original node
#Don't forget to update the linking in the graph for the respective neighbours
#Return deepcopy of original node from the map

# Time - O(V+ E)
# Space - O(n)
from collections import deque
class Solution:
#     BFS
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return None
        mp = {}
        q = deque([node])
        
        deep_copy_node = Node(node.val)
        mp[node] = deep_copy_node
        
        while q:
            temp = q.popleft()            
            for i in temp.neighbors:
                if i not in mp:
                    mp[i] = Node(i.val)
                    q.append(i)
                mp[temp].neighbors.append(mp[i])
        return mp[node]
        # return mp[node]
    
    
    
#     def DFS(self, node: 'Node') -> 'Node':
#         if not node:
#             return None
#         mp = {}
        
#         def dfs(node):
#             if node in mp:
#                 return
            
#             copy_n = Node(node.val)
#             mp[node] = copy_n
            
#             for i in node.neighbors:
#                 dfs(i)                
#                 mp[node].neighbors.append(mp[i])
#         dfs(node)
#         return mp[node]
            
            
            
        
        
       
            
            
        
        
        
        
        