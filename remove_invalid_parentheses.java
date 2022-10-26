// Time Complexity : O(2^N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    HashSet<String> set;
    List<String> res;
    public List<String> removeInvalidParentheses(String s) {
        if(s.length()==0 || s==null) return new ArrayList<>();

        set = new HashSet<>();
        res = new ArrayList<>();

        Queue<String> q = new LinkedList<>();
        q.add(s);
        boolean found = false;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                String curr = q.poll();

                if(isValid(curr)){
                    found=true;
                    res.add(curr);
                }
                else if(!found){
                    for(int j=0;j<curr.length();j++){
                        if(curr.charAt(j)>='a' && curr.charAt(j)<='z'){
                            continue;
                        }
                        String newSt = curr.substring(0,j) + curr.substring(j+1);
                        if(!set.contains(newSt)){
                            set.add(newSt);
                            q.add(newSt);                            
                        }
                    }
                }
            }

        }
        return res;
    }

    private boolean isValid(String str){
        int count=0;
        for(int i=0;i<str.length();i++){
            if(count<0) return false;
            if(str.charAt(i)=='(') count++;
            if(str.charAt(i)==')') count--;            
        }

        return count==0;
    }
}