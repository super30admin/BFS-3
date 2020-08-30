//Time complexity:O(n^2 * 2^n)
//Space complexity:O(n)
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result=new ArrayList();
        if(s==null){
            return result;
        }
        Queue<String> q=new LinkedList();
        Set<String> set=new HashSet();
        q.add(s);
        set.add(s);
        boolean flag=false;
        while(!q.isEmpty()){
            String curr=q.poll();
            if(isValid(curr)){
                flag=true;
                result.add(curr);
            }
            if(!flag){
                for(int i=0;i<curr.length();i++){
                    char c=curr.charAt(i);
                    if(Character.isLetter(c)){
                        continue;
                    }
                    String child=curr.substring(0,i)+curr.substring(i+1);
                    if(!set.contains(child)){
                        q.add(child);
                        set.add(child);
                    }
                }