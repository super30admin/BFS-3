// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
In this problem we use BFS approach.we start with a node and clone it first and then we start to traverse its neighbors and clone them we do this process till the queue is empty.

# Time complexity --> O(V+E) V --> no of nodes and E --> no of edges
# space complexity --> o(V)
"""
# Definition for a Node.
class Node(object):
    def __init__(self, val = 0, neighbors = []):
        self.val = val
        self.neighbors = neighbors
"""
from collections import deque
class Solution(object):
    def __init__(self):
        self.d=dict()
    def cloneGraph(self, node):
        """
        :type node: Node
        :rtype: Node
        """
        if node==None:
            return node
        #this cursor is created for the cloned graph.
        resultcursor1=Node(node.val)
        queue=deque()
        queue.append(node)
        #using a dictionary to store node value and its cloned graph.
        self.d[node.val]=resultcursor1
        while len(queue)!=0:
            orgnode=queue.popleft()
            resultcursor=self.d[orgnode.val]
            for i in range(len(orgnode.neighbors)):
                if orgnode.neighbors[i].val not in self.d:
                    clonenode=Node(orgnode.neighbors[i].val)
                    self.d[orgnode.neighbors[i].val]=clonenode
                    queue.append(orgnode.neighbors[i])
                    resultcursor.neighbors.append(clonenode)
                else:
                    resultcursor.neighbors.append(self.d[orgnode.neighbors[i].val])
        return resultcursor1