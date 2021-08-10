// Time Complexity :O(length of parenthesis * number of invalid parenthesis)
// Space Complexity :O(length of parenthesis * number of invalid parenthesis)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        if(s==null || s.length()==0)
            return new ArrayList<>();
        List<String> output= new ArrayList<>();
        HashSet<String> set = new HashSet<>();//to maintain unique answers
        Queue<String> q = new LinkedList<>();
        boolean found=false;
        q.add(s);
        while(!q.isEmpty()){
            String pop=q.poll();
            if(isValid(pop)){
                found=true;
                output.add(pop);
            }
            if(!found){//we will stop adding to queue if we find the valid parenthesis at a particular level
                for(int i=0;i<pop.length();i++){
                    if(Character.isLetter(pop.charAt(i))){
                        continue;
                    }
                    String s_short=pop.substring(0,i)+pop.substring(i+1,pop.length());//checking all possible string , removing one character at a time
                    if(!set.contains(s_short)){
                        set.add(s_short);
                        q.add(s_short);
                    }
                }
            }
        }
        return output;
    }
    
    
    public boolean isValid(String s){//checks if parenthesis is valid 
        int counter=0;
        for(char ch: s.toCharArray()){
            if(ch=='('){
                counter+=1;
            }
            else if(ch==')'){//if the String starts with ) it means, it can not be valid at all
                if(counter==0)
                    return false;
                counter-=1;
            }
            else//in case of charcters
                continue;
        }
        return counter==0;
    }
}