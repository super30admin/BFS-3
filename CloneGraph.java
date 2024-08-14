//Approach - BFS
//TC - O(V+E)
//SC - O(V)
class Solution {
    HashMap<Node,Node> map;
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        map = new HashMap<>();

        Node clonedNode = clone(node);
        q.add(node);
        while(!q.isEmpty()){
            Node curr = q.poll();
            List<Node> neighbors = curr.neighbors;
            for(Node neighbor : neighbors){
                if(!map.containsKey(neighbor)){
                    q.add(neighbor);
                }
                Node clonedNeighbor = clone(neighbor);
                map.get(curr).neighbors.add(clonedNeighbor);
            }
        }
        
     return clonedNode;   
    }
    private Node clone(Node node){
        if(map.containsKey(node)){
            return map.get(node);
        }
        else{
            Node newNode = new Node(node.val);
            map.put(node,newNode);

        }
    return map.get(node);
    }
}