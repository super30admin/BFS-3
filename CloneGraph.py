'''
Solution:
1.  Perform either using BFS or DFS, the procedure is more or less the same with very less
    differences.
2.  Clone a particular node and for all its neighbors, clone them if not visited and attach
    the cloned neighbors to the current clone node.

Time Complexity:    O(V + E)    |   Space Complexity:   O(V)
--- Passed all testcases successfully on leetcode for both the solutions.
'''


from collections import deque


# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = []):
        self.val = val
        self.neighbors = neighbors

class CloneNodeDFS:
    
    
    def __cloneNode(self, node: 'Node', storeMap: dict) -> 'Node':

        #   function to clone a node and store it in HashMap
        
        if (node in storeMap):
            return storeMap[node]
        
        clonedNode = Node(node.val)
        storeMap[node] = clonedNode
        
        return clonedNode
    
    def __dfs(self, currentNode: 'Node', storeMap: dict) -> None:
        
        #   clone the current node
        clonedNode = self.__cloneNode(currentNode, storeMap)
         
        #   for all neighbors, call DFS if the node is not visited
        #   check for visited in HashMap
        #   attach the cloned neighbor node to the current node.   
        for neighbor in currentNode.neighbors:
            if (neighbor not in storeMap):
                self.__dfs(neighbor, storeMap)

            clonedNeighbor = self.__cloneNode(neighbor, storeMap)
            clonedNode.neighbors.append(clonedNeighbor)     
        
    
    def cloneGraph(self, node: 'Node') -> 'Node':
        
        #   edge case check
        if (node == None):
            return node
        
        #   initializations
        storeMap = {}
        queue = deque([])
        
        #   clone the head node and call DFS on original node
        headNode = self.__cloneNode(node, storeMap)
        self.__dfs(node, storeMap)

        #   return cloned head node
        return headNode


class CloneNodeBFS:
    
    
    def __cloneNode(self, node: 'Node', storeMap: dict) -> 'Node':
        
        #   function to clone a node and store it in HashMap
        if (node in storeMap):
            return storeMap[node]
        
        clonedNode = Node(node.val)
        storeMap[node] = clonedNode
        
        return clonedNode
    
    def cloneGraph(self, node: 'Node') -> 'Node':
        
        #   edge case check
        if (node == None):
            return node
        
        #   initializations
        storeMap = {}
        queue = deque([])
        
        #   clone the head node and push the original node to Queue
        headNode = self.__cloneNode(node, storeMap)
        queue.append(node)
        
        #   for all neighbors, call BFS if the node is not visited
        #   check for visited in HashMap
        #   attach the cloned neighbor node to the current node.
        while (len(queue) > 0):
            currentNode = queue.popleft()
            clonedNode = self.__cloneNode(currentNode, storeMap)
            
            for neighbor in currentNode.neighbors:
                if (neighbor not in storeMap):
                    queue.append(neighbor)
                
                clonedNeighbor = self.__cloneNode(neighbor, storeMap)
                clonedNode.neighbors.append(clonedNeighbor)                    
        
        #   return the cloned head node.
        return headNode