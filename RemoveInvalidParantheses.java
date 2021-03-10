class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        HashSet<String> visited = new HashSet<>();
        //if the input string is valid then directly return it
        if(validity(s)){
            res.add(s);
            return res;
        }
        Queue<String> q = new LinkedList<>();
        String sub = "";
        //Start with the input string
        q.add(s);
        boolean found = false;
        //Iterate over until the queue is empty
        while(!q.isEmpty()){
            //if the valid string is found then return the whole list
            if(found)
                return res;
            int size = q.size();
            for(int l=0;l<size;l++){
                //poll a string and add the next set of strings by removing char from each index
                String p = q.poll();
                for(int i=0;i<p.length();i++){
                    if(p.charAt(i) == '(' || p.charAt(i) == ')'){
                        sub = p.substring(0,i)+p.substring(i+1);
                        //if the substring is valid change the found value to true
                        if(validity(sub)){
                            found = true;
                        //if result doesn't have that substring then add it to the list
                        if(!res.contains(sub))
                            res.add(sub);
                        }
                        //if substring is not found check if the string is visited, if not then add to queue and also the visited set
                        if(!found){
                            if(!visited.contains(sub)){
                                q.add(sub);
                                visited.add(sub);
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
    public boolean validity(String s){
        //if opening bracket then increment count, for closed one decrement count, if count<0 then return false as it is an invalid string
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(')
                count++;
            else if(s.charAt(i) == ')'){
                count--;
                if(count<0)
                    return false;
            }
        }
        //if number of opening and closing brackets is same return true
        return count==0;
    }
}

//Time complexity : O(2^N)
//Space complexity : O(N)
