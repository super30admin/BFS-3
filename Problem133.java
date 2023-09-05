/*
TC: O(N + E)
//SC: O(N)
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

class Problem133 {
    HashMap<Node, Node> graphNode;
    
    public Node cloneGraph(Node node) {
        if(node==null)
            return null;
        this.graphNode= new HashMap<>();
        Queue<Node> bfsQue=new LinkedList<>();
        bfsQue.add(node);
        Node copyNode=clone(node);
        while(!bfsQue.isEmpty()){
            Node currNode=bfsQue.poll();
            for(Node ne: currNode.neighbors){
                if(!graphNode.containsKey(ne)){
                    bfsQue.add(ne);
                }
                Node cloneNeighbour=clone(ne);
                graphNode.get(currNode).neighbors.add(cloneNeighbour);
            }
        }
        return graphNode.get(node);
    }
    
    public Node cloneGraphDFS(Node node) {
        if(node==null)
            return null;
        this.graphNode= new HashMap<>();
        dfs(node);
        return graphNode.get(node);
    }
    
    private void dfs(Node node){
        //base case
        if(graphNode.containsKey(node))
            return;
        //logic
        Node cloneNode=clone(node);
        for(Node ne: node.neighbors){
            dfs(ne);
            cloneNode.neighbors.add(graphNode.get(ne));
        }
    }
    
    private Node clone(Node node){
        if(!graphNode.containsKey(node)){
            Node cloneNode= new Node(node.val);
            graphNode.put(node, cloneNode);
        }
        return graphNode.get(node);
    }
}
