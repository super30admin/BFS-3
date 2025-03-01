//TC O(V+E) //SC O(V)
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Queue<Node> q = new LinkedList<>();
        HashMap<Node,Node> map = new HashMap<>(); // Map of original to deep copy
        Node copyNode = new Node(node.val);
        map.put(node, copyNode);
        q.add(node);
        while(!q.isEmpty()){
            Node curr = q.poll();
            for(Node ne: curr.neighbors){
                if(!map.containsKey(ne)){
                    Node cp = new Node(ne.val);
                    map.put(ne, cp);
                    q.add(ne);
                }
                Node ncpy = map.get(ne);
                map.get(curr).neighbors.add(ncpy);
            }
        }

        return copyNode;
    }
}