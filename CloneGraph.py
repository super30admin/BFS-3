--------------------------Clone Graph------------------------------------------
# Time Complexity : O(nodes) Number of nodes in the graph  
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# We will create a dict where we will keep track of each newly created node with its value. Iterate through graph using BFS,
# and process that node with neighbors and if neighbors are not created we will create and add to the dict. Once they are created /
# we will add neighbors to the curr node copy getting the copy node from the dict.



class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return None
        
        queue = collections.deque()
        queue.append(node)
        d = {}
        copyCurr = Node(node.val)
        d[node.val] = copyCurr
        while queue:
            curr = queue.popleft()
            for i in curr.neighbors:
                if i.val not in d:
                    copy = Node(i.val)
                    d[i.val] = copy
                    queue.append(i)
                d[curr.val].neighbors.append(d[i.val])
        return copyCurr