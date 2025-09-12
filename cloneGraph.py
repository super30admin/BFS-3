from typing import Optional
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if not node:
            return None
        copyNode=Node(node.val)
        clones={node:copyNode}
        visited=set()
        q=deque([node])

        while q:
            size=len(q)
            for _ in range(size):
                curr=q.popleft()
                if curr in visited:
                    continue
                #print('Curr:', curr.val)
                clone=clones[curr]
                visited.add(curr)
                #print('Visited:', visited)
                neighbors=curr.neighbors
                for n in neighbors:
                    if n not in clones:
                        clones[n]=Node(n.val)
                    clone.neighbors.append(clones[n])

                    if n not in visited:
                        q.append(n)
        
        return copyNode
                    
