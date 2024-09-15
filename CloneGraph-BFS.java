class Solution {
    public Node cloneGraph(Node node) {
        if(node == null ) return null;
        HashMap<Integer,Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        Node newnode = new Node(node.val,new ArrayList<>());
        q.add(node);
        map.put(newnode.val , newnode);
        
        while(!q.isEmpty())
        {
            Node curr = q.poll();
            for(Node n : curr.neighbors)
            {
                if(!map.containsKey(n.val))
                {
                    map.put(n.val,new Node(n.val,new ArrayList<>()));
                    q.add(n);
                }
                map.get(curr.val).neighbors.add(map.get(n.val));
            }
        }
        return newnode;
    }
    
}
