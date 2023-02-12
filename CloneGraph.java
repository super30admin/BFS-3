// Time Complexity : O(V+E)
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        Node copyNode = clone(node);
        while(!q.isEmpty()){
            Node curr = q.poll();
            for(Node n: curr.neighbors){
                if(!map.containsKey(n)){
                    clone(n);
                    q.add(n);
                }
                map.get(curr).neighbors.add(map.get(n));
            }
        }
        return copyNode;
    }
    private Node clone(Node node){
        if(map.containsKey(node))
            return map.get(node);
        Node deepCopy = new Node(node.val);
        map.put(node, deepCopy);
        return deepCopy;
    }
}