#TC: O(V + E)
#Space: O(N)

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        
        # 0: Check
        if not node:
            return None 

        # 1: find nodes
        nodes = self.find_nodes_by_bfs(node)
        # 2: copy nodes
        mapping = self.copy_nodes(nodes)
        # 3: copy edges
        self.copy_edges(nodes, mapping)

        return mapping[node]

    def find_nodes_by_bfs(self, node):
        queue = collections.deque([node])
        visited = set([node])
        while queue:
            cur_node = queue.popleft()
            for neighbor in cur_node.neighbors:
                if neighbor in visited:
                    continue
                visited.add(neighbor)
                queue.append(neighbor)
        return list(visited)

    def copy_nodes(self, nodes):
        mapping = {}
        for node in nodes:
            mapping[node] = Node(node.val)
        return mapping

    def copy_edges(self, nodes, mapping):
        for node in nodes:
            new_node = mapping[node]
            for neighbor in node.neighbors:
                new_neighbor = mapping[neighbor]
                new_node.neighbors.append(new_neighbor)