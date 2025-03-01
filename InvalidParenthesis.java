/* remove 1, check valid children, continue removing until you find valid substring, return all valid children at that level.
HashSet to remove duplicates

for dfs maintain max length of valid child and dont recurse below max
*/

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        
        List<String> result = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        q.add(s);
        boolean flag = false; //to check if valid string was found
        while(!q.isEmpty()){
       
        for(int i =0; i<q.size();i++){
            String str = q.poll();
            if(isBalanced(str)){
                result.add(str);
                flag = true;
            }

            if(!flag){
                for(int k=0;k<str.length();k++){
                    if(Character.isAlphabetic(str.charAt(k))) continue;
                    //remove kth element
                    String child = str.substring(0,k) + str.substring(k+1);
                    if(!set.contains(child)){
                        q.add(child);
                        set.add(child);
                    }
                    
                }
                
            }
        }
             
        }

        return result;
    }

    private boolean isBalanced(String s){
        int count = 0;

        for(int i =0;i<s.length();i++){
            if(count < 0){
                break;
            }
            if(s.charAt(i) == '('){
                count++;
            }else if(s.charAt(i) == ')'){
                count--;
            }
        }

        return count ==0;
    }
} 
