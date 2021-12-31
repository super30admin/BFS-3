#Time O(v+e), space O(v)
class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        
        if not node:
            return
        
        #BFS
        h={}
        q=deque()
        q.append(node)
        copy=Node(node.val)
        #Creating hashmap with the copy as values
        h[node]=copy
        #Traverse Queue
        while q:
         
            cur=q.popleft()
          
            #Checking the neighbors and adding it to the queue
            for neigh in cur.neighbors:
                if neigh not in h:
                    h[neigh]=Node(neigh.val)
                    q.append(neigh)
                h[cur].neighbors.append(h[neigh])
                
                
        return copy
        
