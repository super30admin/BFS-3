//Timecomplexity:- O(n*max characters of invalid string for every level).
//space complexity:-0(n).
//approach with code:- improvising backtracking by doing bfs in which every level represents outputs by removing one paranthesis
//So in bfs in each level if obtained string is valid it will be added to output and visited, if it is not in visited and 
//not valid then children of that are added to queue.



class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Queue<String> cache=new LinkedList<>();
        HashSet<String> visited=new HashSet<>();
        List<String> result=new ArrayList<>();
        cache.add(s);
        visited.add(s);
        boolean found=false;
        while(!cache.isEmpty()){
            String parent=cache.poll();
            if(validbraces(parent)){
                found=true;
                result.add(parent);
            
        }
            if(!found){
                for(int i=0;i<parent.length();i++){
                    if(Character.isLetter(parent.charAt(i))){
                        continue;
                }
                    String child=parent.substring(0,i)+parent.substring(i+1,parent.length());
                    if(!visited.contains(child)){
                        cache.add(child);
                        visited.add(child);
                }
            }
            
        }
        
    }
        return result;
    }
    
    private boolean validbraces(String parent){
        int counter=0;
        for(int i=0;i<parent.length();i++){
            char ch=parent.charAt(i);
            if(ch=='('){
                counter+=1;
            }
            else if(ch==')'){
                if(counter==0){
                    return false;
                }
                counter-=1;
            }
        }
        
        if(counter==0){
            return true;
        }
     return false;
    }
}