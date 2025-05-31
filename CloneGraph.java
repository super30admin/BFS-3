class CloneGraph {
    HashMap<Node, Node> myMap = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        Queue<Node> myQueue = new LinkedList<>();
        myQueue.add(node);
        

        while(!myQueue.isEmpty()){
            Node curr = myQueue.poll();
            Node copyCurr = clone(curr);

            for(Node ne: curr.neighbors){
                if(!myMap.containsKey(ne)){
                    myQueue.add(ne);
                }
                copyCurr.neighbors.add(clone(ne));
            }
        }
        return myMap.get(node);
    }

    private Node clone(Node node){
        if(node == null)
            return null;
        if(myMap.containsKey(node))
            return myMap.get(node);
        myMap.put(node, new Node(node.val));
        return myMap.get(node);
    }
}


/*
 * Time Complexity = O(V+E)
 * Space Complexity = O(2V)
 */