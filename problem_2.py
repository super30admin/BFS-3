# TC: O(v+e)
# SC:(v)

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

        queue = []
        hashmap = {}

        copyNode = Node(node.val)
        hashmap[node] = copyNode

        queue.append(node)

        while queue:
            curr = queue.pop(0)
            copy = hashmap[curr]
            for neighbor in curr.neighbors:
                if neighbor not in hashmap:
                    copyneighbor = Node(neighbor.val)
                    hashmap[neighbor] = copyneighbor
                    queue.append(neighbor)
                copy.neighbors.append(hashmap[neighbor])

        return copyNode

