
// using BFS to not choose and check the validity and adding the flag to check the level to identifiy the minimum number of removals
//O(2^N) time complexity
//O(2^n * n) space complexity

class Solution {
    
    public List<String> removeInvalidParentheses(String s) {

        List<String> result = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(s);

        boolean flag = false;

        while(!q.isEmpty() && !flag){
            int size = q.size();

            for(int i = 0 ; i < size; i++){
                String curr = q.poll();
                if(isValid(curr)){
                    result.add(curr);
                    flag = true;
                } else{
                    if(!flag){
                        for(int k = 0 ; k <curr.length(); k++){
                            if(Character.isAlphabetic(curr.charAt(k))){
                                continue;
                            }
                            String newString = curr.substring(0,k) + curr.substring(k+1);
                            if(!set.contains(newString)){
                                q.add(newString);
                                set.add(newString);
                            }

                        }
                    }
                }

            }

        }

        return result;

        



        
    }

    private boolean isValid(String s){
        int count = 0;
        for(int i = 0; i< s.length(); i++){
            if(s.charAt(i) == '('){
                count++;

            } else if(s.charAt(i) == ')'){
                count--;
                if(count == -1){
                    return false;
                }
            }
        }
        return count == 0;
    }

    
}
