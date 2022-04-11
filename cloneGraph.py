#BFS Iterative:

'''
T = O(N+M) ; N - no of nodes, M - no of edges 
S =  O(N)
'''

def BFScloneGraph(self, node: 'Node') -> 'Node':
    if not node:
        return node
        
    q = deque([])
    q.append(node)        
    visited = {}

    while q:
         cur = q.popleft()
            
          if cur not in visited:
              visited[cur] = Node(cur.val, [])
                
          for nei in cur.neighbors:
              if nei not in visited:
                  visited[nei] = Node(nei.val, [])
                  q.append(nei)
            
              visited[cur].neighbors.append(visited[nei])
                
    return visited[node]
    
#DFS Iterative

def DFScloneGraph(self, node: 'Node') -> 'Node':
    if not node:
        return node
        
    stack = [node]
    visited = {}
        
    while stack:
        cur = stack.pop()
            
        if cur not in visited:
            visited[cur] = Node(cur.val, [])
                
        for nei in cur.neighbors:
            if nei not in visited:
                visited[nei] = Node(nei.val, [])
                stack.append(nei)
                    
            visited[cur].neighbors.append(visited[nei])
                   
     return visited[node]
