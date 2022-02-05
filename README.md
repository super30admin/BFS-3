# BFS-3

## Problem1 Remove Invalid Parentheses(https://leetcode.com/problems/remove-invalid-parentheses/)

# Time Complexity=O(2**n)
# Space Complexity=O(n)


class Solution:
    
    def is_valid(self,expr:str)-> bool:
        left_count = 0
        right_count = 0
        
        for token in expr:
            if token == '(':
                left_count +=1
            if token == ')':
                if left_count == 0:
                    right_count += 1
                else:
                    left_count -= 1
        return (left_count == 0) and (right_count == 0)
        
   
    def removeInvalidParentheses(self, s: str) -> List[str]:
        queue = deque([s])
        visited = {s}
        output = list()
        
        while queue:
            current_expr = queue.popleft() 
            if self.is_valid(current_expr):
                output.append(current_expr)
            else:
                if not output: 
                    for i in range(len(current_expr)):
                        if current_expr[i] in  {'(',')'} :
                            next_expr = current_expr[:i] + current_expr[i+1:]
                            if next_expr not in visited:
                                visited.add(next_expr)
                                queue.append(next_expr)
        
        return output
## Problem2 Clone graph (https://leetcode.com/problems/clone-graph/)

# Time Complexity=O(n)
# Space Complexity=O(n)


"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        h={}
        q=deque()
        if not node:
            return
        new=Node(node.val)
        q.append(node)
        h[node]=new
        while q:
            curr=q.popleft()
            for i in curr.neighbors:
                if i not in h:
                    newneigh=Node(i.val)
                    h[i]=newneigh
                    q.append(i)
                h[curr].neighbors.append(h[i])
        return new
                
                    
            
        
        
        
        


