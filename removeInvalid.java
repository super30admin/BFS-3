// TC:O(2^n)
// SC:O(2^n)

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        boolean balanced = false;
        q.add(s);set.add(s);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                String curr = q.poll();
                if(isBalanced(curr)){
                    result.add(curr);
                    set.add(curr);
                    balanced=true;
                }
                if(!balanced){
                    for(int k=0;k<curr.length();k++){
                        if(Character.isLetter(curr.charAt(k))) continue;
                        String child = curr.substring(0,k)+curr.substring(k+1);
                        if(!set.contains(child)){
                            q.add(child);
                            set.add(child);
                        }
                    }
                }
            }
            if(balanced) break;
        }
        return result;
    }

    private boolean isBalanced(String curr){

        int count=0;
        for(int i=0;i<curr.length();i++){
            char c = curr.charAt(i);
            if(Character.isLetter(c)) continue;
            if(c=='('){
                count++;
            }else{
                if(count==0) return false;
                count--;
            }
        }

        return count==0;
    }
}