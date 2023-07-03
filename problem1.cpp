
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


// Time Complexity : O(2^n)
// it would be O(n!) combinations at max. but if we can see the characters in s, we only perform operations on 2 characters i.e.,('(',')');
// and at max( as per constraints) we can have 25 characters which have 2^25 combinations . and also we are using 
// a set to avoid repeated calculations.
// the worst case complexity would be (2^n) n = s.size() 
// Space Complexity :  O(n)  n = s.size();
// here we are using set to store string, because we are working on 2 characters i.e.,('(',')') , we mostly get repeated strings,
// even if we take any worst case example , we get use a space which is in proportional to size of given string only.
// so, the space would be O(n) ;
// Did this code successfully run on Leetcode : yes
// Approach : BFS 
// as we are asked to find out the answer with minimum removals, we treat removals as a level and use BFS approach to solve it optimally.
// but in worst case, it would be same as DFS.

class Solution {
public:
    vector<string> removeInvalidParentheses(string s) {
        unordered_set<string>vis;
        queue<string>q;
        q.push(s);
        vector<string>res;
        
        bool flag = false;
        int removals = 0;
        while(!q.empty())
        {
            int sz = q.size();
            while(sz--)
            {
                string curr = q.front();q.pop();
                vis.insert(curr);
                if(isValid(curr)){
                    res.push_back(curr);
                    flag = true;
                }
                else if(flag == false){
                    for(int i = 0 ;i<curr.size();i++){
                        if(islower(curr[i])) continue;
                        string p = curr.substr(0,i) + curr.substr(i+1);
                        if(vis.count(p)==0){
                            q.push(p);
                            vis.insert(p);
                        }
                    }
                }
            }
            if(flag) return res;
        }
        return res;
    }
    bool isValid(string& s){
        int cnt = 0;
        for(int i = 0;i<s.size();i++){
            char &c = s[i];
            if(c == '('){
                cnt++;
            }
            else if(c == ')'){
                cnt--;
                if(cnt<0){
                    return false;
                }
            }
        }
        return cnt==0;
    }
};

// Approach : DFS
// we cannot find the result with minimum removals, so we should do exhaustive search and take the answer with minimum removals.

// Time Complexity :O(2^n);

// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes


class Solution {
public:
    vector<string>res;
    unordered_set<string>vis;
    int mx = 0;
    vector<string> removeInvalidParentheses(string s) {
        dfs(s);
        return res;
    }
    void dfs(string &s){
        
        if(isValid(s)){
            if(mx<s.size()){
                mx = s.size();
                res.clear();
                res.push_back(s);
            }
            else if(mx == s.size()){
                res.push_back(s);
            }
        }
        
        
        vis.insert(s);
        for(int i = 0;i<s.size();i++)
        {
            if(islower(s[i])) continue;
            string p = s.substr(0,i) + s.substr(i+1);
            if(vis.count(p)==0){
                dfs(p);
            }
        }
    }
    bool isValid(string &s)
    {
        int cnt = 0;
        for(int i = 0;i<s.size();i++)
        {
            char &c = s[i];
            if(c == '('){
                cnt++;
            }
            else if(c==')'){
                cnt--;
                if(cnt<0){
                    return false;
                }
            }
        }
        return cnt==0;
    }
};