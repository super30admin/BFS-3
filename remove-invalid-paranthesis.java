/*

https://leetcode.com/problems/remove-invalid-parentheses/
https://leetcode.com/articles/remove-invalid-parentheses/#

Did it run on leetcode : yes
Time Complexity: 0(N + 2^N)
Space Complexity: 0(N)

Algorithm:
- The catch of the question is all valid paranthesis carved out of invalid paranthesis are of same length.
- Traverse the whole string to catch the number of misplacedRightParanthesis and misplacedLeftParanthesis by keeping
track of left and right.
- Then for the string using backtrack you have two options either to include it or not and prun recursive cases where
rightCount greater than leftCount

*/



class Solution {
    
    private Set<String> validExpressions = new HashSet<String>();
    
    public List<String> removeInvalidParentheses(String s) {
        
        int misplacedLeftParanthesis=0,misplacedRightParanthesis=0;

        for(int i=0;i<s.length();++i){
            if(s.charAt(i)=='('){
                misplacedLeftParanthesis +=1;
            }
            else if(s.charAt(i)==')'){
                
                if(misplacedLeftParanthesis==0){ misplacedRightParanthesis +=1; }
                else{ misplacedLeftParanthesis -=1; }
            }
        }
        
        StringBuilder builder = new StringBuilder();
        this.backtrack(0,s,0,0,misplacedLeftParanthesis,misplacedRightParanthesis,builder);
        
        return new ArrayList<String>(this.validExpressions);
        
    }
    
    
    private void backtrack(
        int index,
        String s,
        int leftCount,
        int rightCount,
        int leftRem,
        int rightRem,
        StringBuilder expression
    ){
        
        
        if(index==s.length()){
            if(leftRem==0 && rightRem==0){
                // valid expression
                this.validExpressions.add(expression.toString());
            }
        }else{
            
            char ch = s.charAt(index);
            if( (ch=='(' && leftRem>0) || (ch==')' && rightRem>0) ){
                 // discarding the current character
                 this.backtrack(
                     index+1,
                     s,
                     leftCount,
                     rightCount,
                     leftRem-ch=='(' ? 1:0,
                     rightRem-ch==')' ? 1:0,
                     expression
                 );
            }
            
            
            // keeping the character
            expression.append(ch);
            
            if(ch!='(' && ch!=')'){
                // its a alphabet, ignore this
                this.backtrack(
                     index+1,
                     s,
                     leftCount,
                     rightCount,
                     leftRem,
                     rightRem,
                     expression
                 );
            }else if(ch=='('){
                // adding opening bracket
                this.backtrack(
                     index+1,
                     s,
                     leftCount+1,
                     rightCount,
                     leftRem,
                     rightRem,
                     expression
                 );
            }else if(rightCount<leftCount){
                // adding closing bracket, only leftCount greater than right count, to prune recursive calls
                this.backtrack(
                     index+1,
                     s,
                     leftCount,
                     rightCount+1,
                     leftRem,
                     rightRem,
                     expression
                 );
            }
            
             expression.deleteCharAt(expression.length()-1);
            
        }
        
    }
}