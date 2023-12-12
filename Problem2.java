// Time Complexity : O(V+E)
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {  
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        HashMap<Node,Node> map = new HashMap<>();
        Node copyNode = new Node(node.val);
        map.put(node,copyNode);
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            Node curr = q.poll();
            for(Node child : curr.neighbors){
                if(!map.containsKey(child)){
                    Node newnode = new Node(child.val);
                    map.put(child,newnode);
                    q.add(child);
                }
                map.get(curr).neighbors.add(map.get(child));
            }
        }
        return map.get(node);

    }
}