//  Time Complexity: O(V + E)
//  Space Complexity: O(V)
//  DFS Approach
class Solution {
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        map.put(node.val, new Node(node.val));
        
        for(Node n: node.neighbors){
            if(!map.containsKey(n.val))
                map.get(node.val).neighbors.add(cloneGraph(n));
            else
                map.get(node.val).neighbors.add(map.get(n.val));
                
        }
        return map.get(node.val);
        
    }
}

//  Time Complexity: O(V + E)
//  Space Complexity: O(V)
//  BFS Approach
class Solution {

    Map<Node, Node> map;
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        this.map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        q.add(node);
        map.put(node, new Node(node.val));


        while(!q.isEmpty()){
            Node curr = q.poll();

            List<Node> neighbors = curr.neighbors;
            for(Node neighbor: neighbors){
                if(!map.containsKey(neighbor)){
                    q.add(neighbor);
                    map.put(neighbor, new Node(neighbor.val));
                }
                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }
}