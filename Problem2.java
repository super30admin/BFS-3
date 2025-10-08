
//Time Complexity: O(N+E) where N is number of nodes and E is number of edges
//Space Complexity: O(N) for hashmap and queue

//We are using BFS to traverse the graph and a hashmap to store the mapping of original node to its clone
//If a node is not present in the hashmap, we create a clone and add it to the hashmap
//We also add the neighbors of the current node to the queue if they are not already present in the hashmap
//We return the clone of the starting node at the end


class Solution {
    HashMap<Node,Node> map;
    public Node cloneGraph(Node node) {
        this.map=new HashMap<>();
        if(node==null) return null;

        Queue<Node> q=new LinkedList<>();
        q.add(node);
        
        while(!q.isEmpty()){
            Node curr=q.poll();
            Node copyCurr=clone(curr);
            for(Node ne:curr.neighbors){
                if(!map.containsKey(ne))
                    q.add(ne);
                copyCurr.neighbors.add(clone(ne));
            }
        }
        return map.get(node);
    }
    Node clone(Node node){
        if(node==null)
            return null;
        if(map.containsKey(node))
            return map.get(node);
        map.put(node,new Node(node.val));
        return map.get(node);
    }
}