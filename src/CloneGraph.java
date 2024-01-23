// Time Complexity:  O(n)
// Space Complexity: O(n)

// ******************** BFS Approach ********************

class Solution {

    public Node cloneGraph(Node node) {

        if(node == null) return null;
        
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        map.put(node, new Node(node.val));
        queue.add(node);

        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            Node newNode = map.get(curr);                             // get copy of each node
            List<Node> adjList = curr.neighbors;              
            for(Node n : adjList) {
                if(!map.containsKey(n)) {                             // if neighbor not in map
                    map.put(n, new Node(n.val));                      // add it in map
                    queue.add(n);                                     // add it in queue
                }
                newNode.neighbors.add(map.get(n));                    // then add new neighbor
            }
        }

        return map.get(node);                                         // return new head node

    }

}






// // Time Complexity:  O(n)
// // Space Complexity: O(n)

// // ******************** DFS Approach 1 ********************

// class Solution {

//     Map<Node, Node> map;

//     public Node cloneGraph(Node node) {

//         if(node == null) return null;
        
//         map = new HashMap<>();
//         dfs(node);
//         return map.get(node);                                         // return new head node

//     }

//     private void dfs(Node node) {
//         if(map.containsKey(node)) return;                             
//         map.put(node, new Node(node.val));                            // if node pair is not in map, put it
//         for(Node n : node.neighbors) {                                // visit neighbors
//             dfs(n);                                                   // run dfs
//             map.get(node).neighbors.add(map.get(n));                  // add copy of neighbors
//         }
//     }

// }







// // Time Complexity:  O(n)
// // Space Complexity: O(n)

// // ******************** DFS Approach 2 ********************

// class Solution {

//     Map<Node, Node> map;

//     public Node cloneGraph(Node node) {

//         if(node == null) return null;
        
//         map = new HashMap<>();
//         map.put(node, new Node(node.val));                            // add node pair first
//         dfs(node);                                                    // go for dfs
//         return map.get(node);                                         // return new head node

//     }

//     private void dfs(Node node) {                            
//         for(Node n : node.neighbors) {                                // visit neighbors
//             if(!map.containsKey(n)) {                                 // if node pair is not in map
//                 map.put(n, new Node(n.val));                       // put it
//                 dfs(n);                                               // run dfs
//             }
//             map.get(node).neighbors.add(map.get(n));                  // add copy of neighbors
//         }
//     }

// }
