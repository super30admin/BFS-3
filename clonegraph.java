// TC=O(V + E)
// SC=O(V)

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        clone(map, node);
        Node newNode = new Node(node.val);
        while(!q.isEmpty()){
            Node curr = q.poll();
            for(Node child: curr.neighbors){
                if(!map.containsKey(child)){
                    clone(map, child);
                    q.add(child);
                }
              
                map.get(curr).neighbors.add(map.get(child));
            }
        }
        return map.get(node);
    }
    private void clone(HashMap<Node,Node> map,Node node){
        if(map.containsKey(node)) return ;
        Node newNode = new Node(node.val); 
        map.put(node, newNode);
    }
}