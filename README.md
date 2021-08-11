# BFS-3

## Problem1 Remove Invalid Parentheses(https://leetcode.com/problems/remove-invalid-parentheses/)
//Time Complexity = O(2^n)
//Space Complexity = O(n)
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>(); 
        if(s == null || s.length() == 0) return result;
        HashSet<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>(); 
        boolean flag = false; 
        q.add(s);
        set.add(s); 
        
        while(!q.isEmpty()){
            String curr = q.poll(); 
            if(isValid(curr)){
                flag = true;
                result.add(curr);
            }else if(!flag){
                int size = curr.length();
                for(int j = 0; j < size; j++){
                    if(Character.isLetter(curr.charAt(j))) continue; 
                    String child = curr.substring(0,j) + curr.substring(j+1);
                    if(!set.contains(child)){
                        q.add(child);
                        set.add(child); 
                    }
                }
            }
        }
        return result; 
    }
    
    private boolean isValid(String curr){
        int count = 0; 
        for(int i = 0; i < curr.length(); i++){
            char c = curr.charAt(i); 
            if(c == ')'){
                if(count == 0) return false;
                count--;
            }else if(c == '('){
                count++;
            }
        }
        return count == 0;
    }
}

## Problem2 Clone graph (https://leetcode.com/problems/clone-graph/)
//DFS Approach
//Time Complexity = O(V+E)
//Space Complexity = O(V+E)
class Solution {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        map = new HashMap<>(); 
        dfs(node); 
        return map.get(node);
    }
    
    private void dfs(Node node){
        //base
        if(map.containsKey(node)) return; 
        //logic
        Node copy = new Node(node.val); 
        map.put(node,copy); 
        for(Node n : node.neighbors){
            dfs(n);
            map.get(node).neighbors.add(map.get(n));
        }
    }
}
  
//Time Complexity = O(V+E)
//Space Complexity = O(V+E)
//BFS Approach
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        HashMap<Node, Node> map = new HashMap<>(); 
        Queue<Node> q = new LinkedList<>(); 
        
        Node deepCopy = new Node(node.val); 
        map.put(node, deepCopy); 
        q.add(node); 
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            
            for(Node n : curr.neighbors){
                if(!map.containsKey(n)){
                    Node copy = new Node(n.val);
                    q.add(n);
                    map.put(n, copy);
                }
                map.get(curr).neighbors.add(map.get(n));
            }
        }
        return deepCopy; 
    }
}

