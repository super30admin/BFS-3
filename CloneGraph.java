/* TC = O(V+E) BFS solution we traverse all the vertices and its edges i.e. adjacency list corresponding to each node 
 * SC = O(V)
 * 
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
    HashMap<Node,Node> visited;
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Queue<Node> q = new LinkedList<>();
        visited = new HashMap<>();
        Node copyNode = clone(node);
        q.add(node);
        while(!q.isEmpty()){
            Node tempo = q.poll();
            List<Node> list = tempo.neighbors;
            for(int i=0;i<list.size();i++){
                Node temp = list.get(i);
                if(!visited.containsKey(temp)){
                    clone(temp);
                    q.add(temp);
                }
                Node copyNodeTemp = visited.get(tempo);
                copyNodeTemp.neighbors.add(visited.get(temp));
            }
        }
        return copyNode;
    }
    private Node clone(Node node){
        if(!visited.containsKey(node)){
            Node newNode = new Node(node.val);
            visited.put(node,newNode);
        }
        
        return visited.get(node);
    }
}