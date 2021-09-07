// Time Complexity : O(N^2)
// Space Complexity : O(N*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



class Solution {
    public List<String> removeInvalidParentheses(String s) {
        if(s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        
        Queue<String> queue = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        boolean found = false;
        
        queue.add(s);
        set.add(s);
        
        
        while(!queue.isEmpty() && !found) {
            int sz = queue.size();
            
            for(int i = 0; i < sz; i++) {
                String current = queue.poll();
                
                if(isValid(current)) {
                    result.add(current);
                    found = true;
                } else {
                    if(!found) {
                        for(int j = 0; j < current.length(); j++) {
                            if(Character.isLetter(current.charAt(j))) continue;
                            String child = current.substring(0,j) + 
                                           current.substring(j+1,current.length());
                            if(!set.contains(child)) {
                                queue.add(child);
                                set.add(child);
                            }
                        }
                    }
                }
            }
        }
        return result; 
    }
    private boolean isValid(String s) {
        int count = 0;
        for(int i = 0 ; i < s.length(); i++) {
            if(s.charAt(i) == ')') {
                count--;
            }
            if(s.charAt(i) == '(') {
                count++;
            }
            if(count < 0) {
                return false;
            }
        }
        return count == 0;
    }
}

// Time Complexity : O(V+E)
// Space Complexity : O(V)
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
    Map<Node, Node> visited;
    public Node cloneGraph(Node node) {
        if(node == null) {
            return node;
        }
        visited = new HashMap<>();
        dfs(node);
        return(visited.get(node));
    }
    private void dfs(Node node) {
        if(visited.containsKey(node)) {
            return;
        }
        visited.put(node, new Node(node.val));
        for(Node neighbor : node.neighbors) {
            dfs(neighbor);   
            visited.get(node).neighbors.add(visited.get(neighbor));
        }
    }
}