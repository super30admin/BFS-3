import java.util.*;

//Time Complexity=O(V+E)
//Space Complexity=O(V)
public class CloneGraphBFS {
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
    public Node cloneGraph(Node node) {
        HashMap<Node,Node> map=new HashMap<>();
        if(node==null) return  null;
        Node newHead=new Node(node.val);
        map.put(node,newHead);
        Queue<Node> q=new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()){
            Node curr=q.poll();
            List<Node> currList=curr.neighbors;

            for(Node neigh:currList){
                if(!map.containsKey(neigh)){
                    Node newNode=new Node(neigh.val);
                    map.get(curr).neighbors.add(newNode);
                    map.put(neigh,newNode);
                    q.add(neigh);
                }else{
                    map.get(curr).neighbors.add(map.get(neigh));
                }

            }
        }

        return newHead;

    }
}
