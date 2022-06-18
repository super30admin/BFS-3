//time - O(V+E)
//space - O(V+E)
class Solution {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        map = new HashMap();
        clone(node);
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()){
            Node curr = q.poll();
            for(Node n : curr.neighbors){
                if(!map.containsKey(n)){
                    clone(n);
                    q.add(n);
                }
                map.get(curr).neighbors.add(map.get(n));
            }
        }

        return map.get(node);
    }

    private void clone(Node node){
        if(node==null) return;
        Node cloneNode = new Node(node.val);
        map.put(node, cloneNode);
    }
}
