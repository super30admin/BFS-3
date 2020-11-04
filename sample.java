// Remove Invalid Parentheses
// Time Complexity : O(2 ^ n) where n = length of string
// Space Complexity : O(n) for queue

// Your code here along with comments explaining your approach
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        
        List<String> result = new ArrayList<>();
        
        // base condition
        if(s == null) {
            return result;
        }

        HashSet<String> hashSet = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        boolean found = false;
        
        hashSet.add(s);
        queue.add(s);        

        // perform bfs
        while (!queue.isEmpty()) {
            s = queue.poll();
            
            if (isValid(s)) { // if valid parenthsis
                result.add(s);
                found = true;
            }

            if (!found) {
                for(int i=0; i<s.length(); i++){ // to choose not choose
                    if (Character.isLetter(s.charAt(i))) {
                        continue;
                    }

                    String subStr = s.substring(0,i)  + s.substring(i+1);
                    if (!hashSet.contains(subStr)) { // if not present in hashSet, add the new string to hashSet and queue
                        hashSet.add(subStr);
                        queue.add(subStr);
                    }
                }
            }
        }

        return result;
    }

    public boolean isValid(String s) {
        int count = 0;

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            }

            if (c == ')') {
                if(count == 0) {
                    return false;
                }
                count--;
            }
        }

        return count == 0;
    }
}

// Clone Graph
// Time Complexity : O(V + E)
// Space Complexity : O(V + E) for hashMap and arrayList

// Your code here along with comments explaining your approach
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
    public Node cloneGraph(Node node) {
        if (node == null) {
             return null;
        }

        return dfs(node);
    }

    HashMap<Integer,Node> map = new HashMap<>();

    private Node dfs(Node node) {
        // if map contains the node.val, return the value, arraylist
        if(map.containsKey(node.val)) {
            return map.get(node.val);
        }
        // else create a new node with value as empty arrayList
        Node newnode = new Node(node.val, new ArrayList<>());
        map.put(node.val,newnode);
        // loop over neighbors
        for(Node n: node.neighbors) {
            perform dfs
            map.get(node.val).neighbors.add(dfs(n));
        }

        return newnode;
    }
}
