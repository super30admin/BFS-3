class Solution {
    public List<String> removeInvalidParentheses(String s) {
     Queue<String>q= new LinkedList<>();
     List<String> ret= new ArrayList<>();
     HashSet<String>ans= new HashSet<>();
     HashSet<String> store= new HashSet<>();   
     q.add(s);
     boolean flag=false;
    while(!q.isEmpty()){
        
        String out=q.poll();
        //check 
        boolean check=check(out);
        if(check){ ans.add(out); flag=true;}
    
        for(int i=0;i<out.length()&&!flag;i++){
            
            if(out.charAt(i)!='(' && out.charAt(i)!=')'){ continue;}
            
            String s1=out.substring(0,i);
            String s2=out.substring(i+1);
            String s3= s1+s2;
            if(!store.contains(s3)){
                q.add(s3);
                store.add(s3);
            }
           
            
            }
        
    }    
       for( String ss:ans){
           ret.add(ss);
       }
        return ret;
        
    }
    
    
    public boolean check(String s){
   
        int count=0;
       
        for( int i=0;i<s.length();i++){
            char c= s.charAt(i);
            
            if(c=='('){
                count++;
            }else if(c==')')
            {
                count--;
                if(count<0){  return false;}
            }else{
                
                
            } 
        }
        
       
        if(count==0){return true;}
        
        return false;
        
    }
    
    
}
