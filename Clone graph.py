#BFS
""""// Time Complexity : O(V+E)
// Space Complexity :O(V)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
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
        q = deque()
        d = {}
        q.append(node)
        copyNode = Node(node.val)
        d[node] = copyNode

        while q:
            curr = q.popleft()
            for i in curr.neighbors:
                if i not in d:
                    copyN = Node(i.val)
                    d[i] = copyN
                    q.append(i)

                d[curr].neighbors.append(d[i])
        return copyNode


#DFS
""""// Time Complexity : O(V+E)
// Space Complexity :O(V)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""

"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""


# class Solution:
#     def cloneGraph(self, node: 'Node') -> 'Node':
#         self.d = {}
#         if node == None:
#             return None
#         copyNode = Node(node.val)
#         self.d[node] = copyNode
#         self.dfs(node)
#         return copyNode
#
#     def dfs(self, node):
#         # base
#
#         # logic
#         for i in node.neighbors:
#             if i not in self.d:
#                 copyN = Node(i.val)
#                 self.d[i] = copyN
#                 self.dfs(i)
#
#             self.d[node].neighbors.append(self.d[i])


"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""


# class Solution:
#     def cloneGraph(self, node: 'Node') -> 'Node':
#         self.d = {}
#         if node == None:
#             return None
#         self.dfs(node)
#         return self.d[node]
#
#     def dfs(self, node):
#         # base
#         if node in self.d:
#             return
#
#
#         # logic
#         else:
#             copyNode = Node(node.val)
#             self.d[node] = copyNode
#
#         for i in node.neighbors:
#             self.dfs(i)
#
#             self.d[node].neighbors.append(self.d[i])