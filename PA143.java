//Leetcode: 133. Clone Graph
//Time complexity: O(nk) , k is avg number of neighbours of a node
//Space Complexity: O(n)

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null ) return node;
        HashMap<Node, Node> hm = new HashMap<>();       
        Queue<Node> q= new LinkedList<>();        
        q.add(node);
        hm.put(node, new Node(node.val));
        while(!q.isEmpty()){
            Node n = q.poll();
            List<Node> nel= n.neighbors;
            for(Node ne : nel){
                if(!hm.containsKey(ne)){
                    hm.put(ne, new Node(ne.val));
                    q.add(ne);
                }
                hm.get(n).neighbors.add(hm.get(ne));
            }
                      
        }
        return hm.get(node);
        
    }
}