// bfs
public class CloneGraph {
    public Node cloneGraph(Node node) {
        // null case
        if(node==null) return null;
        HashMap<Node,Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        Node newNode = new Node(node.val);
        q.add(node);
        map.put(node, newNode);

        while(!q.isEmpty()){
            Node curr = q.poll();
            List<Node> neighbors = curr.neighbors;
            for(Node n: neighbors){
                if(!map.containsKey(n)){
                Node deepcopy = new Node(n.val);
                map.put(n, deepcopy); // put deepcopy in map
                q.add(n);
                }
                // establish connection between deepcopies
                // 1. get deepcopy of current node i.e popped node
                // 2. get neighbours list of deep copy
                // 3. add deep copy of neighbour n
                map.get(curr).neighbors.add(map.get(n));
            }
        }
        return newNode;
    }
}

// TC - O(V+E)
// SC - O(V)


// dfs
public class CloneGraph {
    HashMap<Node,Node> map;
    public Node cloneGraph(Node node) {
        // null case
        if(node==null) return null;
        map = new HashMap<>();
        dfs(node);
        return map.get(node);
    }

    private void dfs(Node node){
        // base
        if(map.containsKey(node)) return;
        // logic
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        for(Node n: node.neighbors){
            if(!map.containsKey(n)){
                dfs(n);
            }
            map.get(node).neighbors.add(map.get(n));
        }
    }
}

// TC - O(V+E)
// SC - O(V)