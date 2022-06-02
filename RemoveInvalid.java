// O(2^N) time: in worst case, only left parantehsis, and for each bracket we either consider or remove it 
//O(N) space: recursive stack

class Solution {
    private Set<String> valid = new HashSet<String>();
    private int minRemoved;
    
    public List<String> removeInvalidParentheses(String s) {
        this.minRemoved = Integer.MAX_VALUE;
        this.recurse(s, 0, 0, 0, new StringBuilder(), 0);
        return new ArrayList(this.valid);
    }
    
    private void recurse(String s, int index, int left, int right, StringBuilder exp, int removed){
        if (index == s.length()){ // reached end of string
            if (left == right){ // current expression is valid
                if (removed <= this.minRemoved){ // current removed count of parenthesis smaller or equal to currrent min count
                    String possibleAns = exp.toString(); // convert stringbuilder to string
                    if (removed < this.minRemoved){ // if current count beats overall min we have until now
                        this.valid.clear();
                        this.minRemoved = removed;
                    }
                    this.valid.add(possibleAns);
                }
            }
        }
        
        else{
            char currentChar = s.charAt(index);
            int length = exp.length();
            
            if (currentChar != '(' && currentChar != ')'){ // current char netiher opening nor closing bracket
                exp.append(currentChar);
                this.recurse(s, index + 1, left, right, exp, removed); // recurse further by adding it to expression
                exp.deleteCharAt(length); // backtrack
            }
            else{
                this.recurse(s, index + 1, left, right, exp, removed + 1); // recursion where we delete current char
                exp.append(currentChar);
            
                if (currentChar == '('){
                    this.recurse(s, index + 1, left + 1, right, exp, removed); // if open paranthesis, consider it and recurse
                }
                else if (right < left){
                    this.recurse(s, index + 1, left, right + 1, exp, removed); // for closing paranthesis, only recurse if right < left
                }
                exp.deleteCharAt(length);
            }
            
        }
    }

}