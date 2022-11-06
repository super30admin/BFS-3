#Time Complexity: O(V+E)
#Space Complexity: O(V)

#----------------------------DFS-----------------------------
class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if node is None: return node
        hashmap = {}
        self.helper(node, hashmap)
        return hashmap[node]
    
    def helper(self, curr, hashmap):
        #base
            
        #logic
        deepcopy1 = Node(curr.val, [])
        hashmap[curr] = deepcopy1 
        
        neighbors = curr.neighbors
        for x in neighbors:
            if x not in hashmap:
                self.helper(x, hashmap)
            deepcopy1.neighbors.append(hashmap[x])

#----------------------------BFS-----------------------------
class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if node is None: return node
        hashmap = {}
        queue = [node]
        while queue:
            size = len(queue)
            for i in range(size):
                curr = queue.pop(0)
                if curr not in hashmap:
                    deepcopy1 = Node(curr.val, [])
                    hashmap[curr] = deepcopy1 
                else: deepcopy1 = hashmap[curr]
                neighbors = curr.neighbors
                for x in neighbors:
                    
                    if x not in hashmap:
                        queue.append(x)
                        deepcopy2 = Node(x.val, [])
                        hashmap[x] = deepcopy2
                    else: deepcopy2 = hashmap[x]
                    deepcopy1.neighbors.append(deepcopy2)
        return hashmap[node]