// https://leetcode.com/problems/remove-invalid-parentheses/description/

// Time Complexity: O(n*2^n)
// Space Complexity: O(n*2^n)


class Solution {
    public:
        bool isValid(string s){
            int cnt=0;
            for(auto i : s){
                if(i == '(') cnt++;
                else if(i == ')'){
                    if(cnt == 0) return false;
                    cnt--;
                }
            }
            return cnt == 0;
        }
        vector<string> removeInvalidParentheses(string s) {
            vector<string> ans;
            unordered_set<string> mp;
            queue<string> q;
            q.push(s);
            mp.insert(s);
            bool flag = false;
            while(!q.empty()){
                string res = q.front(); q.pop();
                if(isValid(res)){
                    ans.push_back(res);
                    flag = true;
                } 
                if(flag) continue;
                for(int i=0; i<res.size(); i++){
                    if(res[i] != '(' && res[i] != ')') continue;
                    string next = res.substr(0,i) + res.substr(i+1);
                    if(mp.find(next) == mp.end()){
                        mp.insert(next);
                        q.push(next);
                    } 
                }
            }
            return ans;
        }
    };