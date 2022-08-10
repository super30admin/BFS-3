# Time Complexity : O(V+E)
# Space Complexity : O(V+E)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#

# BFS.
from collections import deque


class Node:
    def __init__(self, val=0, neighbors=None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []


class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return
        queue = deque()
        dictu = {}
        queue.append(node)
        dictu[node] = Node(node.val)
        while queue:
            pop = queue.popleft()
            for i in pop.neighbors:
                if i not in dictu:
                    dictu[i] = Node(i.val)
                    queue.append(i)
                dictu[pop].neighbors.append(dictu[i])
        return dictu[node]


check1 = Node(1)
check2 = Node(2)
check3 = Node(3)
check4 = Node(4)
check1.neighbors = [check2, check4]
check2.neighbors = [check1, check3]
check3.neighbors = [check2, check4]
check4.neighbors = [check1, check3]
print(Solution().cloneGraph(check1))


# dfs.
# class Solution:
#     def dfs(self, node):
#         # logic
#         if node not in self.dictu:
#             self.dictu[node] = Node(node.val)
#         for i in node.neighbors:
#             if i not in self.dictu:
#                 self.dfs(i)
#             self.dictu[node].neighbors.append(self.dictu[i])
#
#     def cloneGraph(self, node: 'Node') -> 'Node':
#         if not node:
#             return
#         self.dictu = {}
#         self.dfs(node)
#         return self.dictu[node]
#
#
# check1 = Node(1)
# check2 = Node(2)
# check3 = Node(3)
# check4 = Node(4)
# check1.neighbors = [check2, check4]
# check2.neighbors = [check1, check3]
# check3.neighbors = [check2, check4]
# check4.neighbors = [check1, check3]
# print(Solution().cloneGraph(check1))
