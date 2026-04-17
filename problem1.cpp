// Time Complexity : O(n*2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/* This is a BFS problem, we need to find the shortest path from the given
string to a valid string
// Put the starting string in a queue and a set to keep track of visited strings
In each level, generate all possible strings by removing one parenthesis at a
time
// If a valid string is found, add it to the result and set a flag to true */

class Solution {
private:
  bool isValid(string str) {
    int count = 0;
    for (int i = 0; i < str.length(); i++) {
      if (str[i] == '(') {
        count++;
      } else if (str[i] == ')') {
        count--;
        if (count < 0)
          return false;
      }
    }
    if (count == 0)
      return true;
    return false;
  }

public:
  vector<string> removeInvalidParentheses(string s) {
    queue<string> q;
    unordered_set<string> seen;
    vector<string> res;
    q.push(s);
    seen.insert(s);
    bool flag = false;
    while (!q.empty() && !flag) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        string curr = q.front();
        q.pop();
        if (isValid(curr)) {
          res.push_back(curr);
          flag = true;
        }
        if (!flag) { // string not valid - check children
          for (int i = 0; i < curr.length(); i++) {
            char ch = curr[i];
            if (isalnum(ch))
              continue;
            string str = curr.substr(0, i) + curr.substr(i + 1);
            if (seen.find(str) == seen.end()) {
              q.push(str);
              seen.insert(str);
            }
          }
        }
      }
    }
    return res;
  }
};