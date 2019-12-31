/*

Did it run on leetcode: yes
Did you face any difficulty: reading input

Time Complexity: 0(N)
Space Complexity: 0(N)

Algorithm:
- Create a root node from the input and create a hashmap so that you know if you have created the node or not
- Using BFS technique, explore all the neigbors using the attribute `neighbors` and add it to your queue, if it was
unexplored

*/


/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        
        Queue<Node> q = new LinkedList<>();
        Map<Integer,Node> hMap = new HashMap<>();
        
        Node clonedNode = new Node(node.val,new ArrayList<Node>());
        hMap.put(clonedNode.val,clonedNode);
        q.add(node);
        
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            for(Node neighbor: curr.neighbors){
                if(!hMap.containsKey(neighbor.val)){
                    q.add(neighbor);
                    Node newNeighbor = new Node(neighbor.val,new ArrayList<Node>());
                    hMap.put(neighbor.val,newNeighbor);  
                }
                hMap.get(curr.val).neighbors.add(hMap.get(neighbor.val));
            }
        }
        
        return clonedNode;
        
    }
}