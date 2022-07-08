'''
Time Complexity: O(V+E)
Space Complexity: 0(V) -- add nodes to the queue
Run on leetCode: Yes
'''

"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""
from collections import deque
class Solution:
    
    def __init__(self):
        self.__dict = {}
        self.__visitedSet = set()
        self.__copyRoot = None
    
    def cloneGraph(self, node: 'Node') -> 'Node':
        
        # base-case
        if not node:
            return node
        
        # 1. initialize the queue
        queue = deque([])
        
        # 2. add initial node to the queue
        queue.append(node)
        
        # 3. iterate the queue
        lvl = 0
        while len(queue) != 0:
            
            # initialize size 
            size = len(queue)
            
            # iterate till count breeches size
            for count in range(0,size):
                # pop the node from the queue and mark it as visited
                currentNode = queue.popleft()
                # create a cpy of the currentNode and place the pairing inside the dict
                if currentNode not in self.__dict:
                    objNewNode = Node(currentNode.val,[])
                    self.__dict[currentNode] = objNewNode
                    # base-chk initialize the rootNode
                    if self.__copyRoot == None:
                        self.__copyRoot = objNewNode    
                # mark the node as visited
                self.__visitedSet.add(currentNode)
                # get the cpyNode
                cpyNode = self.__dict[currentNode]
                # get the neighbors and iterate the neighbors
                for neighbor in currentNode.neighbors:
                    # add neighbot to the queue if not visited
                    if neighbor not in self.__visitedSet:
                        queue.append(neighbor)
                        self.__visitedSet.add(neighbor)
                    # chk if neighbor has a cpyNode
                    if neighbor not in self.__dict:
                        # create an obj of class node
                        objNewNode = Node(neighbor.val,[])
                        self.__dict[neighbor] = objNewNode
                    # mark the neighbors of cpyNode
                    cpyNode.neighbors.append(self.__dict[neighbor])
                '''end of iteration of neighbors'''
            '''end of for loop '''
            
            # update lvl
            lvl += 1
        '''end of while loop'''
        
        # update the lvl
        lvl -= 1
        return self.__dict[node]