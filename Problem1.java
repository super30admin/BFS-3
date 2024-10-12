class Solution {
    List<String> ls = new ArrayList<>();
    public List<String> removeInvalidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        char[] ca = s.toCharArray();
        if(checkstr(s)){
            ls.add(s);
            return ls;
        }

        for(int i = 0;i<s.length();i++){
            char c = ca[i];
            if(c=='('){
                st.push(i);
            }
            else if(c==')'){
                if(!st.isEmpty()){
                    int idx = st.peek();
                    char c2 = ca[idx];
                    if(c2=='('){
                        st.pop();
                    }
                    else{
                        st.push(i);
                    }

                }
                else{
                    st.push(i);
                }
                
            }
            

        }
        int min_removal = st.size();
        System.out.println(min_removal);
        for(int i=0;i<s.length();i++){
            dfs(s,i,0,min_removal);
        }
        




        return ls;

        
    }

    public void dfs(String s, int idx, int cdepth,int maxdepth){
    

        //process
        StringBuilder sb = new StringBuilder(s);
        sb.deleteCharAt(idx);
        String result = sb.toString();
        //base
        if(cdepth+1==maxdepth){
            if (checkstr(result)){
                if(!ls.contains(result)){
                    ls.add(result);
                }
                
            }
            return;
            
        }


        //recurse
        for(int i=idx;i<result.length();i++){
             if (i != idx && result.charAt(i) == result.charAt(i - 1)) {
                continue;
            }
            dfs(result,i,cdepth+1,maxdepth);
        }


    }

    public boolean checkstr(String s){
        Stack<Integer> st = new Stack<>();
        char[] ca = s.toCharArray();

        for(int i = 0;i<s.length();i++){
            char c = ca[i];
            if(c=='('){
                st.push(i);
            }
            else if(c==')'){
                if(!st.isEmpty()){
                    int idx = st.peek();
                    char c2 = ca[idx];
                    if(c2=='('){
                        st.pop();
                    }
                    else{
                        st.push(i);
                    }

                }
                else{
                    st.push(i);
                }
                
            }
            

        }
        if(st.size()!=0) return false;


        return true;
    }
}