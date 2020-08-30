//Time complexity:O(V+E)
//Space complexity:O(V+E)
class Solution {
    public Node cloneGraph(Node node) {
        if(node==null){
            return node;
        }
        Map<Integer,Node> map=new HashMap();
        Queue<Node> q=new LinkedList();
        Node newNode=new Node(node.val);
        q.add(node);
        map.put(node.val,newNode);
        while(!q.isEmpty()){
            Node curr=q.poll();
            for(Node n:curr.neighbors){
                if(!map.containsKey(n.val)){
                    Node nodecopy=new Node(n.val);
                    map.put(n.val,nodecopy);
                    q.add(n);
                }
                map.get(curr.val).neighbors.add(map.get(n.val));
            }
        }
        return newNode;
    }
}