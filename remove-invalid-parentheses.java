//TC:O(n)
//SC:O(n)
//running on leetcode: yes
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if(s==null || s.length()==0) return result;
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        q.add(s);
        set.add(s);
        boolean found=false;
        while(!q.isEmpty() && !found){
            int size=q.size();
            for(int i=0; i<size; i++){
                String curr = q.poll();
                if(isValid(curr)){
                    found=true;
                    result.add(curr);
                }
                else if(!found){
                    for(int j=0; j<curr.length(); j++){
                        if(Character.isLetter(curr.charAt(j))) continue;
                        String baby=curr.substring(0,j) + curr.substring(j+1);
                        if(!set.contains(baby)){
                            q.add(baby);
                            set.add(baby);
                        }
                    }
                }
            }
        }
        return result;
    }
    private boolean isValid(String s){
        //if even length is considered it has error because in the input string characters also exist
        //if(s.length() %2 != 0) return false;
        int count=0;
        for(int i=0; i<s.length(); i++){
            char c=s.charAt(i);
            if(c==')'){
                if(count == 0) return false;
                count--;
            }
            else if(c=='(') {
                count++;
            }
        }
        return count==0;
    }
}
