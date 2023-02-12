
// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
 * Use BFS approach
*/
class Solution {
    HashMap<Node, Node> map;

    public Node cloneGraph(Node node) {
        map = new HashMap<>();
        if (node == null)
            return null;
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        clone(node);
        while (!q.isEmpty()) {
            Node currNode = q.poll();
            if (currNode.neighbors == null)
                continue;
            for (Node n : currNode.neighbors) {
                if (!map.containsKey(n)) {
                    clone(n);
                    q.add(n);
                }

                map.get(currNode).neighbors.add(map.get(n));
            }
        }

        return map.get(node);
    }

    private void clone(Node node) {
        if (!map.containsKey(node)) {
            Node deepcopy = new Node(node.val);

            map.put(node, deepcopy);
        }
    }
}

// DFS approach

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
// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
 * Use DFS approach
 */
class Solution {
    HashMap<Node, Node> map;

    public Node cloneGraph(Node node) {
        map = new HashMap<>();
        if (node == null)
            return null;
        dfs(node);
        return map.get(node);
    }

    private void dfs(Node node) {
        // base
        if (map.containsKey(node))
            return;
        // logic
        clone(node);
        for (Node n : node.neighbors) {
            dfs(n);
            map.get(node).neighbors.add(map.get(n));
        }

    }

    private void clone(Node node) {
        if (!map.containsKey(node)) {
            Node deepcopy = new Node(node.val);

            map.put(node, deepcopy);
        }
    }
}