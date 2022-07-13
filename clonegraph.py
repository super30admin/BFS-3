#Time complexity: O(v+e)
#Space complexity: O(n)
class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if node == None:
            return None
        newNode = Node(node.val)
        hmap = {}
        hmap[node] = newNode
        q = deque()
        q.append(node)
        
        while q:
            curr = q.popleft()
            
            for nodes in curr.neighbors:
                if nodes not in hmap:
                    newCurr = Node(nodes.val)
                    hmap[nodes] = newCurr
                    q.append(nodes)
                hmap[curr].neighbors.append(hmap[nodes])
                    
        return newNode
            
                