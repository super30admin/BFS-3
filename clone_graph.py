class Solution:
    
    # Time complexity - O(V+E)
    # Space complexity - O(v)
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:

        if not node:
            return node

        hmap = dict()
        q = deque([node])
        new_node = Node(node.val)
        hmap[node] = new_node
        while q:
            n = q.popleft()
            cur = hmap[n]
            for each in n.neighbors:
                if each not in hmap:
                    ne = Node(each.val)
                    hmap[each] = ne
                    q.append(each)
                else:
                    ne = hmap[each]
                cur.neighbors.append(ne)
        return new_node
