# Time complexity: O(n + m)
# Space complexity: O(n)
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []

def cloneGraph(node: 'Node') -> 'Node':
    if not node:
        return None

    visited = {}

    def dfs(node):
        if node in visited:
            return visited[node]
        copy = Node(node.val)
        visited[node] = copy
        copy.neighbors = [dfs(n) for n in node.neighbors]
        return copy

    return dfs(node)


---------------------------------
# Time complexity: O(n + m)
# Space complexity: O(n)


from collections import deque

class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []

def cloneGraph(node: 'Node') -> 'Node':
    if not node:
        return None

    visited = {}
    queue = deque([node])
    visited[node] = Node(node.val)

    while queue:
        cur_node = queue.popleft()
        for neighbor in cur_node.neighbors:
            if neighbor not in visited:
                visited[neighbor] = Node(neighbor.val)
                queue.append(neighbor)
            visited[cur_node].neighbors.append(visited[neighbor])

    return visited[node]



