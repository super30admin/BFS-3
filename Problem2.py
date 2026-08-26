# Problem2 Clone graph (https://leetcode.com/problems/clone-graph/)
#Time Complexity: O(V + E),V is the number of nodes and E is the number of edges in the graph.
#Every node gets popped from the queue and cloned exactly once, since the map stops us from processing the same node twice. That accounts for O(V).
#For every node we also loop through its full neighbor list once and across the whole graph that adds up to looking at every edge, which is O(E).
#Space Complexity: O(V),The map stores one entry per node, so that is O(V). The queue can also hold up to O(V) nodes in the worst case, for example if the graph is wide and many nodes get added before being processed.

#Approach:
#We do a breadth first search starting from the given node. We keep a dictionary called map that stores original node mapped to its clone, so we never create two different copies for the same node and we never get stuck in an infinite loop when the graph has cycles.
#We use a queue to visit nodes level by level. For each node we take out of the queue, we get its clone using the clone helper function.
#Then we go through all of its original neighbors. If a neighbor has never been seen before, we add it to the queue so its own neighbors get processed later. 
#Either way, we get that neighbor's clone using the same clone helper and we attach it to the current node's clone. This is the step that rebuilds the connections in the copy to match the original graph. 
#Once the queue is empty, every node has been cloned and every connection has been wired up, so we just look up the clone of the very first node in the map and return it.

'''
# definition given for a Node, has a value and a list of neighbor nodes
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
'''

from typing import Optional
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        # if the graph is empty there is nothing to clone, so return None right away
        if node is None:
            return None
        
        # dictionary that will store original node mapped to its clone
        self.map = {}
        # queue holds nodes whose neighbors still need to be processed, start with the given node
        queue = [node]

        # keep going as long as there is something left in the queue to process
        while queue:
            # take the node at the front of the queue out, this is the standard BFS move
            current = queue.pop(0)
            # get the clone of current, this creates it if it does not already exist
            current_copy = self.clone(current)

            # go through every neighbor that current has in the original graph
            for neighbor in current.neighbors:
                # if this neighbor has never been cloned before, we have not visited it yet
                if neighbor not in self.map:
                    # add it to the queue so its own neighbors get processed later
                    queue.append(neighbor)
                # get or create the clone of this neighbor, then attach it to current_copy's neighbor list
                # this is the step that rebuilds the connections to match the original graph
                current_copy.neighbors.append(self.clone(neighbor))

        # every node has been cloned and wired up, return the clone of the original starting node
        return self.map[node]
    
    def clone(self, node):
        # edge case, if asked to clone None, just return None
        if node is None:
            return None
        
        # if this node has already been cloned before, reuse that same clone
        # this is what prevents duplicate copies and infinite loops on cycles
        if node in self.map:
            return self.map[node]
        
        # first time seeing this node, create a new Node with the same value
        # store it in the map right away so future lookups find it
        self.map[node] = Node(node.val)
        return self.map[node]