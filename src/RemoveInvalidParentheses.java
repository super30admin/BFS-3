//TC = exponential (every intermediate invalid string s has s.length() options)
//SC = length of queue or recursive stack
// Was able to run in LeetCode = yes

import java.util.*;

public class RemoveInvalidParentheses {
}

class RemoveInvalidParenthesesBFS {
    HashSet<String> set;
    List<String> result;

    //bfs
    public List<String> removeInvalidParentheses(String s) {
        if(s == null || s.length() == 0){
            return new ArrayList<>();
        }

        set = new HashSet<>();
        result = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        q.add(s);
        boolean flag = false;

        //start bfs
        while(!q.isEmpty() && !flag){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String curr = q.poll();
                if(isValid(curr)){
                    result.add(curr);
                    flag = true;
                }else if(flag == false){
                    for(int j = 0; j < curr.length(); j++){
                        if(curr.charAt(j) >= 'a' && curr.charAt(j) <= 'z'){
                            continue;
                        }
                        String baby = curr.substring(0, j) + curr.substring(j+1);
                        if(!set.contains(baby)){
                            set.add(baby);
                            q.add(baby);
                        }

                    }
                }
            }
        }

        return result;

    }

    private boolean isValid(String s){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                count++;
            }else if(c == ')'){
                count--;
                if(count < 0){
                    return false;
                }
            }
        }

        return count == 0;
    }
}

class RemoveInvalidParenthesesDFS {
    HashSet<String> set;
    List<String> result;
    int max;

    //dfs
    public List<String> removeInvalidParentheses(String s) {
        if(s == null || s.length() == 0){
            return new ArrayList<>();
        }

        set = new HashSet<>();
        result = new ArrayList<>();

        dfs(s);

        return result;

    }

    private void dfs(String s){
        //base

        //logic
        if(isValid(s)){
            if(s.length() > max){
                max = s.length();
                result = new ArrayList<>();
                result.add(s);
            }else if(s.length() == max){
                result.add(s);
            }
        }else{
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                    continue;
                }
                String baby = s.substring(0, i) + s.substring(i+1);
                if(!set.contains(baby)){
                    set.add(baby);
                    dfs(baby);
                }
            }
        }
    }

    private boolean isValid(String s){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                count++;
            }else if(c == ')'){
                count--;
                if(count < 0){
                    return false;
                }
            }
        }

        return count == 0;
    }
}
