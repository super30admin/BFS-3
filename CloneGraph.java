// Time Complexity : O(V+E)
// Space Complexity :  O(V)
// Did this code successfully run on Leetcode : Yes 

// Your code here along with comments explaining your approach
// We store the initial node. From the initial node and its reference to the map, we fetch the 
// neighbors of the node. As we get the neighbors, if its BFS, we iterate over the neighbors to add it to neighbors
// list of the current node to be explored at the next step. If DFS, then we explore the neighbors further and add 
// their neighbors to the map along with its reference. If the map already contains the key, it means that the node copy
// is already present and hence we return back. 

// BFS
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        HashMap<Integer,Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        map.put(node.val,new Node(node.val));
        Node cn = map.get(node.val);
        while(!q.isEmpty()) {
            Node curr = q.poll();
            List<Node> nb = curr.neighbors;
            for(Node n:nb) {
                if(!map.containsKey(n.val)) {
                    map.put(n.val,new Node(n.val));
                    q.add(n);
                }
                map.get(curr.val).neighbors.add(map.get(n.val));
            }
        }
        return cn;
    }
}

// DFS

class Solution {
    HashMap<Integer,Node> map;
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        map = new HashMap<>();
        dfs(node);
        return map.get(node.val);
    }
    
    private void dfs(Node node) {
        if(map.containsKey(node.val)) return;
        map.put(node.val,new Node(node.val));
        List<Node> curr = node.neighbors;
        for(Node n:curr) {
            dfs(n);
            map.get(node.val).neighbors.add(map.get(n.val));
        }
    }
}