#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We do DFS to remove one bracket at a time and track visited strings.
Once we find a valid expression, we check if it's the longest so far.
Only the longest valid strings with the fewest deletions are kept.
*/
class Solution{
public:
    vector<string> result;
    unordered_set<string> visited;
    int maxLen = 0;
    vector<string> removeInvalidParantheses(string s){
        visited.insert(s);
        dfs(s);
        return result;
    }

    void dfs(const string& curr){
        if(curr.length() < maxLen) return;

        if(isValid(curr)){
            if(curr.length() > maxLen){
                maxLen = curr.length();
            }
            result.push_back(curr);
            return;
        }

        for(int k = 0; k < curr.length(); k++){
            if(isalpha(curr[k])) continue;
            string baby = curr.substr(0, k) + curr.substr(k+1);
            if(!visited.count(baby)){
                visited.insert(baby);
                dfs(baby);
            }
        }
    }

    bool isValid(const string& s){
        int count = 0;
        for(char c : s){
            if(isalpha(c)) continue;
            if(c == '(') count++;
            else count--;
            if(count < 0) return false;
        }
        return count == 0;
    }
};
