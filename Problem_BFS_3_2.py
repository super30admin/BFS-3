class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return None
        di = {}
        di[node.val] = Node(node.val)
        queue = []
        queue.append(node)
        while queue:
            cur_node = queue.pop(0)
            for neighbor in cur_node.neighbors:
                if neighbor.val not in di:
                    di[neighbor.val] = Node(neighbor.val)
                    queue.append(neighbor)
                di[cur_node.val].neighbors.append(di[neighbor.val])
        return di[node.val]


%TC: O(n)
%SC: O(n)