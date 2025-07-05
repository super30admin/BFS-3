class Solution {
    public Node cloneGraph(Node node) {
      return  DFS(node);
    }
    
    public static Node DFS(Node node){

        Queue<Node> an=new LinkedList<>();
        HashMap<Node,Node> ap=new HashMap<>();

        an.offer(node);
        while(an.peek()!=null){
             Node temp=an.poll();
            Node ns=new Node();
            ns.val=temp.val;
            ap.put(temp,ns);
          
           for(int i=0;i<temp.neighbors.size();i++){
               if(!ap.containsKey(temp.neighbors.get(i)))
                an.offer(temp.neighbors.get(i));
           }

        }
        an.offer(node);
        int [] visited  =new int[ap.size()+1];
        while(an.peek()!=null){
           
              Node temp=an.poll();
               visited[temp.val]=1;
               for(int i=0;i<temp.neighbors.size();i++){
               ap.get(temp).neighbors.add(ap.get(temp.neighbors.get(i)));
              if(visited[temp.neighbors.get(i).val]!=1){
                an.offer(temp.neighbors.get(i));
                visited[temp.neighbors.get(i).val]=1;}
           }
              
        }
        return ap.get(node);
    }

}