// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Problem2 {
    private  Map<Node,Node>visitedNode;
    public Node cloneGraph(Node node) {

        visitedNode = new HashMap<>();

        return dfs(node, visitedNode);
    }
//TC:(O(V+E))
//SC:(O(V))
    public Node dfs(Node node,Map<Node,Node>visitedNode) {

        if(node==null) {
            return node;
        }
        if(visitedNode.containsKey(node)) {
            return visitedNode.get(node);
        }else {
            Node clonedNode = new Node(node.val);
            visitedNode.put(node, clonedNode);
            List<Node> neighbours  = node.neighbors;
            for (Node neighbourNode : neighbours) {
                Node returnedNode =  dfs(neighbourNode, visitedNode);
                clonedNode.neighbors.add(returnedNode);


            }

            return visitedNode.get(node);
        }
    }
}
