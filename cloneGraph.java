/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
//TC : O(V+E)
//SC : O(V)
class Solution {
    HashMap<Node,Node> hm;
    Queue<Node>q;
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        hm = new HashMap<>();
        q = new LinkedList();
        q.add(node);
        Node newHeadNode = duplicateNode(node);
        while(!q.isEmpty())
        {
            Node n = q.poll();
            List<Node> neighborsList = n.neighbors;
            //Node dupNode = duplicateNode(n);
            for(Node neighbor : neighborsList)
            {
                if(!hm.containsKey(neighbor))
                {
                    duplicateNode(neighbor);
                    q.add(neighbor);
                }
                hm.get(n).neighbors.add(hm.get(neighbor));
            }
        }
        return newHeadNode;
    }

    public Node duplicateNode(Node node){
        if(hm.containsKey(node)) return hm.get(node);

        Node n = new Node(node.val);
        hm.put(node,n);
        return n;
    }
}