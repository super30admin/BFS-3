//Problem 143: Remove Invalid Parentheses
//TC: Exponential
//SC: O(N)

/*
DFS-> Iterate over the brackets and remove one character, if rest string is valid then just store it

BFS-> At a level when we got a valid string we will stop
Here we keep an queue and iterate using BFS, if a string is invalid then only process it, otherwise not

Exponential->2^N*N^2, N^2 because of checking validity and substring


*/

import java.util.*;
class Solution143 {
    public List<String> removeInvalidParentheses(String s) {
        
        //TC: Will be exponential
        List<String> result = new ArrayList<>();
        
        if(s==null) return result;
        
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(s);
        visited.add(s);
        boolean flag=false;
        while(!q.isEmpty()){
            String curr = q.poll();
            
            if(isValid(curr)){
                flag = true;
                result.add(curr);
            }
              //process string if initially i.e input is invalid otherwise no need to process all the strings 
              if(!flag){
                //means curr string was invalid
               for(int i=0;i<curr.length();i++){//TC:O(N)
                   
                   //if it is a character
                   if(Character.isLetter(curr.charAt(i))) continue;
                   
                   String baby = curr.substring(0,i)+curr.substring(i+1);//TC:O(N) + O(N)
                   
                    //if baby is not in the visited array
                   if(!visited.contains(baby)){
                      visited.add(baby);
                      q.offer(baby); 
                  } 
               }    
            }
                
        }
        
        return result;
    }
    
    private boolean isValid(String s){
        
        int count=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                count++;
            }else if(ch==')'){//because there will be characters also and we have to ignore them
                if(count==0) return false;//if open bracket is not there and directly reached out to the close bracket
                count--;
            }
        }
        
        return count==0;//in end for string to be valid count should be zero
    }
    
}