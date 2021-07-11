// Time Complexity :O(2^n) where n in the number elements in the vector
// Space Complexity : O(N) space taken by queue and set.  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    vector<string> removeInvalidParentheses(string s) {
        queue<string> q;
        set<string> hSet;
        bool flag = false;
        q.push(s);
        hSet.insert(s);
        vector<string> ans;
        while(!q.empty() && !flag){
            int size = q.size();
            for(int j = 0; j <size;j++){
                string curr = q.front();
                q.pop();
                if(isValid(curr)){
                    flag = true;
                    ans.push_back(curr);
                }
                if(!flag){
                    for(int i = 0 ; i < curr.length();i++){
                        //if(isalpha(curr[i])) continue;
                        string newStr = curr.substr(0,i) + curr.substr(i+1);
                        if(!hSet.count(newStr)){
                            hSet.insert(newStr);
                            q.push(newStr);
                        }
                    }
                }
            }
        }
        return ans;
    }
    int isValid(string curr){
        int count = 0;
        int paranth = 0;
        for(int i = 0;i< curr.length();i++){
            if(curr[i] == ')'){
                if(count == 0) return -1;
                paranth++;
            }
            else if (curr[i] == '('){
                count++;
            }
        }
        return paranth;
    }
};