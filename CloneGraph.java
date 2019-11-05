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
The time complexity is O(V+E) where V is the number of vertices and E is the number of edges in the graph. The space complexity is
O(V)

Here, we use bfs traversal. We use queue as the data structure and we poll the queue. If the corresponing copy is present in our map
retrieve it our make a new node. For each of the neighbour we add neighbour to our copy node.

Yes, the solution passed all the test cases.
*/
class Solution {
    public Node cloneGraph(Node node) {
        if(node==null){return null;}

        //Hashmap to store each copy node.
        HashMap<Integer,Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        Node ret = new Node(node.val,new LinkedList<>());
        map.put(node.val,ret);

        while(queue.size()>0){

            //Poll the queue
            Node pres = queue.poll();
            Node copy;

            //Get a copy node if present in the queue or make one.
            if(map.containsKey(pres.val)){
                copy = map.get(pres.val);
            }
            else{
                copy = new Node(pres.val,new LinkedList<>());
            }

            //For each neighbour of our original node add a copy of neighbour to our copy node
            for(Node each:pres.neighbors){
                if(!map.containsKey(each.val)){
                    queue.offer(each);
                    map.put(each.val,new Node(each.val,new LinkedList<>()));
                }
                copy.neighbors.add(map.get(each.val));
            }


            map.put(pres.val,copy);
        }

        return ret;

    }
}