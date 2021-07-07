from collections import deque


# Definition for a Node.
class Node:
    def __init__(self, val=0, neighbors=None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []


class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return None

        h = {}
        q = deque()
        q.append(node)
        copyNode = Node(node.val)
        h[node] = copyNode

        while q:
            curr = q.popleft()
            for n in curr.neighbors:
                if n not in h:
                    newnode = Node(n.val)
                    h[n] = newnode
                    q.append(n)
                h[curr].neighbors.append(h[n])

        return copyNode


"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""


class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if node is None: return None

        self.clonedmap = {}
        queue = deque()
        clonednode = Node(node.val)
        self.clonedmap[node] = clonednode
        queue.append(node)

        while queue.__len__() > 0:
            size = queue.__len__()

            for id in range(size):
                samplenode = queue.popleft()

                for neighborNode in samplenode.neighbors:
                    if neighborNode not in self.clonedmap.keys():
                        deepcopyNode = Node(neighborNode.val)
                        self.clonedmap[neighborNode] = deepcopyNode
                        queue.append(neighborNode)

                    self.clonedmap[samplenode].neighbors.append(self.clonedmap[neighborNode])

        return clonednode


adjList = [[2, 4], [1, 3], [2, 4], [1, 3]]
print(Solution().cloneGraph(node=adjList))