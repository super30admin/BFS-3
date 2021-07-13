//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this : no
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
        
        HashMap<Node,Node> map1 = new HashMap<>();
        
        Node copyNode = new Node(node.val);
        
        map1.put(node,copyNode);
        
        Queue<Node> q1 = new LinkedList<>();
        
        q1.add(node);
        
        while(!q1.isEmpty()){
            
            Node curr = q1.poll();
            
            List<Node> list = new ArrayList<>();
            list = curr.neighbors;
            
            for(int i = 0; i < list.size(); i ++){
                
                if(!map1.containsKey(list.get(i))){
                    
                Node deepCopy = new Node(list.get(i).val);
        
                map1.put(list.get(i),deepCopy);
                q1.add(list.get(i));
                }
                
                //original node's neighbors should be added to copy node neighbors
                map1.get(curr).neighbors.add(map1.get(list.get(i)));
            }
        }
        return map1.get(node);
    }
}