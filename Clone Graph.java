/*
class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if node is None:
            return node
        
        copy = Node(node.val)
        queue = collections.deque()
        queue.append(node)
        mapping = dict()
        mapping[node] = copy
        
        while len(queue) > 0:
            cur = queue.popleft()
            for nei in cur.neighbors:
                if nei not in mapping:
                    copynode = Node(nei.val)
                    mapping[nei] = copynode
                    queue.append(nei)
                mapping[cur].neighbors.append(mapping[nei])
        return copy
        #return mapping[node]

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if node is None:
            return node
        
        self.mapping = dict()
        self.dfs(node)
        
        return self.mapping[node]
    
    def dfs(self, node):
        if node in self.mapping:
            return
        
        copy = Node(node.val)
        self.mapping[node] = copy
        for nei in node.neighbors:
            self.dfs(nei)
            self.mapping[node].neighbors.append(self.mapping[nei])
*/
/*
class Solution {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        
        map = new HashMap<>();
        dfs(node);
        return map.get(node);
    }
    private void dfs(Node node){
        if (map.containsKey(node))
            return;
        
        Node copy = new Node(node.val);
        map.put(node, copy);
        
        for (Node nei:node.neighbors){
            Node nei_copy = new Node(nei.val);
            dfs(nei);
            map.get(node).neighbors.add(map.get(nei));
        }
    }
}
*/

// time - O(V+E)
// space - O(V+E)
// logic - started with bfs on given node
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        
        Queue<Node> q = new LinkedList<>();
        HashMap<Node, Node> mapping = new HashMap<>();
        Node copy = new Node(node.val);
        mapping.put(node, copy);
        q.add(node);
        
        while (!q.isEmpty()){
            Node cur = q.poll();
            for (Node nei:cur.neighbors){
                if (!mapping.containsKey(nei)){
                    Node copynode = new Node(nei.val);
                    q.add(nei);
                    mapping.put(nei, copynode);
                }
                mapping.get(cur).neighbors.add(mapping.get(nei));
                
            }
        }
        return copy;
        //return mapping.get(node);
    }
}