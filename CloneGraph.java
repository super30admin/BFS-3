// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};

// BFS - Optimized Approach
// Time Complexity: O(V + E)
// Space Complexity: O(V + E)
 class Solution {
     public Node cloneGraph(Node node) {
         if(node == null) {
             return null;
         }
         Map<Integer, Node> map = new HashMap<>();
         Queue<Node> q = new LinkedList<>();
         q.offer(node);
         Node copyNode = new Node(node.val);
         map.put(node.val, copyNode);

         while(!q.isEmpty()) {
             int size =  q.size();
             for(int i = 0; i < size; i++) {
                 Node cur = q.poll();
                 Node cNode = map.get(cur.val);
                 for(Node neighbor:cur.neighbors) {
                     if(map.get(neighbor.val) == null) {
                         map.put(neighbor.val, new Node(neighbor.val));
                         q.offer(neighbor);
                     }
                     cNode.neighbors.add(map.get(neighbor.val));
                 }
             }
         }

         return copyNode;
     }
 }

// DFS
// Time COmplexity: O(v +E)
// Space Complexity: O(V+E)
class Solution {
    Map<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        dfs(node);
        return map.get(node.val);
    }

    private void dfs(Node node) {
        if(map.containsKey(node.val)) {
            return;
        }

        map.put(node.val, new Node(node.val));

        for(Node neighbor: node.neighbors) {
            dfs(neighbor);
            map.get(node.val).neighbors.add(map.get(neighbor.val));
        }
    }
}