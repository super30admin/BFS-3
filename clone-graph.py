# Approach - DFS
# TC - O(V+E)
# SC - O(V)

from collections import deque
from typing import Optional

# Definition for a Node.
class Node:
    def __init__(self, val=0, neighbors=None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []

class Solution:
    def __init__(self):
        self.map = {} # Map to check if we ahve created the deep copy
        # If no, create one and put in respectively or else just get the deep copy
    
    def cloneGraph(self, node: Optional[Node]) -> Optional[Node]:
        if not node: # Base case
            return None
        deepCopyNode = self.clone(node) # Create deep copy in hashmap and get it
        self.dfs(node)
        return self.map[node]

    def dfs(self, node):
        for n in node.neighbors:
            if n not in self.map:
                self.clone(n)
                self.dfs(n)
            self.map[node].neighbors.append(self.map[n])

    def clone(self, node) -> Node:
        if node in self.map:
            return self.map[node] #If deep copy is present, return it
        newNode = Node(node.val) #Else create deep copy of node out of its value
        self.map[node] = newNode # Put this deepcopied node as a value to key of the same node
        return newNode #return deepcopy
