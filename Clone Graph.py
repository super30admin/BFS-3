"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""
# Time complexity : O(V+E)
# Space complexity : O(V)
class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        visited = {}
        if not node:
            return node
        newNode = Node(node.val)
        visited[node] = newNode
        
        q = collections.deque()
        q.append(node)

        while q:
            curr = q.popleft()

            for neighbor in curr.neighbors:
                if neighbor not in visited:
                    visited[neighbor] = Node(neighbor.val)
                    q.append(neighbor)
                visited[curr].neighbors.append(visited[neighbor])

        return visited[node] 