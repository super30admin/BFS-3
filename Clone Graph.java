// Time Complexity :O(V+E)
// Space Complexity :O(n)

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        HashMap<Node,Node> map=new HashMap<>();
        Queue<Node>q=new LinkedList<>();
        Node copyNode=new Node(node.val);
        map.put(node,copyNode);
        q.add(node);
        while(!q.isEmpty())
        {
            Node curr=q.poll();
            for(Node n:curr.neighbors)
            {
                if(!map.containsKey(n))
                {
                    Node copy=new Node(n.val);
                    map.put(n,copy);
                    q.add(n);
                }
                //neighbours of my curr need deep copy.I have add deep copy of n
                    map.get(curr).neighbors.add(map.get(n));
            }
        }
        return copyNode;
    }
}
