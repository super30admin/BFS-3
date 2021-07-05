/*Intuition: Try to remove the bracket at each an every index. Be exhaustive. Use BFS so that we can find the answer at the topmost level.
Time: O(N^N)
Space: O(N^N)
*/

class Solution {
public:
    vector<string> removeInvalidParentheses(string s) {
        vector<string> result;
        queue<string>queue;
        queue.push(s);
        set<string>visited;
        bool flag = false;
        visited.insert(s);
        while ( queue.size() != 0){
            
            int size = queue.size();
            for ( int i = 0; i < size; i++){
            
                
                auto currString = queue.front();
                queue.pop();
                
                if ( isValid(currString)){
                    flag = true;
                    result.push_back(currString);
                
                }
                if ( flag == false){
                
                
                    for ( int k = 0; k < currString.size(); k++){
                        if ( isalpha(currString[k])) continue;
                        string newString = currString.substr(0,k) + currString.substr(k+1);
                        if ( visited.find(newString) == visited.end()){
                            queue.push(newString);
                            visited.insert(newString);
                        }

                    }
                }
                
            
            
            }
        
        }
        return result;
        
        
    }
    bool isValid(string s){
        int count = 0;
        for ( int i = 0; i < s.size(); i++){
            if ( s[i] == ')'){
                if ( count == 0) return false;
                count--;
            
            }
            else if(s[i] == '('){
                count++;
            }
        }
        return count == 0;
    
    }
};