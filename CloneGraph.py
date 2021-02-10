"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

"""
Approach: BFS

What we will be doing is start traversing from the node we are given. We will do a normal BFS where we traverse the neighbours of our current node and then traverse their neighbours. But we need to make copy of the graph here. So we will a couple of changes in the apporach.

We will maintain a hashmap to store the original node as key and the copy of the same node as value so that we can access the copy later when needed.

So when we add neighbouring nodes into the queue, we will first make copies of those nodes add them to hashmap. Then again get the copy of the node from hashmap using the current node traversing as key and add to its list of neighbors the copies of neighbors (of our current node) we have created previously

TC: O(n)
SC: O(n)

n =  no of nodes present in the graph
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if node == None:
            return node
        
        q = []
        hmap = {}
        
        copy = Node(node.val)
        q.append(node)
        hmap[node] = copy
        
        while q:
            curr = q.pop(0)            
            for n in curr.neighbors:
                if n not in hmap:
                    copyNode = Node(n.val)
                    hmap[n] = copyNode
                    q.append(n)
                
                # Here what we are doing is getting the copy of our current node and adding to its list of neighbors the copies of neighbors (of our current node) we have created in the previous steps
                hmap[curr].neighbors.append(hmap[n])
                
            
        return copy
    
    

"""
Approach: DFS

TC: O(n)
SC: O(n)

n =  no of nodes present in the graph
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if node == None:
            return node
        
        self.hmap = {}
        self.dfs(node)
        return self.hmap[node]
    
    def dfs(self, node):
        if node in self.hmap:
            return
        
        copyNode = Node(node.val)
        self.hmap[node] = copyNode
        
        for n in node.neighbors:
            self.dfs(n)
            self.hmap[node].neighbors.append(self.hmap[n])