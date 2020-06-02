"""
// Time Complexity : O(V + E)
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
Algorithm Explanation
Given below
"""
"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""
from collections import deque
class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        """
        We essentially need to traverse the graph and replicate the relation
        in the new graph
        We go for bFS here - use a queue
        Update - Have a map dumbo to store the original node and its deep copy
        
        1) Put the startnode in the queue
        2) Put the deepcopy of startnode in the deepcopy map 
        2) Poll the node
            - check for neighbours, 
                - for each neighbour, establish the same linking in the new graph
            - Only process those nodes which are not present in the map
            - But need to update the neighbour of all deepcopy nodes
            
        3) Do 2 while queue is not empty
        4) return deepcopy of original node from the map
        """
        if not node:
            return node
        
        #BFS approach
        deepcopy_node = Node(node.val)
        #storing the original source node and it's deep copy in the map
        deepcopy_map = {node:deepcopy_node}
        q = deque([node]) #queue for storing the original nodes 
        while q:
            curr = q.popleft()
            
            for nodec in curr.neighbors:
                if not nodec in deepcopy_map:
                    #update the child deep copy in the map
                    deepcopy_map[nodec] = Node(nodec.val)
                    q.append(nodec)
                #update the deepcopy of current node to link to deepcopy of
                #neighbors of current
                deepcopy_map[curr].neighbors.append(deepcopy_map[nodec])
        return deepcopy_map[node]
        
        #DFS approach
        deepcopy_map = {}
        def dfs(node):
            #base
            print(node.val)
            if node in deepcopy_map:
                return
            
            #logic
            deepcopy_map[node] = Node(node.val)
            
            for nodec in node.neighbors:
                print("nodec",nodec.val)
                dfs(nodec)
                deepcopy_map[node].neighbors.append(deepcopy_map[nodec])
        dfs(node)
        return deepcopy_map[node]