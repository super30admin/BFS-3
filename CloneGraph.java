/*
Time: O(N) need to traverse through all nodes
Space: O(N) to store copied node details and maintaining queue for node & neighbors
*/
class Solution {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        //Base:
        if(node==null) return null;
        //Logic:
        map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        Node copyStartNode = new Node();
        //Start by initialising the q
        q.add(node);
        copyStartNode = new Node(node.val);
        map.put(node, copyStartNode); //Add the first node to map
        while(!q.isEmpty()){
            Node curr = q.poll();
            for(Node neighbor: curr.neighbors){
                if(!map.containsKey(neighbor)){
                    Node copyNode = new Node(neighbor.val);
                    map.put(neighbor, copyNode);
                    q.add(neighbor);
                }
                //Get current node from map-> indicating the clone
                map.get(curr).neighbors.add(map.get(neighbor));
            }
            
        }
      return map.get(node);
    }
}
