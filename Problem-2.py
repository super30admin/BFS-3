#Time Complexity :o(V+E)
#Space Complexity :o(V+E)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no

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
        if(node ==None):
            return node
        
        hmap={}
        newNode=Node(node.val)
        hmap[node]=newNode
        queue=collections.deque()
        queue.append(node)
        
        while queue:
            curr=queue.popleft()
            #check if curr neighbous in hmap if not add them in hmap and queue
            neighbors=curr.neighbors
            for neighbor in neighbors:
                if(neighbor not in hmap):
                    #create copy and add
                    newNode=Node(neighbor.val)
                    hmap[neighbor]=newNode
                    queue.append(neighbor)
                hmap[curr].neighbors.append(hmap[neighbor])
        return hmap[node]
                    
        
        
        
        
        
        