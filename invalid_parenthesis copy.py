"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    """
    BFS 
    KeyIdea: create hashmap, map original node to its copied node's value and further join its neighbors
    TC:O(v+e) or O(vertices+neighbors)
    """
    def cloneGraph(self, node: 'Node') -> 'Node':
        # keep key as original node and value as copied node value
        if not node:
            return None
        mapp={}
        copy=Node(node.val)
        mapp[node]=copy
        q=collections.deque()
        q.append(node)
        
        while q:
            cur=q.popleft()
            for neig in cur.neighbors:
                if neig not in mapp:
                    copynode=Node(neig.val)
                    mapp[neig]=copynode
                    q.append(neig)
                # creating the connection
                # in cur's deep copy, push deep copy of original neighbors
                mapp[cur].neighbors.append(mapp[neig])
        return mapp[node]

        