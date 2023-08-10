/*
// Time Complexity : O(N^N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
Go through the string if found in the given level make flag as true and check all the string in that level
If not found push all the substring combinations where elements at every index is removed at each instance
it into queue and repeat the process
*/

//BFS solution

#include<iostream>
#include<vector>
#include<unordered_set>
#include<queue>

using namespace std;

class Solution {
    bool valid_thesis(string& s){
        int cnt{};
        for(char& c:s){
            if(c == '('){
                cnt++;
            }
            else if(c == ')'){
                if(cnt == 0) return false;
                cnt--;
            }
        }
        return cnt==0;
    }

    string gg_substr(const string& s,int key){
        int sz = s.size();
        string res{};
        for(int i{};i<sz;++i){
            if(i!=key) res.push_back(s.at(i));
        }
        return res;
    }
public:
    vector<string> removeInvalidParentheses(string s) {
        int cnt{};
        vector<string> res{};
        bool flag{false};
        unordered_set<string> uset{};
        queue<string> q{};
        q.push(s);
        while(!q.empty() && !flag){
            int sz = q.size();
            for(int j{};j<sz;j++){
                string gg = q.front();
                //cout<<gg<<" ";
                q.pop();
                if(uset.find(gg) == uset.end()){
                    if(valid_thesis(gg)){
                        //cout<<"kuch success ";
                        res.push_back(gg);
                        flag = true;
                    }
                    else{
                        if(!flag){
                            for(int i{};i<gg.size();++i){
                                string kk = gg_substr(gg,i);
                                q.push(kk);
                            }
                        }
                    }
                    uset.insert(gg);
                }
            }
            //cout<<endl;
        }
        return res;
    }
};

//dfs solution 

class Solution {
    bool valid_thesis(string& s){
        int cnt{};
        for(char& c:s){
            if(c == '('){
                cnt++;
            }
            else if(c == ')'){
                if(cnt == 0) return false;
                cnt--;
            }
        }
        return cnt==0;
    }

    string gg_substr(const string& s,int key){
        int sz = s.size();
        string res{};
        for(int i{};i<sz;++i){
            if(i!=key) res.push_back(s.at(i));
        }
        return res;
    }
    unordered_set<string> uset{};
    //bool flag{false};
    int max{};
    vector<string> res{};

    void helper(string& s){
        int sz = s.size();
        if(sz < max || uset.find(s) != uset.end()) return; //base condition on maximum lenght of the substr obtained.
        uset.insert(s);
        //cout<<s<<" ";
        if(valid_thesis(s)){
            if(sz>max){
                max = sz;
                res.clear();
            }
            res.push_back(s);
            return;
        }
        //logic
        for(int i{};i<sz;++i){
            char c = s.at(i);
            if(isalpha(c)) continue;
            string child = gg_substr(s,i);
            if(uset.find(child) == uset.end()){
                helper(child);
            }
        }
    }
public:
    vector<string> removeInvalidParentheses(string s) {
        helper(s);
        return res;
    }
};
