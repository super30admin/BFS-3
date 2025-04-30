// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


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
        if(node == null) {
            return null;
        }
        Map<Node, Node> m = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        Node node1 = new Node(node.val);
        m.put(node, node1);
        q.add(node);
        while(!q.isEmpty()) {
            Node existing = q.poll();
            List<Node> neighbors = existing.neighbors;
            for (Node neighbor:neighbors) {
                if (!m.containsKey(neighbor)){
                    Node copynode = new Node(neighbor.val);
                    m.put(neighbor, copynode);
                    m.get(existing).neighbors.add(copynode);
                    q.add(neighbor);
                } else {
                    Node copiednode = m.get(neighbor);
                    m.get(existing).neighbors.add(copiednode);
                }
            }
        }
        return node1;
    }
}

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Queue<String> q = new LinkedList<>();
        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        boolean flag = false;
        q.add(s);
        set.add(s);
        while(!q.isEmpty()) {
            String curr = q.poll();
            if(isValid(curr)) {
                //if(!set.contains(curr)) {
                    //set.add(curr);
                    result.add(curr);
                //}
                flag=true;
            } else if( flag == false ){
                for(int j=0;j<curr.length();j++) {
                    char c = curr.charAt(j);
                    if (c >= 'a' && c<= 'z') {
                        continue;
                    }
                    String child = curr.substring(0,j) + curr.substring(j+1);
                    if(!set.contains(child)) {
                        set.add(child);
                        q.add(child);
                    }
                }
            }
        }
        return result;
    }

    private boolean isValid(String str) {
        Stack<Character> st = new Stack<>();
        for (char c: str.toCharArray()) {
            if (c >= 'a' && c<= 'z') {
                continue;
            }
            if (c == '(') {
                st.push(')');
            } else if (!st.isEmpty() &&  st.peek() != c) {
                return false;
            } else if (!st.isEmpty() &&  st.peek() == c) {
                st.pop();
            } else if (st.isEmpty()) {
                return false;
            }
        }
        return st.isEmpty();
    }
}
