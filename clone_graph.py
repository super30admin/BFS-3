"""
# Definition for a Node.
class Node(object):
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution(object):
    def cloneGraph(self, node):
        """
        :type node: Node
        :rtype: Node
        """
#         #dfs
#         #O(n)
#         #O(n)
#         self.mp={}
#         if not node:
#             return node
#         self.dfs(node)
#         return self.mp[node]
#     def dfs(self,node):
#         if node in self.mp:
#             return
#         copyNode=Node(node.val)
#         self.mp[node]=copyNode
#         for n in node.neighbors:
#             self.dfs(n)
#             self.mp[node].neighbors.append(self.mp[n])
        
        
        #bfs
        #O(n)
        #O(n)
        if not node:
            return node
        q=deque()
        mp={}
        
        #(1>1')
        copy= Node(node.val)
        q.append(node)
        #map helps to avoid repetition
        mp[node]=copy
        while q:
            #cur=1
            cur=q.popleft()
            #(1> 2,4)
            for n in cur.neighbors:
                if n not in mp:
                    #(2>2')
                    #(4>4')
                    copyNode=Node(n.val)
                    q.append(n)
                    mp[n]=copyNode
                #update neighbors one at a time of this copied main node after each level
                #(1' has 2' then also 4' as neighbors)
                mp[cur].neighbors.append(mp[n])
        return copy