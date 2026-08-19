//problem1
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        ArrayList<String> ls=new ArrayList<>();
        Queue<String> q=new LinkedList<>();
        q.add(s);
        boolean flag=false;
        HashSet<String> set=new HashSet<>();
        while(!q.isEmpty()){
            String curr=q.poll();
            if(isvalid(curr)){
                ls.add(curr);
                flag=true;
            }else{
                if(!flag){
                    for(int j=0;j<curr.length();j++){
                        if(Character.isAlphabetic(curr.charAt(j))) continue;
                        String sp=curr.substring(0,j)+curr.substring(j+1);
                        if(!set.contains(sp)){
                            q.add(sp);
                            set.add(sp);
                        }
                    }
                }
            }
        }
        return ls;
    }
    public boolean isvalid(String curr){
        int cnt=0;
        for(int i=0;i<curr.length();i++){
            char ch=curr.charAt(i);
            if(ch=='('){
                cnt++;
            }else if(ch==')'){
                cnt--;
            }
            if(cnt<0) return false;
        }
        return cnt==0;
    }
}
//problem2
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
    HashMap<Node,Node> map;
    public Node cloneGraph(Node node) {
       if(node==null) return null;
       this.map=new HashMap<>();
       Queue<Node> q=new LinkedList<>();
       q.add(node);
       while(!q.isEmpty()){
           Node curr=q.poll();
           Node copycurr=clone(curr);
           for(Node ne:curr.neighbors){
              if(!map.containsKey(ne)){
                  q.add(ne);
              }
              copycurr.neighbors.add(clone(ne));
           }
       }
       return map.get(node);
    }
    public Node clone(Node node){
        if(node==null) return null;
        if(map.containsKey(node)) return map.get(node);
        map.put(node,new Node(node.val));
        return map.get(node);
    }
}
