import java.util.*;
public class BFS{
      // time complexity : n^n
    // space complexity : n^n
    // any doubts: no
    // did it run on leetcode : yes
    // https://leetcode.com/problems/remove-invalid-parentheses/submissions/
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        boolean flag = false;
        q.add(s);
        set.add(s);
        while(!q.isEmpty() ){
            int size = q.size();
          //  for(int i =0;i<size;i++){
                String curr = q.poll();
                if(isvalid(curr)){
                    flag= true;
                    res.add(curr);
                }else{
                    if(!flag){
                        
                        for(int j =0;j<curr.length();j++){
                            if(Character.isLetter(curr.charAt(j))) continue;
                            String child = curr.substring(0,j)+curr.substring(j+1);
                            if(!set.contains(child)){
                                set.add(child);
                                q.add(child);
                            }
                        }
                    }
                }
                
        //    }
            
        }
        return res;
    }
    private boolean isvalid(String s){
        int count =0;
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                count++;
            }else if(c==')'){
                count--;
                if(count<0) return false;
            }
        }
        return count ==0;
    }
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
    //time complexity : v+e
// space complexity : v+e
// did it run on leetcode : yes
// any doubts:no
//https://leetcode.com/problems/clone-graph/submissions/
class Solution {
    HashMap<Node,Node> map;
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        clone(node);
        while(!q.isEmpty()){
            Node curr = q.poll();
            List<Node> children = curr.neighbors;
            for(Node child : children){
                if(!map.containsKey(child)){
                    clone(child);
                    q.add(child);
                }
                
                map.get(curr).neighbors.add(map.get(child));
            }
        }
        return map.get(node);
        
    }
    private Node clone(Node node){
        Node newnode = new Node(node.val);
        map.put(node,newnode);
        return newnode;
    }
}