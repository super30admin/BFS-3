// Time Complexity : The time complexity is O(n^2) where n is the number of graph nodes
// Space Complexity : The space complexity is O(n) where n is the number of graph nodes
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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

        if(node == null){
            return null;
        }

        Queue<Node> q = new LinkedList<>();
        Map<Integer,Node> map = new HashMap<>();
        q.offer(node);

        while(!q.isEmpty()){

            Node cur = q.poll();
            Node clone;

            //clone the current node
            if(!map.containsKey(cur.val)){
                clone = new Node(cur.val);
                map.put(cur.val,clone);
            }
            else{
                clone = map.get(cur.val);
            }

            // clone the neighbours
            for(Node n:cur.neighbors){

                Node neigh;

                if(!map.containsKey(n.val)){
                    neigh = new Node(n.val);
                    map.put(n.val,neigh);
                    q.offer(n);
                }
                else{
                    neigh = map.get(n.val);
                }

                clone.neighbors.add(neigh);
            }
        }
        return map.get(node.val);
    }
}
