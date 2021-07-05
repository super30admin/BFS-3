//Time Complexity:O(V+E)
//Space Complexity:O(V+E)
//Approach- In this BFS solution, I'll be maintaining a queue to hold the current and the upcoming node values and a hashmap to maintain the nodes and their corresponding cloned nodes. Each time when I poll a node out of the queue, I'll go over their neighbors and check if they have been added to the map already, then in that case, I'll simply add them to the neighbors list. Else, I'll create a new node for their neighbors and then add them to the neighbors list. 
//This code was executed successfully and got accepted in leetcode.
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        Queue<Node> q=new LinkedList<>();
        Map<Node,Node> map=new HashMap<>();
        Node newNode=new Node(node.val,new ArrayList<>());
        map.put(node,newNode);
        q.offer(node);
        while(!q.isEmpty()){
            Node curNode=q.poll();
           
            for(Node n:curNode.neighbors){
                if(!map.containsKey(n)){
                    Node newn=new Node(n.val,new ArrayList<>());
                    map.put(n,newn);
                    q.offer(n);
                }
                map.get(curNode).neighbors.add(map.get(n));
                
            }
        }
        return newNode;
    }
}