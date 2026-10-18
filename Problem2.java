// clone graph
// add a node in hashmap and value as a clone node using bfs iterate through and add elements one by one
// Space complexity : O(V)
// Time Complexity : O(V + E)
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
    HashMap<Node,Node> map = new HashMap<>();
    Queue<Node> q = new LinkedList<>();
    public Node cloneGraph(Node node) {
        if(node == null ){
             return null;
        }
        q.add(node);

        while(!q.isEmpty()){
            Node curr = q.poll();
            Node clonecurr = clone(curr);
            for(Node ne: curr.neighbors){
                if(!map.containsKey(ne)){
                    q.add(ne);
                  
                }
                  clonecurr.neighbors.add(clone(ne));
            }
        }



        return map.get(node);




        
    }

    private Node clone(Node curr){
        if(curr == null){ return null;}

        if(map.containsKey(curr)){
             return map.get(curr);
        } 
            int value = curr.val;
            Node copycurr = new Node(value);
            map.put(curr, copycurr);
            return copycurr;

        
    }
}
