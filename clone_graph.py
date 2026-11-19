'''
133 Clone Graph
https://leetcode.com/problems/clone-graph/description/

Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

class Node {
    public int val;
    public List<Node> neighbors;
}

Test case format:
For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node with val == 1, the second node with val == 2, and so on. The graph is represented in the test case using an adjacency list.

An adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.

The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.

Solution:
1. BFS
We start cloning from the given node using BFS.
As we visit a node, we create its copy and remember it using a map.
Then we connect each copied node to the copies of its neighbors.
Time: O(V+E), Space: O(V)
https://youtu.be/5ibsv1HTDyU?t=3721 (RK)
https://youtu.be/pmo-ZUg6MMY?t=3069 (JS)


2. DFS
We start cloning from the given node using DFS.
For each node, we copy it and save it in a map.
Then we recursively clone and attach all its neighbors.
Time: O(V+E), Space: O(V)
https://youtu.be/5ibsv1HTDyU?t=5024 (RK)

'''
from typing import Optional
from collections import defaultdict, deque

# Definition of a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []


def build_graph(adj_list) -> Optional[Node]:
    """Converts a 1-indexed adjacency list into a connected Node graph."""
    if not adj_list:
        return None

    # Pass 1: Create all Node instances (1 to n)
    nodes = {i + 1: Node(i + 1) for i in range(len(adj_list))}

    # Pass 2: Wire up the neighbors using the 1-indexed values
    for i, neighbors in enumerate(adj_list):
        curr_node = nodes[i + 1]
        curr_node.neighbors = [nodes[neighbor_val] for neighbor_val in neighbors]

    return nodes[1]

def clone(node, h):
    if node in h:
        return h[node]
    h[node]= Node(val=node.val)
    return h[node]

def cloneGraphBFS(node: Optional['Node']) -> Optional['Node']:
    if not node:
        return None
    map = defaultdict(Node)
    q = deque()
    q.append(node)
    copynode = clone(node, map)
    while q: # O(V)
        curr = q.popleft()
        #copycurr = clone(curr, map)
        for nbr in curr.neighbors: # O(E)
            if nbr not in map:
                q.append(nbr)
            copynbr = clone(nbr, map)
            map[curr].neighbors.append(copynbr)
    return copynode

def cloneGraphDFS(node: Optional['Node']) -> Optional['Node']:
    def dfs(node):
        if not node:
            return None
        curr = node
        copycurr = clone(curr, map)
        for nbr in curr.neighbors: # O(E)
            if nbr not in map:
                dfs(nbr)
            copynbr = clone(nbr, map)
            copycurr.neighbors.append(copynbr)
        return None

    if not node:
        return None
    map = defaultdict(Node)
    copynode = clone(node, map)
    dfs(node)
    return copynode

def graph_to_adj_list(node: Optional[Node]):
    """Serializes a Node graph back into a 1-indexed adjacency list for assertions."""
    if not node:
        return []

    visited = {node.val: node}
    queue = deque([node])

    while queue:
        curr = queue.popleft()
        for neighbor in curr.neighbors:
            if neighbor.val not in visited:
                visited[neighbor.val] = neighbor
                queue.append(neighbor)

    # Reconstruct list ordered by node values 1..N
    return [
        [neighbor.val for neighbor in visited[i].neighbors]
        for i in range(1, len(visited) + 1)
    ]


# adjList = [[2,4],[1,3],[2,4],[1,3]]
# nodes = [Node(1), Node(2), Node(3), Node(4)]
# for curr, edge in zip(nodes, adjList):
#     curr.neighbors = nodes[edge[0]-1], nodes[edge[1]-1]

# copynode = cloneGraphDFS(nodes[0])
# curr = copynode
# visited = defaultdict(bool)
# flag = True
# while flag:
#     visited[curr] = True
#     for nbr in curr.neighbors:
#         print(f"{curr.val} -> {nbr.val}")

#     if not visited[curr.neighbors[0]]:
#         curr = curr.neighbors[0]
#     elif not visited[curr.neighbors[1]]:
#         curr = curr.neighbors[1]
#     else:
#         flag = False

# 4-Node Cycle: 1-2, 2-3, 3-4, 4-1
adj = [[2, 4], [1, 3], [2, 4], [1, 3]]
root = build_graph(adj)
print("Root Node Value:", root.val)
print("Root Neighbors:", [n.val for n in root.neighbors])
print("Serialized Root:", graph_to_adj_list(root))

copy_root = cloneGraphBFS(root)
print("Copy Root Node Value:", copy_root.val)
print("Copy Root Neighbors:", [n.val for n in copy_root.neighbors])
print("Serialized Copy:", graph_to_adj_list(copy_root))