"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""
#BFS/Queue
class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        
        stack = [node]
        if not node:
            return node
        allNodes = {}
        
        
        allNodes[no.pyde] = Node(node.val, [])
        
        while stack:
            currNode = stack.pop()
            if currNode not in allNodes:
                allNodes[currNode] = Node(currNode.val, [])
            clonedNode = allNodes[currNode]
            
            for n in currNode.neighbors:
                if n and n not in allNodes:
                    allNodes[n] =  Node(n.val, [])
                    stack.append(n)
                clonedNeigh = allNodes[n]
                clonedNode.neighbors.append(clonedNeigh)
        
        return allNodes[node]

    Time: O(N)
    Space: O(N)
                
      """
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""
    
    #DFS/Recursive

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        visited = {}
        if not node:
            return 
        def helper(node):
            if node in visited:
                return visited[node]
            newNode = Node(node.val, [])
            visited[node] = newNode
            for n in node.neighbors:
                newNode.neighbors.append(helper(n))
            return newNode
        return helper(node)
                
                
        
                
