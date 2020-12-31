"""
Time Complexity : O(v+e)
Space Complexity : O(v)
Did this code successfully run on Leetcode : I don't have leetcode Premium. I saw the code online and just
wrote down my algo
Any problem you faced while coding this : no

We would perform bottom up DP here, ie, taking the smallest problem ie an empty string and the building on it. So, we would make
Both BFS(commented) and DFS could be done here. The idea behind the solution is to maintain a hashmap which can store node as 
the key and its deepcopy as its value. It will also serve as a visted set. So in BFS, we add the neighbors to the queue,
check if they are in the map or not, then append them to the nodes copy. Similarly, in DFS.
"""

"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""
# from collections import deque
# class Solution:
#     def checkMap(self,node,Map):
#         if node not in Map:
#             Map[node]=Node(node.val)
#         return Map[node]

#     def cloneGraph(self, node: 'Node') -> 'Node':
#         if (node == None):
#             return node
#         Map={}
#         q=deque()
#         cloneHead=self.checkMap(node,Map)
#         q.append(node)
#         while q:
#             curr=q.popleft()
#             for n in curr.neighbors:
#                 if n not in Map:
#                     q.append(n)
#                 clonedNbr=self.checkMap(n,Map)
#                 Map[curr].neighbors.append(clonedNbr)
#         return cloneHead


class Solution:
    def checkMap(self, node, Map):
        if node not in Map:
            Map[node] = Node(node.val)
        return Map[node]

    def cloneGraph(self, node: 'Node') -> 'Node':
        if (node == None):
            return node
        Map = {}
        cloneHead = self.checkMap(node, Map)
        self.dfs(node, Map)
        return cloneHead

    def dfs(self, node, Map):

        cloned = self.checkMap(node, Map)
        for n in node.neighbors:
            if n not in Map:
                self.dfs(n, Map)
            clonedNbr = self.checkMap(n, Map)
            cloned.neighbors.append(clonedNbr)
