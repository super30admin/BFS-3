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
// Time complexity -O(V+E)
//Space complexity - O(V)
// Solved on leetcode - yes
// faced any issue s- no
class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        if(node == null) return null;
        Node newNode = new Node(node.val);
        q.add(node);
        map.put(node, newNode);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                Node current = q.poll();
                System.out.print(current.val+ " ");
                for(Node ne : current.neighbors) {
                    if(!map.containsKey(ne)) {
                        map.put(ne, new Node(ne.val));
                        q.add(ne);
                    }
                    map.get(current).neighbors.add(map.get(ne));
                }
            }
        }
        return newNode;
    }
}
