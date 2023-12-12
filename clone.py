# // Time Complexity : O(V+E)
# // Space Complexity : O(V)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :No

# we create a deep copy of each node and put the mapping of original to copy in a map. using this ap we create the mapping to neighbors as well
from Queue import Queue
class Solution(object):
    def cloneGraph(self, node):
        """
        :type node: Node
        :rtype: Node
        """
        # O(V+E), O(V)
        if not node:
            return None
        hmap={}
        copy=Node(node.val)
        hq=Queue()
        hq.put(node)
        hmap[node]=copy
        while(not hq.empty()):
            curr=hq.get()
            for child in curr.neighbors:
                if(child not in hmap):
                    newchild=Node(child.val)
                    hmap[child]=newchild
                    hq.put(child)
                hmap[curr].neighbors.append(hmap[child])
        return hmap[node]