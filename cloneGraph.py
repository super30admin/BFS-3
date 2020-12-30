# As taught in class, using map and copying nodes then creating a graph 
# Time and space Complexity: O(e+v)
class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if node is None:
            return None
        q = list()
        map = dict()
        copy = Node(node.val)
        q.append(node)
        map[node] = copy
        while(len(q)!=0):
            curr = q.pop(0)
            for n in curr.neighbors:
                if n not in map:
                    copyNode = Node(n.val)
                    map[n] = copyNode
                    q.append(n)
                map[curr].neighbors.append(map[n])
        return map[node]