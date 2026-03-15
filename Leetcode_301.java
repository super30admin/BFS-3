//Way1
//DFS
//To avoid checking valid strings for repetetive strings - use set
//Have a global len which stores max length of strings present in result
//For every iteration, check if curr string length < maxLen. If yes, don't check validity of that string as it is not needed to add that string in result
//If currStringLen>maxLen, update result to new ArrayList and put the currString in it and update maxLen
//Follow this for all possibilities being exhaustive using DFS
//TC: 2^n
//SC: O(2^n * n)
class Solution {
    List<String> result;
    int len;
    public List<String> removeInvalidParentheses(String s) {
        int n=s.length();

        this.result=new ArrayList<>();
        this.len=0;

        Set<String> set=new HashSet<>();
        
        //add first string
        set.add(s);

        dfs(s,set);

        return result;
        
    }

    private void dfs(String s,Set<String> set){
        //basecase
        if(s.length()<len) return;

        if(isValid(s)){
            if(s.length()>len){
                result=new ArrayList<>();
                len=s.length();
            }

            result.add(s);
        }

        for(int j=0;j<s.length();j++){
            String baby=s.substring(0,j)+s.substring(j+1);
            if(!(set.contains(baby))){
                set.add(baby);
               dfs(baby,set);
            }
        }
        
    }

    private boolean isValid(String str){
        int count=0;

        for(char ch:str.toCharArray()){
            if(ch=='('){
                count+=1;

            }else if(ch==')'){
                if(count<=0) return false;
                count-=1;

            }else{
                continue;
            }
        }

        return count==0;
    }
}


//Way2
//BFS
//To avoid checking valid strings for repetetive strings - use set
//Have a queue and put given string in it
//Travel level order - using size
//If string is valid, put it in result. And make flag as true
//As flag is true, it's children are not added in queue - So, less length strings will not be processed and added to result 
//TC: 2^n
//SC: O(2^n * n)
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int n=s.length();
        List<String> result=new ArrayList<>();
        Set<String> set=new HashSet<>();
        Queue<String> queue=new LinkedList<>();

        //add first string
        set.add(s);
        queue.add(s);

        boolean flag=false;
        while(!queue.isEmpty() && flag==false){
            int size=queue.size();
            for(int i=0;i<size;i++){
                String curr=queue.poll();

                if(isValid(curr)){
                    flag=true;
                    result.add(curr);
                }

                if(flag==false){
                    for(int j=0;j<curr.length();j++){
                        String baby=curr.substring(0,j)+curr.substring(j+1);
                        if(!(set.contains(baby))){
                            set.add(baby);
                            queue.add(baby);
                        }
                    }
                }
            }

            
        }

        return result;
        
    }

    private boolean isValid(String str){
        int count=0;

        for(char ch:str.toCharArray()){
            if(ch=='('){
                count+=1;

            }else if(ch==')'){
                if(count<=0) return false;
                count-=1;

            }else{
                continue;
            }
        }

        return count==0;
    }
}
