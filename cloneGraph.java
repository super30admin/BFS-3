/*
 * // Definition for a Node.
 * class Node {
 * public int val;
 * public List<Node> neighbors;
 * public Node() {
 * val = 0;
 * neighbors = new ArrayList<Node>();
 * }
 * public Node(int _val) {
 * val = _val;
 * neighbors = new ArrayList<Node>();
 * }
 * public Node(int _val, ArrayList<Node> _neighbors) {
 * val = _val;
 * neighbors = _neighbors;
 * }
 * }
 */

// BFS Solution

/*
 * // Definition for a Node.
 * class Node {
 * public int val;
 * public List<Node> neighbors;
 * public Node() {
 * val = 0;
 * neighbors = new ArrayList<Node>();
 * }
 * public Node(int _val) {
 * val = _val;
 * neighbors = new ArrayList<Node>();
 * }
 * public Node(int _val, ArrayList<Node> _neighbors) {
 * val = _val;
 * neighbors = _neighbors;
 * }
 * }
 */

/*
 * class Solution {
 * public Node cloneGraph(Node node) {
 * //Tc: O(N+M) Sc: O(N+M)
 * if (node == null) return null;
 * 
 * HashMap<Node, Node> map = new HashMap<>();
 * LinkedList<Node> q = new LinkedList<>();
 * q.add(node);
 * map.put(node, new Node(node.val, new ArrayList<>()));
 * 
 * while (!q.isEmpty()) {
 * Node n = q.remove();
 * for (Node neighbor : n.neighbors) {
 * if (!map.containsKey(neighbor)) {
 * map.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
 * q.add(neighbor);
 * }
 * map.get(n).neighbors.add(map.get(neighbor));
 * }
 * }
 * 
 * return map.get(node);
 * }
 * }
 * 
 */

/*
 * //DFS SOlution
 * class Solution {
 * // Tc: O(N+M) Sc: O(n)
 * HashMap<Node, Node> map = new HashMap<>();
 * 
 * public Node cloneGraph(Node node) {
 * if (node == null)
 * return node;
 * 
 * if (map.containsKey(node))
 * return map.get(node);
 * 
 * Node newNode = new Node(node.val, new ArrayList<>());
 * map.put(node, newNode);
 * 
 * for (Node i : node.neighbors) {
 * newNode.neighbors.add(cloneGraph(i));
 * }
 * return newNode;
 * }
 * }
 * 
 */