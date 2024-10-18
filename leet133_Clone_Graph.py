# Solution

# // Time Complexity : O(V+E)
# // Space Complexity : O(V)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : None


# // Your code here along with comments explaining your approach
# Approach is to use BFS to traverse from one node to another while creating new nodes and then keeping the newly created
# nodes in dict against their val, since val is unique and first node is always 1.

class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []

def dfs(node,nodeDict):
        newNode = Node(node.val)
        nodeDict[newNode.val] = newNode

        adjList = []

        for nodeL in node.neighbors:
            if nodeL.val in nodeDict:
                adjList.append(nodeDict[nodeL.val])
            else:
                dfs(nodeL,nodeDict)
                adjList.append(nodeDict[nodeL.val])
        
        newNode.neighbors = adjList

def cloneGraph(node):
    if node == None:
        return node
    elif node.neighbors == None or len(node.neighbors) == 0:
        newNode = Node(node.val,[])
        return newNode

    nodeDict = {}

    dfs(node,nodeDict)

    return nodeDict[1]