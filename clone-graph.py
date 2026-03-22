#---------------- Solution 1 : BFS ----------
''' Time Complexity : O(V+E) 
    Space Complexity : O(V) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No
'''
from typing import Optional
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if node is None:
            return None
        hashmap={}
        q = deque()
        q.append(node)
        newcopy = Node(node.val)
        hashmap[node] = newcopy
        while q:
            curr = q.popleft()
            for nei in curr.neighbors:
                if nei not in hashmap:
                    newcopy = Node(nei.val)
                    hashmap[nei] = newcopy
                    q.append(nei)
                newcopy = hashmap[nei]
                hashmap[curr].neighbors.append(newcopy)

        return hashmap[node]
    
#---------------- Solution 1 : DFS ----------
''' Time Complexity : O(V+E) 
    Space Complexity : O(V) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No
'''

from typing import Optional
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if node is None:
            return None
        hashmap={}
        def dfs(node):
            if node not in hashmap:
                newcopy = Node(node.val)
                hashmap[node] = newcopy
            newcopy = hashmap[node]
            for nei in node.neighbors:
                if nei not in hashmap:
                    dfs(nei)
                newcopy.neighbors.append(hashmap[nei])
        
        dfs(node)
        return hashmap[node]