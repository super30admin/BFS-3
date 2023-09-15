// Time Complexity :O(v+e)
// Space Complexity :O(v)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


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
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Queue<Node> q = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        map = new HashMap<>();
        q.add(node);
        set.add(node);
        Node copy = clone(node);
        //BFS. continue till nothing left in queue
        while(!q.isEmpty()){
            Node temp = q.poll();
            System.out.println(temp.val);
            List<Node> n = temp.neighbors;
            //Get the node out of queue and iterate over it's neighbors'
            for(Node ne: n){
                if(!map.containsKey(ne)){
                    clone(ne);
                }
                map.get(temp).neighbors.add(map.get(ne));
                if(!set.contains(ne)){
                    q.add(ne);
                    set.add(ne);
                }
                
            }
        }

        return copy;
    }

    private Node clone(Node node){
        if(map.containsKey(node)){
            return map.get(node);
        } else{
            Node copy = new Node(node.val);
            map.put(node, copy);
            return copy;
        }
    }
}