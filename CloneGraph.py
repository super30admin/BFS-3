# // Time Complexity : o(V+E)
# // Space Complexity : o(V)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no


# // Your code here along with comments explaining your approach
# We start cloning from the given node using BFS.
# As we visit a node, we create its copy and remember it using a map.
# Then we connect each copied node to the copies of its neighbors.

# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []

from typing import Optional
# class Solution:
#     def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
#         if not node : return None
#         map = {}
#         def clone(node):
#             if not node : return None
#             if node in map:
#                 return map[node]
#             map[node] = Node(node.val)
#             return map[node]
#         def dfs(curr):
#             copycurr = clone(curr)
#             for ne in curr.neighbors:
#                 if ne not in map:
#                     dfs(ne)
#                 copycurr.neighbors.append(map[ne])
#         dfs(node)
#         return map[node]


from typing import Optional
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if not node : return None
        map = {}
        def clone(node):
            if not node : return None
            if node in map:
                return map[node]
            map[node] = Node(node.val)
            return map[node]
        def dfs(curr):
            copycurr = clone(curr)
            for ne in curr.neighbors:
                if ne not in map:
                    dfs(ne)
                copycurr.neighbors.append(map[ne])
        dfs(node)
        return map[node]
