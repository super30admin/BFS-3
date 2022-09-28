from collections import defaultdict
#time Complexity: O(N)
#space Complexity: O(N)
class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return
        new_node = Node(node.val)
        stack,visited = [node],defaultdict()
        visited[node]=new_node
        while stack:
            n = stack.pop()
            for neighbor in n.neighbors:
                if neighbor not in visited:
                    copy = Node(neighbor.val)
                    visited[neighbor]= copy
                    visited[n].neighbors.append(copy)
                    stack.append(neighbor)
                else:
                    visited[n].neighbors.append(visited[neighbor])
        return new_node