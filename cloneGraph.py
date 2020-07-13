#Time Complexity:O(v+e)
#Space COmplexity:O(v)
#Ran successfully on Leetcode:Yes
#Algorithm:
#Create a hashmap to store the nodes and its copies.
#Create a copyNode of the nodes traversed and add to hashMap wrt to its node if it doesnt exist already.
# Always add the neighbor links while graph traversal.
#return the copyNode
class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return None
        q=[]
        q.append(node)
        seen={}
        copyNode=Node(node.val)
        seen[node]=copyNode
        while q:
            curr=q.pop()
            for n in curr.neighbors:
                if n not in seen:
                    seen[n]=Node(n.val)
                    q.append(n)
                seen[curr].neighbors.append(seen[n])
        return copyNode
 
#DFS SOLution:
        
class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node:
            return None
        seen={}
        def dfs(node):
            if node in seen:return
            copyNode=Node(node.val)
            seen[node]=copyNode
            for n in node.neighbors:
                dfs(n)
                seen[node].neighbors.append(seen[n])
            # return 
       
        dfs(node)
        return seen[node]
