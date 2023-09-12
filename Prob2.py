"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""
#Method 1 - BFS  - TC - O(V+E)
#maintain a 1:1 mapping of the OG to it's deepcopy. This will help in iteration and use this also as a visited set.
class Solution(object):
    def __init__(self):
        self.hmap={}
    def cloneGraph(self, node):
        """
        :type node: Node
        :rtype: Node
        """
        if not node:
            return None
        q=collections.deque()
        q.append(node)
        copyNode=self.clone(node)
        while q:
            curr=q.popleft()
            for neighbor in curr.neighbors:
                if neighbor not in self.hmap: #if neighbour not seen before, add it to q.
                    q.append(neighbor)
                copyNeighbor=self.clone(neighbor) #irrespecive of if seen or not, clone it since it needs to be added to current clone's neighbour list.
                #when you clone, it wll get added to the hasmap.
                self.hmap[curr].neighbors.append(copyNeighbor)# add neighbors of deep copy node
        return self.hmap[node]
        
    def clone(self,node):
        if node not in self.hmap:
            newNode=Node(node.val)
            self.hmap[node]=newNode
        
        return self.hmap[node]
   