// Time Complexity : O(N)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
Based on validity perform BFS, when answer found, add to list and return
*/
public class RemoveInvalidParanthesis {
        HashSet<String> visited;
        List<String> result;
        public List<String> removeInvalidParentheses(String s) {
            visited= new HashSet<>();
            result= new ArrayList<>();

            if(s==null || s.length()==0) return result;

            Queue<String> queue= new ArrayDeque<>();
            queue.offer(s);
            visited.add(s);
            boolean found= false;

            while(!queue.isEmpty()){
                int qs= queue.size();
                for(int i=0;i<qs;i++){
                    String curr= queue.poll();
                    if(isValid(curr)){
                        result.add(curr);
                        found=true;
                    }else{
                        if(found==false){
                            for(int j=0;j<curr.length();j++){
                                if(Character.isLetter(curr.charAt(j))) continue;
                                String child= curr.substring(0,j)+curr.substring(j+1);
                                if(!visited.contains(child)){
                                    visited.add(child);
                                    queue.offer(child);
                                }
                            }
                        }
                    }
                }
            }

            return result;
        }

        private boolean isValid(String s){
            int count=0;
            for(char ch: s.toCharArray()){
                if(ch=='('){
                    count++;
                }else if(ch==')'){
                    count--;
                    if(count<0) return false;
                }
            }

            return count==0;
        }
}
