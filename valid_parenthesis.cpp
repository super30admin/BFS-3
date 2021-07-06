// Time complexity-O(2^n)
// space complexity O(n);
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// iterating over the string
// remove each character and and to the next level as you run bfs


#include<algorithm>
#include<iostream>
#include<vector>
#include<stack>
using namespace std;

class Solution {
public:
    vector<string> removeInvalidParentheses(string s) {
        vector<string> results;bool flag=false; unordered_set<string>visited;
        queue<string>q; q.push(s); visited.insert(s);
        
        
        while(!q.empty() && !flag){
            int size= q.size();
            for(int i=0;i< size;i++){
                string curr = q.front();q.pop();
                
                if(is_valid(curr)){
                    results.push_back(curr);
                    //visited.insert(curr);
                    flag = true;
                }
                if(!flag){
                    for(int j =0;j<curr.size();j++){
                        if(isalpha(curr[j])) continue;
                        string temp = curr.substr(0,j) + curr.substr(j+1);
                        if(visited.find(temp)== visited.end()){
                            visited.insert(temp);
                            q.push(temp);
                        }
                                
                    }
                }
            }
        }
        return results;
    }
    
    bool is_valid(string s){
        int count=0;
        for( char c :s ){
            if( c==')'){
                if(count==0) return false;
                count--;
            }
            else if(c=='('){
                count++;
            }
        }
        return count==0;
    }
};
