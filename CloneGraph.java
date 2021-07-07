// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(n) since we are iterating through all the nodes
//Space Complexity: O(n) or O(L) where L is number of levels since we are using additional queue
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Queue<Node> q = new LinkedList<>();
        HashMap<Node,Node> map = new HashMap<>(); 
        Node copyNode = new Node(node.val);
        map.put(node, copyNode);
        q.add(node);
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr.neighbors != null){
                for(Node n: curr.neighbors){
                if(!map.containsKey(n)){
                    Node deepCopy = new Node(n.val);
                    map.put(n, deepCopy);
                    q.add(n);
                }
                //get the deep copy of my curr node
                // and in that deep copy's neighbors add the deep copy of the node n
                map.get(curr).neighbors.add(map.get(n));
            }
          }            
        }
        
        return copyNode;
    }
}