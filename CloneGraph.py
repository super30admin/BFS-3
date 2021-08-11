"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""
from collections import deque
class Solution:
    """DFS and BFS Implementation
    Time complexity-O(V+E)
    Space complexity-O(V)"""
    def __init__(self):
        self.hashmap=dict()
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return None
        
        self.dfs(node)
        return self.hashmap[node]
    
    def dfs(self, node):
        if node in self.hashmap:
            return
        nodecopy=Node(node.val)
        self.hashmap[node]=nodecopy

        for j in node.neighbors:
            self.dfs(j)
            self.hashmap[node].neighbors.append(self.hashmap[j])
            
        # q=deque()
        # q.append(node)
        # while q:
        #     size=len(q)
        #     for i in range(size):
        #         curr=q.popleft()
        #         for j in curr.neighbors:
        #             if j not in hashmap:
        #                 copy=Node(j.val)
        #                 hashmap[j]=copy
        #                 q.append(j)
        #             hashmap[curr].neighbors.append(hashmap[j])
        # return nodecopy
                
                    
        
        
        