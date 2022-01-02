// DFS
// /*
// // Definition for a Node.
// class Node {
//     public int val;
//     public List<Node> neighbors;
//     public Node() {
//         val = 0;
//         neighbors = new ArrayList<Node>();
//     }
//     public Node(int _val) {
//         val = _val;
//         neighbors = new ArrayList<Node>();
//     }
//     public Node(int _val, ArrayList<Node> _neighbors) {
//         val = _val;
//         neighbors = _neighbors;
//     }
// }
// */

// class Solution {
//     public Node cloneGraph(Node node) {
//         if(node==null)
//             return null;
//         HashMap<Node, Node> map = new HashMap<>();
//         return helper(node, map);

//     }
//     Node helper(Node node, HashMap<Node, Node> map){
//         if(map.containsKey(node))
//             return map.get(node);
//         Node copy = new Node(node.val);
//         map.put(node, copy);
//         for(Node s:node.neighbors)
//             copy.neighbors.add(helper(s, map));
//         return copy;
//     }
// }

// BFS:
class Solution {
    public Node cloneGraph(Node node) {
        if(node==null)
            return node;
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        Node copy = new Node(node.val);
        map.put(node,copy);
        Node curr, temp;

        while(!q.isEmpty()){
            curr = q.poll();

            for(Node adj:curr.neighbors){
                if(!map.containsKey(adj)){
                    temp = new Node(adj.val);
                    q.add(adj);
                    map.put(adj, temp);
                }
                map.get(curr).neighbors.add(map.get(adj));
            }
        }
        return copy;
    }
}