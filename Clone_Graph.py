# Time Complexity :O(V+E)
# Space Complexity :O(V+E)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach



from collections import deque
from typing import Optional
class Solution:
    h={}
    def clone(self, node):
        if(self.h.get(node, "1")!="1"):
            return self.h[node]
        new_node= Node(node.val)
        self.h[node]=new_node
        print(self.h[node])
        return new_node

    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if(node==None):
            return None
        # self.h={}
        q=deque()
        q.append(node)
        node_copy=self.clone(node)
        while(len(q)):
            curr=q.popleft()
            nei=curr.neighbors
            for i in nei:
                if(self.h.get(i, '1')=='1'):
                    q.append(i)
                node_cp=self.clone(i)
                temp=self.h[curr]
                temp.neighbors.append(node_cp)
        return node_copy


