class RemoveInvalidParanthesis {
    public List<String> removeInvalidParentheses(String s) {
        Queue<String> myQueue = new LinkedList<>();
        List<String> res = new ArrayList<>();
        Set<String> mySet = new HashSet<>();
        Boolean flag = false;
        myQueue.add(s);

        while(!myQueue.isEmpty() && !flag){
            int size = myQueue.size();
            for(int i=0; i< size; i++){
                String curr = myQueue.poll();
                if(isValid(curr)){
                    res.add(curr);
                    flag = true;
                }
                else{
                    for(int k=0; k<curr.length(); k++){
                            String subString = curr.substring(0, k) + curr.substring(k+1, curr.length());
                            if(!mySet.contains(subString)){
                                mySet.add(subString);
                                myQueue.add(subString);
                            }
                        }
                    }
                }
            }
            return res;
        }

    private boolean isValid(String str){
        int count = 0;
        for(Character c: str.toCharArray()){
            if(Character.isAlphabetic(c))
                continue;
            if(c == '(')
                count++;
            else if(c == ')')
                count--;
            if(count == -1)
                return false;
        }
        return count == 0;
    }
}