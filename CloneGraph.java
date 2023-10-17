//TC = O(E+V)
//SC = O(E)

class Solution {
    HashMap<Node,Node> visitedList = new HashMap<>();
    public Node cloneGraph(Node node) {
       
        if(node==null){
            return node;
        }
        if(visitedList.containsKey(node)){
            return visitedList.get(node);
        }
        Node cloneNode = new Node(node.val , new ArrayList());
        visitedList.put(node,cloneNode);
        for(Node neighbor: node.neighbors){
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }
}