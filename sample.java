## Problem1 Remove Invalid Parentheses(https://leetcode.com/problems/remove-invalid-parentheses/)

// Time Complexity : 0(2^n)
// Space Complexity : 0(2^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    List<String> result;
    HashSet<String> set;
    int max;

    public List<String> removeInvalidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        set = new HashSet<>();
        result = new ArrayList<>();
        dfs(s);
        return result;        
    }

    private void dfs(String s) {
        if (set.contains(s) || s.length() < max) {
            return;
        }
        if (isValid(s)) {
            if (max < s.length()) {
                max = s.length();
                result = new ArrayList<>();
                result.add(s);
            }
            else if (s.length() == max) {
                result.add(s);
            }
        }
        set.add(s);
        for (int j = 0; j < s.length(); j++) {
            if (Character.isLetter(s.charAt(j))) continue;
            String child = s.substring(0, j) + s.substring(j + 1);
            dfs(child);
        }
    }

    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            }
            else if (c == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }
}


## Problem2 Clone graph (https://leetcode.com/problems/clone-graph/)

// Time Complexity : 0(V + E)
// Space Complexity : 0(V)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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

class Solution {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        map = new HashMap<>();
        dfs(node);
        return map.get(node);      
    }
    private void dfs (Node node) {
        if (map.containsKey(node)) {
            return;
        }
        Node clonedNode = clone(node);
        for (Node n : node.neighbors) {
            dfs(n);
            clonedNode.neighbors.add(map.get(n));
        }
    }
    private Node clone (Node node) {
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node newnode = new Node(node.val);
        map.put(node, newnode);
        return newnode;
    }
}