// BFS Approach
// Time : O(V+E)
// Space O(N) : N -> number of nodes.


class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        Map<Integer, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        Node copyNode = new Node(node.val);
        q.add(node);
        map.put(node.val, copyNode);

        while(!q.isEmpty()){
            Node curr = q.poll();
            for(Node n: curr.neighbors){
                if(!map.containsKey(n.val)){
                    Node copy = new Node(n.val);
                    map.put(n.val, copy);
                    q.add(n);
                }
                // get the copy of the original node from the hashmap
                // add to its neighbors the copy of the original node's neighbor
                map.get(curr.val).neighbors.add(map.get(n.val));
            }
        }
        return copyNode; // same as map.get(node.val)


    }
}

// DFS Approach
// Time Complexity: O(V+E)
// Space Complexity: O(N)
class Solution {
    Map<Integer, Node> map;
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        map = new HashMap<>();
        dfs(node);
        return map.get(node.val);
    }

    private void dfs(Node node){
        // base case
        if(map.containsKey(node.val)){
            return;
        }

        Node copyNode = new Node(node.val);
        map.put(node.val, copyNode);

        for(Node n: node.neighbors){
            dfs(n);
            map.get(node.val).neighbors.add(map.get(n.val));
        }
    }
}
