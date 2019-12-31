'''
Accepted on leetcode(133)
time - O(N), - N -> No. of nodes in the graph.
space - O(N)
Approach:
1. create a method for dfs of graph.
2. create a new node and traverse through the given graph and all the neighbours from given to new one to clone it.
3. if the node already exists in hashmap then dont add again.
'''

# Definition for a Node.
class Node:
    def __init__(self, val, neighbors):
        self.val = val
        self.neighbors = neighbors



class Solution:
    def __init__(self):
        self.hashmap = {}

    def cloneGraph(self, node: 'Node') -> 'Node':
        if node == None:
            return None
        return self.dfs(node)

    def dfs(self, node):
        # if node already added.
        if node.val in self.hashmap:
            return self.hashmap[node.val]
        # create a newnode to clone it
        newNode = Node(node.val, [])
        # add it to hashmap to avoid duplicates.
        self.hashmap[node.val] = newNode
        # adding neighbors
        for n in node.neighbors:
            newNode.neighbors.append(self.dfs(n))

        return newNode