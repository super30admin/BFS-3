//Time Complexity = O(N^N)
//Spce complexity = O(N^N)
//Method: BFS: Brute Force Manner. remove one character and check if the string is forming valid parenthesis,and if not found, take children(removing one character) from each of the above strings formed by removing one character.
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        //base
        if(s.length() ==0 || s == null) return null;

        HashSet<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        List<String> result = new ArrayList<>();

        q.add(s);set.add(s);
        boolean flag = false;

        while(!q.isEmpty() && !flag) { // if no flag, then it would iterate through the whole string because there is no terminating condition.
            // String curr = q.poll();
            int size = q.size();
            for(int i =0; i< size ; i++){
                String curr = q.poll();
                if(valid(curr)){
                    result.add(curr);
                    // max = curr.length();
                    flag = true;
                }else{
                    //child
                    if(!flag){ // dont have to do consider babies for next elements in the already present queue and i < size.
                        for(int j =0; j<curr.length() ; j++){

                            // if there are alphabets, just move ahead, and dont disturb it
                            char z = curr.charAt(j);
                            if(Character.isAlphabetic(z)) continue;


                            String child = curr.substring(0,j) + curr.substring(j+1);
                            if(!set.contains(child)){
                                q.add(child);
                                set.add(child);

                            }
                        }
                    }
                }

            }
        }
        return result;

    }

    private boolean valid(String s){
        int count = 0;
        for(int i =0; i< s.length() ; i++){
            char c = s.charAt(i);
            if(c == '(') count++;
            else if(c==')') count--;
            if(count<0)return false;
        }
        return (count ==0);
    }
}
