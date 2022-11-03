"""

## Problem 133: Clone Graph

## Author: Neha Doiphode
## Date:   11-03-2022

## Description
    Given a reference of a node in a connected undirected graph. Return a deep copy (clone) of the graph.

    Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
    class Node {
        public int val;
        public List<Node> neighbors;
    }

    Test case format:
        For simplicity, each node's value is the same as the node's index (1-indexed).
        For example, the first node with val == 1, the second node with val == 2, and so on.
        The graph is represented in the test case using an adjacency list.

        An adjacency list is a collection of unordered lists used to represent a finite graph.
        Each list describes the set of neighbors of a node in the graph.

        The given node will always be the first node with val = 1.
        You must return the copy of the given node as a reference to the cloned graph.


## Examples:
    Example 1:
        Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
        Output: [[2,4],[1,3],[2,4],[1,3]]
        Explanation:
                     Adjacency list:  Val : Neighboring nodes
                                        1 :[2, 4]
                                        2 :[1, 3]
                                        3 :[2, 4]
                                        4 :[1, 3]
                     There are 4 nodes in the graph.
                     1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
                     2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
                     3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
                     4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).

    Example 2:
        Input: adjList = [[]]
        Output: [[]]
        Explanation: Note that the input contains one empty list.
                     The graph consists of only one node with val = 1 and it does not have any neighbors.

    Example 3:
        Input: adjList = []
        Output: []
        Explanation: This an empty graph, it does not have any nodes.

## Constraints:
    The number of nodes in the graph is in the range [0, 100].
    1 <= Node.val <= 100
    Node.val is unique for each node.
    There are no repeated edges and no self-loops in the graph.
    The Graph is connected and all nodes can be visited starting from the given node.

## Time complexity: Please refer to respective doc-strings of the approaches used below to solve the problem.

## Space complexity: Please refer to respective doc-strings of the approaches used below to solve the problem.

"""

from typing import List, Optional
from collections import deque

# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []

class Solution:
    visited = dict()
    output = []

    def cloneGraph_bfs(self, node: 'Node') -> 'Node':
        """
        Time Complexity : O(N + M), where N is a number of nodes (vertices) and M is a number of edges.
        Space Complexity: O(N), This space is occupied by the visited dictionary and in addition to that,
                                space would also be occupied by the queue since we are adopting the BFS approach here.
                                The space occupied by the queue would be equal to O(W) where W is the width of the graph.
                                Overall, the space complexity would be O(N).
        """
        if node == None:
            return None

        q = deque()
        self.visited = dict()
        cloned_node = Node(node.val, [])
        self.visited[node] = cloned_node
        q.append(node)

        while len(q) != 0:
            og_node = q.popleft()
            for neighbor in og_node.neighbors:
                if neighbor not in self.visited:
                    new_neighbor = Node(neighbor.val, [])
                    self.visited[neighbor] = new_neighbor
                    q.append(neighbor)
                    self.visited[og_node].neighbors.append(new_neighbor)
                else:
                    self.visited[og_node].neighbors.append(self.visited[neighbor])

        return cloned_node

    def dfs(self, node: 'Node') -> 'Node':
        # base
        if node in self.visited:
            return self.visited[node]

        # logic
        clone_node = Node(node.val, [])
        self.visited[node] = clone_node
        if node.neighbors:
            clone_node.neighbors = [self.dfs(neighbor) for neighbor in node.neighbors]
        return clone_node

    def cloneGraph_dfs(self, node: 'Node') -> 'Node':
        """
        Time Complexity:  O(N + M), where N is a number of nodes (vertices) and M is a number of edges.
        Space Complexity: O(N), This space is occupied by the visited hash map and in addition to that,
                            space would also be occupied by the recursion stack since we are adopting a recursive approach here.
                            The space occupied by the recursion stack would be equal to O(H) where H is the height of the graph.
                            Overall, the space complexity would be O(N).
        """
        if node == None:
            return None

        self.visited = dict()
        self.head = None
        return self.dfs(node)


# Driver code
"""
Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
Output: [[2,4],[1,3],[2,4],[1,3]]
"""
node1 = Node(1, [])
node2 = Node(2, [])
node3 = Node(3, [])
node4 = Node(4, [])
node1.neighbors.append(node2)
node1.neighbors.append(node4)

node2.neighbors.append(node1)
node2.neighbors.append(node3)

node3.neighbors.append(node2)
node3.neighbors.append(node4)

node4.neighbors.append(node1)
node4.neighbors.append(node3)

print(f"Input list: {[[2,4],[1,3],[2,4],[1,3]]}")
solution = Solution()
print("Output: Approach 1: Breadth first search: Cloned graph: ")
cloned = solution.cloneGraph_bfs(node1)
print("Output: Approach 2: Depth first search  : Cloned graph: ")
cloned = solution.cloneGraph_dfs(node1)
print("Please run the program on leetcode to verify the correctness!")
