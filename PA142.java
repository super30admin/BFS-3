//Leetcode: 301. Remove Invalid Parentheses
//Time complexity: O(2^N) , where n is the length of the string
//Space Complexity: O(N),  for queue and hashset
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res= new ArrayList<>();
        boolean flag = false;
        HashSet<String> hs= new HashSet<>();
        Queue<String> q= new LinkedList<>();
        q.add(s);        
        while(!q.isEmpty() ){
            String sub = q.poll();
            if(isValid(sub)){
                res.add(sub);
                flag=true;
            }
            if(!flag){
                for(int i=0;i<sub.length();i++){                   
                    if((sub.charAt(i)>='a' && sub.charAt(i)<='z' )|| (sub.charAt(i)>='A' && sub.charAt(i)<='Z') ) continue;
                    String temp=  sub.substring(0,i)+sub.substring(i+1);
                    if(!hs.contains(temp)){
                        hs.add(temp);
                        q.offer(temp);
                    }                    
                }
            }
        }

        return res;       
    }
    
    public boolean isValid(String s){
       // System.out.println(s);
        int count=0;
        for(int i=0;i<s.length();i++){          
            if(s.charAt(i)==')') count--;
            else if(s.charAt(i)=='(') count++;
            
            if(count<0) return false;
        }
        return count==0;
    }
}