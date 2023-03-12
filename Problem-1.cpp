301. Remove Invalid Parentheses

/*
//DFS
TC O(n^n)
SC O(n)

class Solution {
    vector<string> result;
    unordered_set<string> set;
    int max = 0;

public:
    
    vector<string> removeInvalidParentheses(string s) {
        int n = s.size();
        if (n==0) return {};

        dfs(s);
        return result;
    }
    void dfs(string s) {
        if (s.size() < max) return;
        
        if (isValid(s)) {
            if(s.size() > max) {
                result.clear();
            }
            result.push_back(s);
            max = s.size();
        }

        for(int i=0; i< s.size(); i++) {
            char c = s.at(i);
            if ((c != '(') && (c != ')'))  continue;
            string child = s.substr(0,i) + s.substr(i+1);
            if (set.find(child) == set.end()) {
                set.insert(child);
                dfs(child);
            }
        }

    }

    bool isValid(string s) {
        int count = 0;
        for (int i=0; i<s.size(); i++){
            char c = s.at(i);
            if ((c != '(') && (c != ')'))  continue;
            if (c == '(') count ++;
            else {
                if (count == 0) return false;
                count --;
            }
        }
        return (count == 0);
    }
};

*/

//BFS
class Solution {

public:
    vector<string> removeInvalidParentheses(string s) {
        int n = s.size();
        if (n==0) return {};
        vector<string> result;
        unordered_set<string> set;
       
        queue<string> q;

        if (isValid(s)) {
            result.push_back(s);
            return result;
        }
        q.push(s);
        set.insert(s);
        bool flag = false;

        while(!q.empty() && (!flag)) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                string curr = q.front();
                q.pop();     
                if (isValid(curr)) { // dont check its substring if curr is already valid.
                                    // dont need to check substrings of other childs in lower level also.
                    result.push_back(curr);
                    flag = true;

                }
                if (!flag) {
                    for (int j=0; j< curr.size(); j++) {           
                        string child = curr.substr(0,j) +curr.substr(j+1);
                        if(set.find(child) == set.end()) {
                                set.insert(child);
                                q.push(child);
                        }
                    }                    

                }

            }
        }

        return result;
    }
    bool isValid(string s) {
        int count = 0;
        for (int i=0; i<s.size(); i++){
            char c = s.at(i);
            if ((c != '(') && (c != ')'))  continue;
            if (c == '(') count ++;
            else {
                if (count == 0) return false;
                count --;
            }
        }
        return (count == 0);
    }
};
