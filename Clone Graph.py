# time complexity is o(V+E), where V, E are number of vertices and edges in the input
# space complexity is o(V+E), where V, E are number of vertices and edges in the input
"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        #         bfs
        if(node == None):
            return None
        from collections import deque
        q = deque()
        nodeMap = dict()
        if(node not in nodeMap):
            newNode = Node(node.val)
            nodeMap[node] = newNode
        q.append(node)
        while(len(q) > 0):
            curr = q.popleft()
            for n in curr.neighbors:
                if(n not in nodeMap):
                    newNode = Node(n.val)
                    nodeMap[n] = newNode
                    q.append(n)
                nodeMap[curr].neighbors.append(nodeMap[n])
        return nodeMap[node]
        
            
        
        
#         dfs
#         if(node == None):
#             return None
#         self.newMap = dict()
#         if(node not in self.newMap):
#             newNode = Node(node.val)
#             self.newMap[node] = newNode
#         self.dfs(node)
#         return self.newMap[node]
#     def dfs(self, node):
        
#         for n in node.neighbors:
#             if(n not in self.newMap):
#                 newNode = Node(n.val)
#                 self.newMap[n] = newNode
#                 self.dfs(n)
#             self.newMap[node].neighbors.append(self.newMap[n])
        
        
        
        
        
        
#         dfs
#         if(node == None):
#             return None
#         self.newMap = dict()
#         self.dfs(node)
#         return self.newMap[node]
#     def dfs(self, node):
#         #base
#         if(node in self.newMap):
#             return
            
#         #logic
#         if(node not in self.newMap):
#             newNode = Node(node.val)
#             self.newMap[node] = newNode
#         for n in node.neighbors:
#             self.dfs(n)
#             self.newMap[node].neighbors.append(self.newMap[n])
            
                
        
        
        
