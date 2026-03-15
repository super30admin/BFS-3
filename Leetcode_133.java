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

//BFS
//Use set to check visited nodes
//Map to store node and it's references
//Queue to travel
//Add initial node to queue and set
//Travel till queue is empty
//Poll queue elemets -> create reference node -> Put in map. Get list of adjacent nodes -> put in queue if they are not in set
//TC: O(V+E)
//SC: O(V+E)

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;

        Map<Node,Node> map=new HashMap<>();

        Queue<Node> queue=new LinkedList<>();
        Set<Node> set=new HashSet<>();

        queue.add(node);
        set.add(node);

        while(!(queue.isEmpty())){
            Node curr=queue.poll();
           
            map.put(curr,clone(curr,map));

            Node refcurr=map.get(curr);

            if(curr.neighbors!=null){
                List<Node> list=new ArrayList<>();
                for(Node nod:curr.neighbors){
                    list.add(clone(nod,map));
                    if(!(set.contains(nod))){
                        set.add(nod);
                        queue.add(nod);
                    
                    }
                }
                refcurr.neighbors=list;
            }
        }
        return map.get(node);
        
    }

    private Node clone(Node node, Map<Node,Node> map){
        if(node == null) return null;

        if(map.containsKey(node)) return map.get(node);

        map.put(node, new Node(node.val));

        return map.get(node);
    }
}
