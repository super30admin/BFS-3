# Clone graph

# // Time Complexity : O(N)
# // Space Complexity :O(N)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if (node)==None: return node
        
        hashmap ={}
        queue = [node]
        
        def clone(node):
            newnode = Node(node.val)
            hashmap[node]=newnode
            return newnode
        
        newnode = clone(node)           #clone the first node and put it to hashmap with its cloned node
        
        while queue:
            n = queue.pop(0)            #for all the nodes added to queue, go to their neighbors, clone them, and add the cloned neighbors to the neighbors of the first node
            for i in n.neighbors:
                if (i not in hashmap):
                    cl = clone(i)
                    queue.append(i)
                    
                hashmap[n].neighbors.append(hashmap[i])
        return newnode
        
                
        