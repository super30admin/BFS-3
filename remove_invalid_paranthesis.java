// Time Complexity : Exponential
// Space Complexity :O(n)
class Solution {
    HashSet<String> hs;
    Queue<String> q;
    public List<String> removeInvalidParentheses(String s) {
        if(s==null || s.length()==0) return new ArrayList<>();
        q=new LinkedList<>();
        hs=new HashSet<>();
        List<String> res=new ArrayList<>();
        q.add(s);
        boolean flag=false;
        while(!q.isEmpty()){
           int size=q.size();
            for(int j=0;j<size;j++){
                String curr=q.poll();
                if(check(curr)){
                    flag=true;
                    res.add(curr);   
                } 
                if(!flag){
                for(int i=0;i<curr.length();i++){
                    if(curr.charAt(i)>='a' && curr.charAt(i)<='z') continue;
                    String p= curr.substring(0,i) + curr.substring(i+1);
                    if(!hs.contains(p)){
                        hs.add(p);
                        q.add(p);
                    }
                   
                }
            }
            }   
            
        }
        return res;
    }
    
    private boolean check(String p){
        int i=0;
        for(int j=0;j<p.length();j++){
            
         if(p.charAt(j)=='('){
                i=i+1;
            }else if(p.charAt(j)==')'){
                i=i-1;
                if(i<0) return false;
                
            }
        }
        return i==0;
    }
}