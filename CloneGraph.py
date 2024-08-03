# Time Complexity :
# O(V+E)

# Space Complexity :  
# O(V)  


class Solution(object):
    def __init__(self):
        self.hashMap = {}

    def cloneGraph(self, node):
        """
        :type node: Node
        :rtype: Node
        """
        if not node:
            return None
        
        # queue to process Nodes in BFS manner
        queue = []
        queue.append(node)
        copyNode = self.clone(node)

        while queue:
            curr = queue.pop(0)
            neighbors = curr.neighbors
            for neighbor in neighbors:
                if neighbor not in self.hashMap.keys():
                    queue.append(neighbor)
                clonedNeighbor = self.clone(neighbor)
                #add clonedNeighbor to neightbors of curr's deepCopy
                self.hashMap[curr].neighbors.append(clonedNeighbor)
        return copyNode


    def clone(self, node):
        # if "node" present as a key in hashMap, return its value => "copy of Node"
        if node in self.hashMap.keys():
            return self.hashMap[node]
        
        # else create a copy of Node
        deepCopy = Node(node.val)
        self.hashMap[node] = deepCopy
        return deepCopy