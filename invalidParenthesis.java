//  tc : O(2^(n*m)) or O(2^(n*n)) worst case m=n
//  sc : O(n*n)
//n = s.length()
//m = max number of invalid parenthesis

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        boolean flag = false;

        q.add(s);

        while(!q.isEmpty() && !flag){
            int size = q.size();

            for(int i =0 ; i<size ; i++){
                String curr = q.poll();
                if(isValid(curr)){
                    list.add(curr);
                    flag = true; 
                }
                else if(!flag){
                    for(int j=0; j<curr.length() ; j++){
                        if (curr.charAt(j)>='a' && curr.charAt(j)<='z') continue;
                        String pres = curr.substring(0,j)+curr.substring(j+1,curr.length());
                        if(!set.contains(pres)){
                            q.add(pres);
                            set.add(pres);
                            System.out.println(pres);

                        }
                    }
                }
            }
        }

        return list;
    }

    private boolean isValid(String s ){
        int count =0;
        for(int i =0 ; i<s.length() ; i++){
            if(s.charAt(i)=='(') count++;
            else if (s.charAt(i)>='a' && s.charAt(i)<='z') continue;
            else if (count>0) count--;
            else return false;
        }
        return count==0;
    }
}
