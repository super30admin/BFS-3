//TC: O(v+e)
//SC: O(v)
//running on leetcode: yes
class Solution {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        map = new HashMap<>();
        dfs(node);
        return map.get(node);
    }
    private void dfs(Node node){
        //base
        if(map.containsKey(node)) return;
        //logic
        Node copy = new Node(node.val);
        map.put(node, copy);
        for(Node neighbor : node.neighbors) {
            dfs(neighbor);
            map.get(node).neighbors.add(map.get(neighbor));
        }
    }
}
