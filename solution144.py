#Time Complexity:O(V+E)
#Space Complexity:O(V)

"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""
class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return None
        dict={}                                         #a hashmap is declared to map every node to its copy
        copyNode=Node(node.val)                         #copy of the first node is created and added to the hashmap
        dict[node]=copyNode
        q=deque()                                       #a queue is created and the first original node is added to the queue
        q.append(node)
        while q:                                        #while is q has elements in it, obtain the first element
            curr=q.pop()
            for n in curr.neighbors:                    #access the neigbors of the node
                if n not in dict:                       #if its copy does not exist, create a copy and map it in the hashmap
                    copy=Node(n.val)
                    dict[n]=copy
                    q.append(n)                         #push the original of the neighbor nodes to the queue
                dict[curr].neighbors.append(dict[n])    #access the copy of current node and to its neigbors list append the copy of the original neighbors
        return copyNode                                 #return the copyNode