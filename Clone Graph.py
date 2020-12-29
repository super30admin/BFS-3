Time:- O(v+e)
Space:- O(V)
import collections
# Definition for a Node.
class Node(object):
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []


class Solution(object):
    def cloneGraph(self, node):
        """
        :type node: Node
        :rtype: Node
        """
        q=collections.deque([])
        q.append(node)
        visited=dict()
        while(q):
            node=q.popleft()
            if not node:
                break
            if node.val not in visited:
                visited[node.val]=Node(node.val)
                nodecopy=visited[node.val]
            else:
                nodecopy=visited[node.val]
            for neighbor in node.neighbors:
                if neighbor.val not in visited:
                    q.append(neighbor)
                    visited[neighbor.val]=Node(neighbor.val)
                    nodecopy.neighbors.append(visited[neighbor.val])
                else:
                    nodecopy.neighbors.append(visited[neighbor.val])
        node=visited[1]
        return node

                    
                    
                    
                
                
        