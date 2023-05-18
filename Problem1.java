// Time 2^N
// Space 2^N
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        

        List<String> res = new ArrayList<>();
        if(s== null){
            return res;
        }
        Queue<String> q = new LinkedList<>();
        q.add(s);
        Set<String> set =  new HashSet<>();
        set.add(s);
        Boolean flag = false;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0 ; i< size ;i++){
                String curStr = q.poll();
                if(isValid(curStr)){
                    res.add(curStr);
                    flag = true;
                }
                if(!flag){
                    for(int j = 0 ;  j< curStr.length(); j++){
                        Character c = curStr.charAt(j);
                        if (curStr.charAt(j) != '(' && curStr.charAt(j) != ')') continue;
                        String st = curStr.substring(0,j) + curStr.substring(j+1);
                        if(!set.contains(st)){
                            set.add(st);
                            q.add(st);
                        }
                    }
                }
            }
        }
        return res;
    }

    private boolean isValid(String s){
        int count = 0;
        for(int i = 0; i< s.length() ; i++){
            if(s.charAt(i) == '('){
                count++;
            }
            if(s.charAt(i) == ')'){
                if(count==0){
                    return false;
                }
                else{
                    count--;
                }
            }
        }
        return count == 0 ? true: false;
    }
}