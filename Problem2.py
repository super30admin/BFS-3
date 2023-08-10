from collections import deque
#Time complexity is O(V+E) where v is no of vertices and E is no of edges
#Space complexity is O(V)
#No issues faced while coding
#Code ran successfully on leetcode
"""
# Definition for a Node.
class Node(object):
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution(object):
    def cloneGraph(self, node):
        """
        :type node: Node
        :rtype: Node
        """
        #Base condition
        if(node==None):
            return None
        #Initializing requried variables
        self.hmap={}
        q=deque()
        #Append node into the queue
        q.append(node)
        #Creating a copy node for that
        copyNode=self.clone(node)
        #Iterating through the queue
        while(q):
            #Popping the values from the queue
            curr=q.popleft()
            #Going thorugh the neighbours of the current node
            for ne in curr.neighbors:
                #Adding the neighbour in hashmap if not present
                if(ne not in self.hmap):
                    q.append(ne)
                #Creating a clone for that
                copyNe=self.clone(ne)
                #adding neighbours of deep copy nodes to the current ine
                self.hmap[curr].neighbors.append(copyNe)
        #Finally we are returning the address of the starting copy node
        return self.hmap[node]
    
    #Function to create clone of the node
    def clone(self,node):
        #If node is not present in hashmap
        if(not node in self.hmap):
            #We will create a node and we will add that to the hash map
            newNode=Node(node.val)
            self.hmap[node]=newNode
        #Finally we are returning the clonedaddress
        return self.hmap[node]