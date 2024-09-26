'''
Time Complexity: O(n)
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Explanation: Add the first node to queue and create a deep copy of it into the store, iterate through the neighbors of
the node, if we have not seen the neighbor create a deepcopy of the neighbor and save it in store and add it to queue for
further BFS traversal, also add this neighbor to the deepcopy of the current node to create exact copy.
'''

"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = []):
        self.val = val
        self.neighbors = neighbors
"""


class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if node == None:
            return None

        # Store of integer to node
        store = {}

        cloneNode = Node(node.val)
        store[node.val] = cloneNode

        queue = [node]

        while len(queue) != 0:
            current = queue[0]
            queue = queue[1:]

            cloneCurr = store.get(current.val)

            for neighbor in current.neighbors:
                cloneNeighbor = store.get(neighbor.val)
                if cloneNeighbor == None:
                    cloneNeighbor = Node(neighbor.val)
                    store[neighbor.val] = cloneNeighbor
                    queue.append(neighbor)

                cloneCurr.neighbors.append(cloneNeighbor)

        return cloneNode
