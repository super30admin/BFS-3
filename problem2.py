# Time - O(V+E)
# Space - O(V) for the hashmap. Don't consider the space for the clone as we're returning it.
from collections import deque

class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []

class Solution:
    
    def cloneGraph(self, node: 'Node') -> 'Node':
        h={}
        q=deque()
        if not node:
            return
        new=Node(node.val)
        q.append(node)
        h[node]=new
        while q:
            curr=q.popleft()
            for i in curr.neighbors:
                if i not in h:
                    newneigh=Node(i.val)
                    h[i]=newneigh
                    q.append(i)
                h[curr].neighbors.append(h[i])
        return new
