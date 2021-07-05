# TC:O(V + E) where V is the number of vertices in the original graph and E is the number of edges. 
# SC: O(N + H) where N is the size of hashmap to store all nodes mapped to its clones and H is the height of the recursive stack. 

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node: 
            return
        
        self.hmap = {}
        self.dfs(node)
        return self.hmap.get(node)
    
    def dfs(self, node): 
#         base
        if node in self.hmap: 
            return 
#         recurse
        cloned_node = Node(node.val)
        self.hmap[node] = cloned_node
        if len(node.neighbors) > 0:
            for i in node.neighbors: 
                self.dfs(i)
                cloned_node.neighbors.append(self.hmap.get(i))
    
        
        
        
