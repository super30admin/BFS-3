"""
# Definition for a Node.
class Node(object):
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""
# Time: O(nodes+edges)
# Space: O(nodes)
class Solution(object):
    def cloneGraph(self, node):
        """
        :type node: Node
        :rtype: Node
        """
        if node == None:
            return None
        queue1 = []
        queue1.append(node)
        node_ans = Node(node.val)
        queue2 = []
        queue2.append(node_ans)
        dic = {}
        dic[node] = node_ans
        
        while len(queue1) != 0:
            size = len(queue1)
            for i in range(size):
                curr = queue1.pop(0)
                curr_c = queue2.pop(0)
                for child in curr.neighbors:
                    if child not in dic:
                        queue1.append(child)
                        node_c = Node(val = child.val)
                        queue2.append(node_c)
                        dic[child] = node_c
                    curr_c.neighbors.append(dic[child])
                
        return node_ans
                    
                    
                    
                
        
