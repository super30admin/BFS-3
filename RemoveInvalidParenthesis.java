class Solution {
    public List<String> removeInvalidParentheses(String s) {
       List<String> result = new ArrayList<>();
       HashSet<String> set = new HashSet<>();
       Queue<String> q = new LinkedList<>();
       q.add(s);
       set.add(s);
       boolean flag = false;

       while(!q.isEmpty()){
            //int size= q.size();
           // for(int i=0;i<size;i++)
           {
                String curr = q.poll();
                if(isValid(curr)){
                    result.add(curr);
                    flag= true;
                }else{
                    if(!flag){
                        for(int k=0;k<curr.length();k++){
                            if(Character.isAlphabetic(curr.charAt(k))) continue;
                            String baby= curr.substring(0, k)+ curr.substring(k+1);
                            if(!set.contains(baby)){
                                set.add(baby);
                                q.add(baby);
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
        for(char c: s.toCharArray()){
           // char c=s.charAt(i);
            if(Character.isAlphabetic(c)) continue;
            if(c == '('){
                count++;
            }else{
                count--;
                if(count<0) return false;
            }
        }

        return count == 0;
    }
}