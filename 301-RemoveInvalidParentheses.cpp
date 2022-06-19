/* 
    Time Complexity                              :  O(2^N) since for every bracket we have 2 options. We can either take it or not. 
    Space Complexity                             :  dfs - O(N)
                                                    bfs - O(N)
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  

class Solution {
    int mx=INT_MIN;
    vector<string> ans;
    unordered_set<string> st;
public:
    vector<string> removeInvalidParentheses(string s) {
        // return bfs(s);
        dfs(s);
        return ans;
    }
    
    // bfs
    vector<string> bfs(string s) {
        queue<string> q;
        q.push(s);
        st.insert(s);
        
        while(!q.empty()) {
            string t = q.front();
            q.pop();
            
            if(isValid(t)) {
                int tsz = t.size();
                if(tsz < mx) {
                    continue;
                } else if(tsz > mx) {
                    mx = t.size();
                    ans.clear();
                    ans.push_back(t);
                } else {
                    ans.push_back(t);
                }
            }
            
            for(int i=0;i<t.size();i++) {
                string child = "";
                if(i>0) {
                    child = t.substr(0,i) + t.substr(i+1);
                } else if(i == 0) {
                    child = t.substr(i+1);
                }
                
                if(st.find(child) == st.end()) {
                    q.push(child);
                    st.insert(child);
                }
            }
            
        }
        
        return ans;
    }
    
    // dfs
    void dfs(string s) {
        int ssz = s.size();
        if(st.find(s) != st.end()) return;
        st.insert(s);
        if(isValid(s)) {
            if(ssz < mx) {
                return;
            } else if(ssz > mx) {
                
                mx = ssz;
                ans.clear();
                ans.push_back(s);
            } else {
                ans.push_back(s);
            }
        }
        
        for(int i=0;i<ssz;i++) {
            string child = "";
            if(i==0) {
                child = s.substr(i+1);
            } else {
                child = s.substr(0,i) + s.substr(i+1);
            }
            
            
            dfs(child);
        }
    }
    
    bool isValid(string s) {
        int n = s.size();
        int c = 0;
        for(int i=0;i<n;i++) {
            if(s[i] == '(') {
                c++;
            } if(s[i] == ')') {
                c--;
            }
            
            if(c < 0) return false;
        }
        return c == 0;
    }
};