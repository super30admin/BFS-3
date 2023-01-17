#Time complexity: O(n)
#space complexity: O(n)
#ran on leetcode: yes
#have a mapping of each node in the graph to a clone node in the clone graph. Do a BFS on the actual graph and establosh the connection s in the clone graph the way it is present in the actual graph.
"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        #created=set()
        if(node==None):
            #print("HERE!!")
            return None
        created={}
        visited=set()
        root=Node(1,None)
        #created.add(0)
        created[0]=root
        Q=[]
        Q1=[]
        Q.append(node)
        Q1.append(root)
        
            
        while(Q):
            curr=Q[0]
            curr1=Q1[0]
                    
            for n in curr.neighbors:
                if(n==None):
                    break
                if(n.val in visited):
                    continue
                
                if(n.val not in created):
                    temp=Node(n.val,None)
                    created[n.val]=temp
                else:
                    temp=created[n.val]
                curr1.neighbors.append(temp)
                temp.neighbors.append(curr1)
                Q.append(n)
                Q1.append(temp)
            del(Q[0])
            del(Q1[0])
            visited.add(curr.val)
        #print(root.neighbors[0].val)
        
            
            
            
        return root
