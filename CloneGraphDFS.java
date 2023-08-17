import java.util.HashMap;

public class CloneGraphDFS {

        // DFS - Time  O(V+E) and Space O(V)

        // hash map is used in dfs method, so keep it global
        HashMap<Node, Node> map;

        public Node cloneGraph(Node node) {

            // null case
            if(node == null) {

                return null;
            }

            // map of nodes to their deep copies
            map = new HashMap<>();                // O(V) space

            // dfs from first node
            dfs(node);

            // output
            return map.get(node);
        }

        public void dfs(Node curr) {

            // logic
            // action
            if(!map.containsKey(curr)) {

                Node newCurr = new Node(curr.val);
                map.put(curr, newCurr);
            }

            // check neighbors of current node, depth wise recursively, on which dfs is called
            for(Node neighbor: curr.neighbors) {

                // if neighbor is not in hash map already, call dfs on it
                if(!map.containsKey(neighbor)) {

                    dfs(neighbor);
                }

                // add deep copy of neighbor to neighbors list of deep copy of current node
                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }


}


/*
TIME COMPLEXITY = O(V+E)

V - number of vertices (nodes)

E - number of edges in graph

SPACE COMPLEXITY = O(V)

Hash map of nodes has O(V) space
*/