#Time Complexity : O(N+M)
#Space Complexity : O(N)
#Did this code successfully run on Leetcode : YES
#Any problem you faced while coding this : NO
"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return None
        dic = {}
        newnode = Node(node.val)
        queue = [node]
        dic[node] = newnode
        while queue:
            temp = queue.pop(0)
            neigh = []
            for i in temp.neighbors:
                neigh.append(i)
            for j in neigh:
                if j not in dic:
                    copy = Node(j.val)
                    dic[j] = copy
                    queue.append(j)
                    
                dic[temp].neighbors.append(dic[j])
        return newnode