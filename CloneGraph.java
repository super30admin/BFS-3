// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

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
    public Node cloneGraph(Node node) {
        if(node ==null) return null;
        Set<Node> visited  = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        HashMap<Node,Node> store = new HashMap<>();
        q.add(node);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                Node current = q.poll();
                Node tmp = clone(current,store);
                visited.add(current);
                for(int j =0;j<current.neighbors.size();j++){
                    Node og= current.neighbors.get(j);
                    Node t = clone(og,store);
                    if(!visited.contains(og)){
                        q.add(og);
                        visited.add(og);
                    }
                    tmp.neighbors.add(t);

                }
            }

        }
        return store.get(node);
    }
    private Node clone(Node node,HashMap<Node,Node> store){
        if(node == null) return null;
        if(store.containsKey(node)) {
            return store.get(node);
        }


        Node tmp = new Node(node.val);
        store.put(node,tmp);
        return tmp;

    }
}
