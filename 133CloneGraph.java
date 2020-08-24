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
/*
Appraoch:
BFS
Traverse the node say 1 and place the node 1 in hashmap and quueue. 
Now 2  is added to queue and map . The copy node of 2 is said to be created. Now make the edge using the neighors link

*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        
        HashMap<Integer,Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        
        
        q.add(node);
        Node copyNode = new Node(node.val); 
        map.put(node.val,copyNode);
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            List<Node> neighbors = curr.neighbors;
            
            for(Node n :neighbors){
                if(!map.containsKey(n.val)){  //key is n.val and its value is n' ie copy of n
                    Node copy = new Node(n.val);
                    map.put(n.val,copy);
                    q.add(n);
                }
                //set the edges
                //get copy of original node and add its neighbors by copying original node's neighbor
               // map.get(curr).neighbors  --> one dash copy of 1
               //map.get(n) -- copy of original n ie n dash
                map.get(curr.val).neighbors.add(map.get(n.val));
            }
        }
        return copyNode;//map.get(node.val);
    }
}

/*
Time complexity : O(V+E)
Space complexity : O(2n) Queue and hashmap  Asymototically O(n)
*/



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

//DFS
class Solution {
     HashMap<Integer,Node> map;
    public Node cloneGraph(Node node) {
     if(node == null) return node;
     map = new HashMap<>();
     
      dfs(node);
      return map.get(node.val);   //copyNode ie 1' copy of 1        
    }
    
    private void dfs(Node node){
        //base
        if(map.containsKey(node.val)) return; // means visited so exit
        
        Node copyNode = new Node(node.val);
        map.put(node.val,copyNode);
        
        List<Node> neighbors = node.neighbors;
        for(Node n : neighbors){
            dfs(n);   //1-> 2 -->3-->4 now since all visited not going to 4 again
            map.get(node.val).neighbors.add(map.get(n.val));
        }
    }
}

/*
Time complexity :O(V + E)
Space complexity : O(n)
*/