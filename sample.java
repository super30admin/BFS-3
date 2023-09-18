Problem 1 Remove Invalid Parenthesis
// Time Complexity : O(n^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// recursively check by removing each of parenthesis if it is valid!, if yes, put in result of maximum length parenthesis.
class Solution {
    //Queue-BF -> N^N
    List<String> res;
    int max;
    HashSet<String> set;
    public List<String> removeInvalidParentheses(String s) {
        this.res= new ArrayList<>();
        if(s==null || s.length()==0)return res;
        set= new HashSet<>();
        // Queue<String> q= new LinkedList<>();
        // q.add(s);
        // set.add(s);
        // boolean flag=false;
        // while(!q.isEmpty() && !flag){
        //     int size=q.size();
        //     for(int i=0;i<size;i++){
        //         String cur=q.poll();
        //         if(isValid(cur)){
        //             flag=true;
        //             res.add(cur);
        //         }
        //         else{
        //             if(!flag){
        //                 for(int k=0;k<cur.length();k++){
        //                     char c= cur.charAt(k);
        //                     if(Character.isAlphabetic(c)) continue;

        //                     String baby= cur.substring(0,k)+ cur.substring(k+1);

        //                     if(!set.contains(baby)){
        //                         set.add(baby);
        //                         q.add(baby);
        //                     }
        //                 }
        //             }//if we didnt find valid substring in above level
        //         }
        //     }
        // }

        // return res;

        dfs(s);
        return res;
    }
    private void dfs(String s){
        //base
        if(s.length()<max) return;
        if(isValid(s)){
            if(s.length()>max){
                max=s.length();
                res=new ArrayList<>();
            }
            res.add(s);
            return;
        }

        //logic
        for(int i=0;i<s.length();i++){
            char c= s.charAt(i);
            if(Character.isAlphabetic(c)) continue;
            String baby= s.substring(0,i)+ s.substring(i+1);
            if(!set.contains(baby)){
                set.add(baby);
                dfs(baby);
            }
        }
        
    }
    
    private boolean isValid(String s){
        int count=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='(') count++;
            else if(c==')'){
                if(count==0) return false;
                count--;
            } 
        }
        return count==0;
    }
}

Problem 2 Clone Graph
// Time Complexity : O(V+E)
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//Clone current node, recursively clone all neighbors if not exists already. do bfs or dfs.
class Solution {
    private Map<Node, Node> map;
    public Node cloneGraph(Node node) {
        this.map=new HashMap<>();
        if(node==null) return null;
        // Queue<Node> q= new LinkedList<>();
        // Node copy=clone(node);
        // q.add(node);

        // while(!q.isEmpty()){
        //     Node cur=q.poll();
        //     List<Node> neigh= cur.neighbors;
        //     for(Node nei: neigh){
        //         if(!map.containsKey(nei)){
        //             q.add(nei);
        //         }
        //         Node nCopy= clone(nei);
        //         map.get(cur).neighbors.add(nCopy);
        //         //nCopy.neighbors.add(map.get(cur));
        //     }
        // }
        // return copy;

        dfs(node);
        return map.get(node);
    }
    //O(V+E) //O(V)
    private void dfs(Node node){
        //base

        //logic
        Node curCopy=clone(node);
        List<Node> neigh= node.neighbors;

        for(Node nei: neigh){
            if(!map.containsKey(nei)){
                dfs(nei);
            }
            map.get(node).neighbors.add(map.get(nei));
        }
    }

    private Node clone(Node node){
        if(map.containsKey(node)) return map.get(node);
        else{
            map.put(node, new Node(node.val));
            
        }
        return map.get(node);
    }
}