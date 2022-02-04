"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if node == None:
            return None
        hashmap = {}
        q = deque()
        q.append(node)
        copyNode = Node(node.val)
        hashmap[node] = copyNode
        while q:
            curr = q.popleft()
            for ne in curr.neighbors:
                if ne not in hashmap:
                    copyNe = Node(ne.val)
                    hashmap[ne] = copyNe
                    q.append(ne)
                hashmap.get(curr).neighbors.append(hashmap.get(ne)) 
        return copyNode

# Time Complexity: O(V+E)
# Space Complexity: O(V)


"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if node == None:
            return None
        self.hashmap = {}
        self.dfs(node)
        return self.hashmap[node]
    
    def dfs(self, node):
        if node in self.hashmap:
            return
        copyNode = Node(node.val)
        self.hashmap[node] = copyNode
        for ne in node.neighbors:
            self.dfs(ne)
            self.hashmap[node].neighbors.append(self.hashmap.get(ne))


# Time Complexity: O(V+E)
# Space Complexity: O(V)