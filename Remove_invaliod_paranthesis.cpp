// Remove Invalid Paranthesis
// Time Complexity: O(2^N), where N is the length of the input string.
// Space Complexity: O(N), where N is the length of the input string.
// Did this code pass the LeetCode test cases? Yes, it passed all the test cases.

// Approach:
// 1. DFs
// 2. Count the number of left and right parentheses that need to be removed.
// 3. Use a set to store the valid strings.
// 4. Use a recursive function to explore all possible strings by either removing or keeping parentheses.
// 5. Base case: If the index reaches the end of the string, check if the current path is valid and add it to the result set.
// 6. If the current character is '(', explore both options: removing it or keeping it. If it's ')', explore removing it or keeping it only if there are unmatched '('.
// 7. If it's a letter, simply add it to the path and continue.


#include <unordered_set>
#include <string>
#include <vector>
#include <queue>
using namespace std;

class Solution {
public:
    vector<string> removeInvalidParentheses(string s) {
        int leftRemove = 0, rightRemove = 0; 
        unordered_set<string> result;

        for(char c : s){
            if(c == '(') {
                leftRemove++;
            }else if(c == ')'){
                if(leftRemove > 0){
                    leftRemove--;
                }else{
                    rightRemove++;
                }
            }
        }
        dfs(s, 0, "", 0, leftRemove, rightRemove, result);

        return vector<string> (result.begin(), result.end());
    }
private: 
    void dfs(const string& s, int index, string path, int openCount, int leftRemove, int rightRemove, unordered_set<string>& result) {
        // base case
        if(index == s.size()){
            if(leftRemove == 0 && rightRemove == 0 && openCount == 0){
                result.insert(path);
            }
            return;
        }
        char c = s[index];
        if(c == '('){
            // Option 1: Remove '('
            if(leftRemove > 0) {
                dfs(s, index + 1, path, openCount, leftRemove - 1, rightRemove, result);
            }
            // Option 2: Keep '('
            dfs(s, index + 1, path + c, openCount + 1, leftRemove, rightRemove, result);
        }
        else if(c == ')'){
            // Remove )
            if(rightRemove > 0) {
                dfs(s, index + 1, path, openCount, leftRemove, rightRemove - 1, result);
            }
            // Keep ) if only matching (
            if(openCount > 0) {
                dfs(s, index + 1, path + c, openCount - 1, leftRemove, rightRemove, result);
            }
        }
        else{
            //letter
            dfs(s, index + 1, path + c, openCount, leftRemove, rightRemove, result);
        }
    }
};