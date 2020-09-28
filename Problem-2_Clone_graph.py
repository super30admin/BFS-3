# APPROACH 1: BFS 
# Time Complexity : O(V + E) - we will visit all the vertices (either as standalone or as neighbors of some other vertices), and we process all edges of the graph.
# Space Complexity : O(V + E) (as we are dep copying the input graph)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Traverse the graph in BFS and also store the newly created nodes in a hashmap, so that we don't create dupliacte nodes. 
# 2. Initially add the input node in queue (Insert only original nodes in queue, else we will lose the information of it's neighbors while processing the node). and store in 
#    hashmap as well (original node and new node)
# 3. As we deque each node, process it's neighbors.
#       - if the neighbor node was never replicated, create a new node and store the association in hashmap as well. 
#       - process only those nodes (enqueue them) only if they were never visited. (get to know from the hashmap -> acts like a visited array)
#       - irrespective of visited or not, add all these nodes to the neighbor list of the new node


"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if node is None:
            return None
        
        hashmap, queue = {}, deque()
        result = Node(node.val)
        hashmap[node] = result
        queue.append(node)
        
        while queue:
            curr_node = queue.popleft()
            
            for nei_node in curr_node.neighbors:
                if nei_node not in hashmap:
                    new_node = Node(nei_node.val)
                    hashmap[nei_node] = new_node
                    queue.append(nei_node)
                hashmap[curr_node].neighbors.append(hashmap[nei_node])
                
        return result
        
