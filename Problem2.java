// BFS Solution

// Time Complexity - O(n) where n is the number of nodes in the graph
// Space Complexity - O(2n) -> O(n)



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
//BFS Solution
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null)    return null;
        HashMap<Integer,Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        Node newNode = new Node(node.val,new ArrayList<>());
        map.put(node.val,newNode); 
        while(!q.isEmpty()){
            Node curr = q.poll();
            List<Node> neighbors = curr.neighbors;
            for(Node n : curr.neighbors){
                if(!map.containsKey(n.val)){
                    q.add(n);
                    Node nCopy = new Node(n.val,new ArrayList<>());
                    map.put(n.val,nCopy);     
                }
                map.get(curr.val).neighbors.add(map.get(n.val));
            }
        }
        return newNode;
    }
}
