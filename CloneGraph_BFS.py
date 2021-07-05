# TC: O(V + E) where V is the no. of vertices and E is the number of edges.
# SC: O(N) where N is the size of the hashmap. Size of the queue will also be considered, but asymptotic space complexity comes to O(N). 

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node: 
            return
        
        queue = collections.deque()
        self.hmap = {}
        queue.append(node)
        while queue: 
            curr = queue.popleft()
            self.createClone(curr)
            if len(curr.neighbors) > 0: 
                for i in curr.neighbors: 
                    if i not in self.hmap.keys():
                        queue.append(i)
        
        return self.hmap.get(node)
        
        
    def createClone(self, node):
        if not node: 
            return
        if node in self.hmap.keys(): 
            return self.hmap.get(node)
        cloned_node = Node(node.val)
        self.hmap[node] = cloned_node
        if len(node.neighbors) > 0:
            for i in node.neighbors: 
                if i in self.hmap.keys(): 
                    cloned = self.hmap.get(i)
                else: 
                    cloned = self.createClone(i)
                cloned_node.neighbors.append(cloned)
        return cloned_node
