class Problem301 {
//TC=O(n^n)
//SC=O(n^n)   
    List<String> result;
    HashSet<String> parsedString;
    int max=0;
    public List<String> removeInvalidParenthesesDFS(String s) {
        this.result=new ArrayList<>();
        this.parsedString=new HashSet<>();
        dfs(s);
        return result;
    }
    private void dfs(String s){
        //base case
        int sLength=s.length();
        if(sLength<max)
            return;
        else if(isValid(s)){
            if(max<sLength){
                max=sLength;
                result=new ArrayList<>();
            }
            result.add(s);
        }
        //logic
        for(int i=0;i<s.length();i++){
            String curr=s.substring(0,i)+s.substring(i+1);
            if(!parsedString.contains(curr)){
                parsedString.add(curr);
                dfs(curr);
            }
        }
    }
  public List<String> removeInvalidParentheses(String s) {
        List<String> result=new ArrayList<>();
        HashSet<String> parsedString=new HashSet<>();
        Queue<String> bfsQue=new LinkedList<>();
        bfsQue.add(s);
        parsedString.add(s);
        boolean foundValid=false;
        while(!bfsQue.isEmpty() && !foundValid){
            int size=bfsQue.size();
            for(int i=0;i<size;i++){
                String curr=bfsQue.poll();
                if(isValid(curr)){
                    result.add(curr);
                    foundValid=true;
                }else{
                    if(!foundValid){
                        for(int k=0;k<curr.length();k++){
                            char c = curr.charAt(k);
                            if(Character.isAlphabetic(c))
                                continue;
                            String currChild=curr.substring(0,k)+curr.substring(k+1);
                            if(!parsedString.contains(currChild)){
                                bfsQue.add(currChild);
                                parsedString.add(currChild);
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
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='(')
                count++;
            else if(c==')'){
                if(count==0)
                    return false;
                count--;
            }
        }
        return count==0;
    }
}
