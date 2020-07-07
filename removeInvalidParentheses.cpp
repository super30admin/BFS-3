// BFS since we need to remove min number of parentheses. We could do DFS but it will go to greater depths 
// While BFS will explore all combinations at one level before going to the next, so we would only remove min number
// Here, the level of the BFS tree represents number of chars removed from original string

// Time Complexity : Exponential
// Space Complexity : O(n) last row of formed tree would be of size n/2
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// 1. Do it similar to level order using BFS 
// 2. Here children/neighbors of a node popped from queue are all substrings produced by removing 1 char at a time
// 3. Once we find a valid string, continue for the current level since there could be more valid at same level. But exit after that level
// 4. Set is used to avoid adding same string generated through a diff combination to queue 

class Solution {
public:
    vector<string> removeInvalidParentheses(string s) {
        vector<string> result;
        if(s.size()==0)
            return {""};
        queue<string> q;
        unordered_set<string> visited;
        q.push(s);
        visited.insert(s);
        int size = 0;
        while(!q.empty()){
            size = q.size();
            if(result.size() > 0)
                break;
            for(int j=0;j<size;j++){
                string curr = q.front(); q.pop();
                if(isValid(curr))
                    result.emplace_back(curr);
                for(int i=0;i<curr.size();i++){
                    if(curr[i] != '(' && curr[i]!=')') // remove only parentheses, leave alphabets as it is 
                        continue;
                    string child = curr.substr(0,i) + curr.substr(i+1); // exclude char at index i 
                    if(visited.find(child) == visited.end()){
                        q.push(child);
                        visited.insert(child);
                    }
                }
            }
        }
        return result;
    }
    
    bool isValid(string s){
        int count = 0;
        for(auto c: s){
            if(c=='(')
                count++;
            else if(c == ')')
                count--;
            if(count<0)
                return false;
        }
        return count==0;
    }
};