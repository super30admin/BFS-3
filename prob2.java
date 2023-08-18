// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes



class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        return clone(node,new HashMap<Integer,Node>());
        
    }
    public Node clone(Node node,Map<Integer,Node> map){
        if(map.containsKey(node.val)){
            return map.get(node.val);
        }
        Node newNode = new Node(node.val);
        map.put(node.val,newNode);
        for(Node myNode : node.neighbors){
            newNode.neighbors.add(clone(myNode,map));
        }
        return newNode;
    }
}