"""
Problem : 2

Time Complexity : O(V+E)
Space Complexity : O(V+E)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Clone graph


# Approach - 1
# BFS

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
        self.hmap[node]=copyNode
        while q:
            curr=q.popleft()
            for neighbor in curr.neighbors:
                if neighbor not in self.hmap:
                    q.append(neighbor)
                copyNeighbor=self.clone(neighbor)
                # add neighbors of deep copy node
                self.hmap[curr].neighbors.append(copyNeighbor)
        return self.hmap[node]
        
    def clone(self,node):
        if node not in self.hmap:
            newNode=Node(node.val)
            self.hmap[node]=newNode
        
        return self.hmap[node]
    
# Approach - 2
# DFS

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
        self.dfs(node)
        return self.hmap[node]

    def dfs(self,node):

        # base
        if node in self.hmap:
            return
        # logic
        nodeCopy=self.clone(node)
        for neighbor in node.neighbors:
            self.dfs(neighbor)
            nodeCopy.neighbors.append(self.hmap[neighbor])

    def clone(self,node):
        if node not in self.hmap:
            newNode=Node(node.val)
            self.hmap[node]=newNode
        
        return self.hmap[node]