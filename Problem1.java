
// Time Complexity : O(2^n * n) where n is the length of the string
// Space Complexity : O(n) for queue and hashset

//We are using BFS to generate all possible strings by removing one parenthesis at a time We use a hashset to avoid duplicates and a queue to perform BFS
//We also use a flag to indicate if we have found a valid string at the current level
//If we find a valid string, we add it to the answer list and set the flag to true If the flag is true, 
//we do not generate any more strings at the current level We return the answer list at the end
//We also have a helper function to check if a string is valid or not by counting the number of open and close parentheses


class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans=new LinkedList<>();
        HashSet<String> vis=new HashSet<>();
        Queue<String> q=new LinkedList<>();

        q.add(s);
        vis.add(s);
        boolean flag=false;

        while(!q.isEmpty()){
            int size=q.size();
            {
                String curr=q.poll();
                if(isValid(curr)){
                    ans.add(curr);
                    flag=true;
                }else{
                    if(!flag){
                        for(int k=0;k<curr.length();k++){
                            if(Character.isAlphabetic(curr.charAt(k))) continue;
                            String baby=curr.substring(0,k)+curr.substring(k+1);
                            if(!vis.contains(baby)){
                                q.add(baby);
                                vis.add(baby);
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
    boolean isValid(String s){
        int count=0;
        for(int i=0;i<s.length();i++){
            if(Character.isAlphabetic(s.charAt(i))) continue;
            if(s.charAt(i)=='(')
                count++;
            else 
                count--;
            if(count<0)             //if count is negative we have more closing parentheses than opening ones
                return false;
        }
        return count==0;
    }
}