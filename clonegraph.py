# Time complexity - O(n)
#  Space complexity - O(n)
"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def __init__(self):
        self.map={}
    def cloneGraph(self, node: 'Node') -> 'Node':
        if(node == None):
            return
        q=deque()
        copynode=self.clone(node)
        q.append(node)
        while(q):
            c=q.popleft()
            for i in c.neighbors:
                if i not in self.map:
                    q.append(i)        
                copyne=self.clone(i)
                self.map[c].neighbors.append(copyne)
        return self.map[node]

    def clone(self, node):
        if( node not in self.map):
            newnode=Node(node.val)
            self.map[node]=newnode
        return self.map[node]
