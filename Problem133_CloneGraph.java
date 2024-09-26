/**
 * Time Complexity = O(N)
 * Space Complexity = O(N)
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node,Node> visited;
    public Node cloneGraph(Node node) {

        if(node==null)
            return node;
        visited = new HashMap<>();
        // return dfs(node);
        return bfs(node);
    }

    private Node bfs(Node node){

        Queue<Node> queue = new LinkedList<>();

        visited.put(node, new Node(node.val, new ArrayList<>()));
        queue.add(node);

        while(!queue.isEmpty()){

            Node top = queue.poll();

            for(Node neighbour : top.neighbors){

                if(!visited.containsKey(neighbour)){

                    visited.put(neighbour, new Node(neighbour.val, new ArrayList<>()));

                    queue.add(neighbour);
                }
                visited.get(top).neighbors.add(visited.get(neighbour));
            }
        }
        return visited.get(node);
    }


    private Node dfs(Node node){
        //base
        if(visited.containsKey(node)){
            return visited.get(node);
        }

        Node nodeClone = new Node(node.val, new ArrayList<>());

        visited.put(node, nodeClone);
        //logic
        for(Node neighbour : node.neighbors){
            nodeClone.neighbors.add(dfs(neighbour));
        }

        return nodeClone;
    }
}