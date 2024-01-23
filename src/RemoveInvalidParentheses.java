// Time Complexity:  O(n)
// Space Complexity: O(n)

// ******************** BFS Approach ********************

class Solution {

    public List<String> removeInvalidParentheses(String s) {

        List<String> ans = new ArrayList<>();

        if(s==null || s.length()==0) 
            return ans;

        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        boolean flag = false;

        queue.add(s);                                                         // starting with given string
        set.add(s);

        while(!queue.isEmpty() && !flag) {                                    // take strings from queue if flag false
            int size = queue.size();                                          // so that we do not go to next layer
            while(size-- > 0) {
                String str = queue.poll();                                    // getting strings from queue
                if(isValid(str)) {                                         // if valid
                    ans.add(str);                                          // add in ans
                    flag = true;                                              // turn flag true
                }
                for(int i=0; i<str.length(); i++) {                           // getting substrings from them
                    if(Character.isLetter(str.charAt(i))) 
                        continue;
                    String newStr = str.substring(0, i) + str.substring(i+1, str.length());
                    if(!set.contains(newStr)) {                               // add in queue, set if not
                        queue.add(newStr);
                        set.add(newStr);
                    }
                }
                // // ***** a litle optimized which ain't needed *****
                // else {
                //     if(!flag) {
                //         for(int i=0; i<str.length(); i++) {                           // getting substrings from them
                //             if(Character.isLetter(str.charAt(i))) 
                //                 continue;
                //             String newStr = str.substring(0, i) + str.substring(i+1, str.length());
                //             if(!set.contains(newStr)) {                               // add in queue, set if not
                //                 queue.add(newStr);
                //                 set.add(newStr);
                //             }
                //         }       
                //     }
                // }
            }
        }

        return ans;
        
    }

    private boolean isValid(String str) {
        int count = 0;
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(Character.isLetter(ch)) {
                continue;
            }
            if(ch == '(') {
                count++;
            }
            else if(ch == ')') {
                if(count == 0) 
                    return false;
                else 
                    count--;
            }
        }
        System.out.println(count);
        return count==0;
    }

}









// // Time Complexity:  O(n!)
// // Space Complexity: O(n!)

// // ******************** DFS Approach ********************

// class Solution {

//     List<String> ans;
//     Set<String> set;
//     int max;

//     public List<String> removeInvalidParentheses(String s) {

//         ans = new ArrayList<>();
        
//         if(s==null || s.length()==0) 
//             return ans;

//         set = new HashSet<>();
//         dfs(s);                                          // calling out dfs
//         return ans;
        
//     }

//     private void dfs(String str) {

//         if(set.contains(str))                            // if str already there in set
//             return;
//         if(str.length() < max)                           // or str shorter than max length valid one
//             return;                                      // then stop for that

//         set.add(str);                                    // else add in set

//         if(isValid(str)) {                               // if it is valid
//             if(str.length() > max) {                     // for str longer than max length valid one
//                 ans = new ArrayList<>();                 // get new list
//                 max = str.length();                      // update max length
//             }
//             ans.add(str);                                // add str in ans if valid
//         }
//         else {                                           // if invalid
//             for(int i=0; i<str.length(); i++) {
//                 if(Character.isLetter(str.charAt(i)))
//                     continue;
//                 String newStr = str.substring(0, i) + str.substring(i+1, str.length());
//                 dfs(newStr);                             // dfs for all substrings
//             }
//         }

//     }

//     private boolean isValid(String str) {
//         int count = 0;
//         for(int i=0; i<str.length(); i++) {
//             char ch = str.charAt(i);
//             if(Character.isLetter(ch)) {
//                 continue;
//             }
//             if(ch == '(') {
//                 count++;
//             }
//             else if(ch == ')') {
//                 if(count == 0) 
//                     return false;
//                 else 
//                     count--;
//             }
//         }
//         return count==0;
//     }

// }
