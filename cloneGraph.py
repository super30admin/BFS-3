"""
Use DFS (or BFS) and a hashmap to track already cloned nodes
For each node, clone it and recursively (or iteratively) clone its neighbors
Avoid revisiting nodes using the visited map (old_node - cloned_node)
"""
"""
Time Complexity : O(N + E)	N = nodes, E = edges
Space Complexity : O(N)	For visited/cloned map
"""

from collections import deque

class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []

class cloneGraph:
    def cloneGraphs(self, node: 'Node') -> 'Node':
        if not node:
            return None

        visited = {node: Node(node.val)}
        queue = deque([node])

        while queue:
            curr = queue.popleft()
            for neighbor in curr.neighbors:
                if neighbor not in visited:
                    visited[neighbor] = Node(neighbor.val)
                    queue.append(neighbor)
                visited[curr].neighbors.append(visited[neighbor])

        return visited[node]

def build_graph():
    # Create a graph: 1 -- 2
    #                 |    |
    #                 4 -- 3
    n1 = Node(1)
    n2 = Node(2)
    n3 = Node(3)
    n4 = Node(4)
    n1.neighbors = [n2, n4]
    n2.neighbors = [n1, n3]
    n3.neighbors = [n2, n4]
    n4.neighbors = [n1, n3]
    return n1

if __name__ == "__main__":
    obj = cloneGraph()
    cloned = obj.cloneGraphs(build_graph())
    print(cloned.val) 
    print([n.val for n in cloned.neighbors])  
