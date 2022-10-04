"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""
# BFS Approach
# Time complexity : O(V + E)
# Space complexity : O(V)
# Leetcode : Solved and submitted

from collections import deque
class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        # maintain a hashmap for lookup of previous node to the new cloned node and
        # it also works as a set avoiding the cloning of the same node
        graph = {}
        
        # null case
        if not node:
            return None
        
        # maintain a queue of nodes
        q = deque([node])
        
        # clone the first node
        newNode = Node(node.val)
        # map the old node to the new cloned node
        graph[node] = newNode
        
        # traverse until the queue is empty
        while q:
            # get the current node as first element of the queue
            curr = q.popleft()
            
            # traverse through the neigbors of the current node
            for child in curr.neighbors:
                # check if the node is not in graph, which means that the node has not yet been cloned or visited
                if child not in graph:
                    # clone the node and put it's mapping in the hashmap
                    copy = Node(child.val)
                    graph[child] = copy
                    # append the node to the queue as we'd have to traverse their neighbors
                    q.append(child)
                # add the neighbors of old node to the cloned node using the hashmap for lookup
                graph[curr].neighbors.append(graph[child])
               
        # return the reference of the newNode
        return newNode # or return graph[node]
