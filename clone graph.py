"""
Time Complexity : O(V+E)
Space Complexity : O(V)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Explaination
METHOD 1: DFS
we use dfs to go to each node of the graph
we create the new nodes while going to new nodes
once we reach at last node we add the neighbors to the list while coming back in recursion

METHOD 2:
using queue we store the nodes of original graph
we add child into the Q. we maintain the hashmap to check if visited
if not visited then only we create new node
else use from Hashmap
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if node == None: return 
        hs = {}
        q = deque()
        copy = Node(node.val)
        q.append(node)
        hs[node] = copy
        
        while q:
            cur = q.popleft()
            for n in cur.neighbors:
                if n not in hs:
                    hs[n] = Node(n.val)
                    q.append(n)
                hs[cur].neighbors.append(hs[n])
        return copy
   
# DFS SOLUTION
#         def dfs(node):
#             #base
#             if node in hs:return
            
#             #logic
#             copy = Node(node.val)
#             hs[node] = copy
#             for n in node.neighbors:
#                 dfs(n)
#                 hs[node].neighbors.append(hs[n])
            
#         dfs(node)
#         return hs[node]
        
        
        
        
        
