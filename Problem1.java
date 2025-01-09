// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Problem1 {
    List<String> result ;
    Set<String> visited ;
    int maxLength = 0;
    public List<String> removeInvalidParentheses(String s) {
        result = new ArrayList<>();
        visited = new HashSet<>();
        //bfsHelper(s);
        dfsHelper(s);
        return result;
    }

    //TC:2^n * n
    //SC:2^n
    public List<String> bfsHelper(String s) {
        boolean flag = false;
        Queue<String> q = new LinkedList<>();


        q.add(s);
        visited.add(s);

        while(!q.isEmpty() && !flag){
            int size = q.size();
            for(int i=0;i<size;i++){
                String curr = q.poll();
                if(isValid(curr)){
                    flag = true;
                    result.add(curr);
                }
                for(int k=0;k<curr.length();k++){
                    if(Character.isAlphabetic(k)) continue;
                    String baby = curr.substring(0,k)+curr.substring(k+1);
                    if(!visited.contains(baby)){
                        q.add(baby);
                        visited.add(baby);
                    }
                }

            }
        }

        return result;

    }

    public void dfsHelper(String curr){

        if(curr.length()<maxLength) return ;

        if(isValid(curr)){
            if(curr.length() > maxLength){
                maxLength = curr.length();
                result.clear();
            }
            result.add(curr);
            return ;
        }
        for(int k=0;k<curr.length();k++){
            if(Character.isAlphabetic(k)) continue;
            String baby = curr.substring(0,k)+curr.substring(k+1);
            if(!visited.contains(baby)){
                visited.add(baby);
                dfsHelper(baby);
            }
        }

    }

    //TC:O(n)
    boolean isValid(String baby){
        int balance =0;
        for(char c : baby.toCharArray()){
            if(Character.isAlphabetic(c)) continue;
            if(c=='('){
                balance++;
            }else{
                balance--;
            }
            if (balance < 0) return false;
        }
        return balance ==0;
    }

}
