//Time Complexity:O(n*(2^n))
//Space Complexity:O(n)
//Approach- Here I'll be maintaining a queue to go over the possible combinations of the string and a set to maintain unique value of combination of strings. Whenever I find a valis string, I'll just iterate over the other values in that same level and will not add their children combination which will involve additional deletions. If I have not found a valid string at one level, then I'll move forward to the next level by finding all possible combinations of string by a few deletions and repeat the process.
//This code was executed successfully and got accepted in leetcode.
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result=new ArrayList<>();
        if(s==null){
            return result;
        }
        Queue<String> q=new LinkedList<>();
        Set<String> set=new HashSet<>();
        boolean found=false;
        q.add(s);
        set.add(s);
        while(!q.isEmpty()){
            String a=q.poll();
            if(isValid(a)){
                result.add(a);
                found=true;
                    
            }
            if(!found){
                for(int i=0;i<a.length();i++){
                    if(Character.isLetter(a.charAt(i))){
                        continue;
                    }
                    String b=a.substring(0,i)+a.substring(i+1);
                    if(!set.contains(b)){
                        set.add(b); 
                        q.add(b);
                    }
                    
                }
            }
        }
        return result;
    }
    public boolean isValid(String s){
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                count++;
            }
            else if(s.charAt(i)==')'){
                if(count==0){
                    return false;
                }
                count--;
            }
        }
        return count==0;
    }
}