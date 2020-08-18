# Time Complexity : O(V+E) 
# Space Complexity :O(V) for map for n number of nodes.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
    
    def __repr__(self):
        return "%d" % (self.val)

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if node is None or not node:
            return node 
        map_ = {node.val : Node(node.val)}
        q = [node]

        while len(q) != 0 : 
            curr = q.pop(0)       
            for child in curr.neighbors:
                if child.val not in map_:
                    q.append(child)
                    map_[child.val] = Node(child.val)
                map_[curr.val].neighbors.append(map_[child.val])
        return map_[node.val]
    

# DFS Solution
# Time = O(V+E)
# Space = O(n)
class Solution:
    m = None
    def cloneGraph(self, node: 'Node') -> 'Node':
        if node is None or not node:
            return node
        self.m = {node.val : Node(node.val)}
        self.dfs(node)
        return self.m[node.val]
    
    def dfs(self, node):
        # base 
        if not node or node is None :
            return 
        #logic 
        for child in node.neighbors:
            if child.val not in self.m:
                self.m[child.val] = Node(child.val)
                self.dfs(child)
            self.m[node.val].neighbors.append(self.m[child.val])

        
        