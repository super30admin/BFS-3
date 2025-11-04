"""
TC: O(N + E) {We traverse every node once using BFS and process each edge once 
               when copying neighbors. Here, N is the number of nodes and E is the number of edges.}
SC: O(N) {We maintain a hashmap to store the mapping from original nodes to their copies, 
           and a queue for BFS traversal. Both require space proportional to the number of nodes.}

Approach:
We are tasked with creating a deep copy of an undirected graph where each node contains 
a value and a list of neighbors.

The steps are as follows:
1. Handle the empty graph case by returning None if the input node is null.
2. Initialize a queue for BFS and a hashmap `hMap` to store the mapping from original 
   nodes to their cloned copies.
3. Create a copy of the starting node and store it in the hashmap.
4. Perform BFS:
    - Pop a node from the queue.
    - For each neighbor:
        - If it has not been copied yet, create a copy, add it to the hashmap, 
          and enqueue the neighbor.
        - Append the copied neighbor to the neighbors list of the current node's copy.
5. After BFS completes, return the copy of the starting node.

This BFS approach ensures that every node is copied exactly once, and all neighbor 
relationships are preserved correctly.

This problem ran successfully on Leetcode.
"""

# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
from typing import Optional
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if not node:
            return None
        q = deque([node])
        hMap = {}
        copyNode = Node(node.val)
        hMap[node] = copyNode

        while q:
            currNode = q.popleft()
            for nei in currNode.neighbors:
                if nei not in hMap:
                    newNode = Node(nei.val)
                    q.append(nei)
                    hMap[nei] = newNode
                copyCurrNode = hMap[currNode]
                copyCurrNode.neighbors.append(hMap[nei])
        
        return copyNode
