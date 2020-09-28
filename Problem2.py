# Time complexity : O(nodes+edges)
# Space complexity : O(nodes)
# Works on leetcode : Yes
#Approach - We use a dictionary to keep track of all the cloned nodes as well as visited nodes in original. Then we use DFS
# to go through the stack and add the neighbors to stack for popped node, if they are not in dictionary. Also we keep adding
#neighbors to popped node.
class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return node
        mapp = {node : Node(node.val)}
        stack = [node]
        while stack:
            n = stack.pop()
            for neigh in n.neighbors:
                if neigh not in mapp:
                    stack.append(neigh)
                    mapp[neigh] = Node(neigh.val)
                mapp[n].neighbors.append(mapp[neigh])
        return mapp[node]