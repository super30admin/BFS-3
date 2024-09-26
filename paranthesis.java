import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class Solution {

    public List<String> removeInvalidParentheses(String s) {

        List<String> result = new ArrayList<>();

        if(s==null) return result;

        HashSet<String> set = new HashSet<>();

        Queue<String> q = new LinkedList<>();

        boolean found = false;

        

        set.add(s);

        q.add(s);

        

        while(!q.isEmpty()){

            s = q.poll();

            if(isValid(s)){

                result.add(s);

                found=true;

            }

            if(!found){

                for(int i=0; i<s.length(); i++){

                    if(Character.isLetter(s.charAt(i)))continue;

                    String t = s.substring(0,i)+s.substring(i+1);

                    if(!set.contains(t))

                    {

                        set.add(t);

                        q.add(t);

                    }

                }

            }

        }

        return result;

    }

    public boolean isValid(String s){

        int count = 0;

        for(int i=0; i<s.length(); i++){

            char  c = s.charAt(i);

            if(c == '(') count++;

            if(c == ')'){

                if(count==0)return false;

                count--;

            }

        }

        return count==0;

    }

}