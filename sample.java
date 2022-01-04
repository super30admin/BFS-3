//remove invslid parenthesis
// time - exponential
// space - o(n!)
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        
        List<String> result = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        set.add(s);
        boolean foundValid = false;    
        
        Queue<String> q = new LinkedList<>();
        q.add(s);
        
        while(!q.isEmpty() && foundValid==false){
            
            int size = q.size();
            
            for (int i = 0; i < size; i++){
                
                String curr = q.poll();
                
                if(isValid(curr)){
                    
                    result.add(curr);
                    foundValid = true;
                }
                
                for(int j = 0; j < curr.length(); j++){
                    
                    if(curr.charAt(j) == '(' || curr.charAt(j) == ')'){
                        
                        String child = curr.substring(0,j) + curr.substring(j+1, curr.length());
                        
                        if(!set.contains(child)){
                            
                            set.add(child);
                            q.add(child);
                        }
                    }
                }
            }
        }
        
        return result;
    }
    
    private boolean isValid(String s){
        
        int length = 0;
        
        for(int i = 0; i < s.length(); i++){
            
            if(s.charAt(i)=='('){
                length++;
            }
            else if(s.charAt(i)==')'){
                
                if(length==0){
                   
                    return false;
                }
                    
                length--;
                
            }
            
        }
        return length == 0;
        
    }
    
}

//cline the graph
//tc v+e
//sc n
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
        
        if(node==null) return node;
        
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        
        q.add(node);
        
        Node copy = new Node(node.val);
        map.put(node,copy);
        
        while(!q.isEmpty()){
            
            Node curr = q.poll();
            
            for(Node neighbor : curr.neighbors){
                
                if(!map.containsKey(neighbor)){
                    
                    Node neighborCopy = new Node(neighbor.val);
                    map.put(neighbor, neighborCopy);
                    q.add(neighbor);
                }
                
                map.get(curr).neighbors.add(map.get(neighbor));
                
            }
        }
        
        //dfs(node, map);
        return copy; 
            
    }
    
    private void dfs(Node node, HashMap<Node, Node> map){
        
        Node copy = new Node(node.val);
        map.put(node, copy);
        
        for(Node neighbor : node.neighbors){
            
            if(!map.containsKey(neighbor)){
                
                Node copyNeighbor = new Node(neighbor.val);
                map.put(neighbor, copyNeighbor);
                dfs(neighbor, map);
            }
            map.get(node).neighbors.add(map.get(neighbor));
        }
        
    }
    
    
}
