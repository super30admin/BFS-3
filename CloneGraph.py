"""
Rasika Sasturkar
Time Complexity: O(V+E), V - vertices of graph, E - edges
Space Complexity: O(V)
"""

import collections


class Node:
    def __init__(self, val=0, neighbors=None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []


def create_graph(adj_list):
    if adj_list == []:
        return None

    nodes = [Node(i + 1) for i in range(len(adj_list))]

    for index, n in enumerate(adj_list):
        for connection in n:
            nodes[index].neighbors.append(nodes[connection - 1])

    return nodes[0]


def cloneGraph(node):
    # null case
    if node is None:
        return None

    node_map = {}

    # Using BFS
    # queue = collections.deque()
    # queue.append(node)
    # new_node = Node(node.val)
    # node_map[node] = new_node
    #
    # while queue:
    #     curr = queue.popleft()
    #     neighbors = curr.neighbors
    #     for neighbor in neighbors:
    #         if neighbor not in node_map:
    #             deep_copy = Node(neighbor.val)
    #             node_map[neighbor] = deep_copy
    #             queue.append(neighbor)
    #         node_map[curr].neighbors.append(node_map[neighbor])
    # return new_node

    # Using DFS
    def dfs(node):
        # base case
        if node in node_map:
            return

        # logic
        deep_copy = Node(node.val)
        node_map[node] = deep_copy
        for neighbor in node.neighbors:
            dfs(neighbor)
            node_map[node].neighbors.append(node_map[neighbor])

    dfs(node)
    return node_map[node]


def print_cloned_graph(node):
    ans = []
    if node is None:
        print(ans)
        return
    adj_list = collections.defaultdict(list)
    queue = collections.deque()
    queue.append(node)
    visited = set()

    while queue:
        curr = queue.popleft()
        neighbors = curr.neighbors
        if len(neighbors) == 0:
            adj_list[curr].append([])
        if curr in visited:
            continue
        visited.add(curr)
        for neighbor in neighbors:
            adj_list[curr.val].append(neighbor.val)
            if neighbor not in visited:
                queue.append(neighbor)

    for key in range(1, len(adj_list.keys()) + 1):
        ans.append(adj_list[key])

    print(ans)
    return


def main():
    """
    Main function - examples from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    adjList = [[2, 4], [1, 3], [2, 4], [1, 3]]
    node = create_graph(adjList)
    print_cloned_graph(cloneGraph(node))  # prints [[2, 4], [1, 3], [2, 4], [1, 3]]

    adjList = [[]]
    node = create_graph(adjList)
    print_cloned_graph(cloneGraph(node))  # prints [[]]

    adjList = []
    node = create_graph(adjList)
    print_cloned_graph(cloneGraph(node))  # prints []


if __name__ == "__main__":
    main()
