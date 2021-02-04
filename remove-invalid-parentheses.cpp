//Time - O(2^n)
//Space - O(n)
class Solution {
public:
    vector<string> removeInvalidParentheses(string s) {
        unordered_set<string> uset;
        vector<string> ans;
        queue<string> q;
        q.push(s);
        uset.insert(s);
        
        while(!q.empty()){
            int size = q.size();
            if(ans.size()!=0) break;
            for(int i=0;i<size;i++){
                string s = q.front();q.pop();
                if(isValid(s)){
                    ans.push_back(s);
                }else if(ans.size() == 0){
                    //remove a paranthesis & check in hashset and push into queue 
                    for(int j = 0;j<s.size();j++){
                        if(s[j] == '(' || s[j] == ')'){
                            string temp = s;
                            temp.erase(temp.begin()+j);
                            //temp.erase(j,1);
                            if(uset.find(temp) == uset.end()){
                                uset.insert(temp);
                                q.push(temp);
                            }
                        }
                        
                    }
                }
                
            }
        }

        return ans;
        
    }
    
    bool isValid(string s) {
        
        stack<char> st;
        
        for(auto c:s){
            
            if(st.empty() && (c == '}' || c == ')' || c == ']')) return false;
            
            if(c == '{' || c == '[' || c == '(' ){
                st.push(c);
            }else{
                if(c == '}'){
                    if(st.top()!='{') return false;
                    st.pop();
                }else if(c == ')'){
                    if(st.top()!='(') return false;
                    st.pop();
                }else if(c == ']'){
                    if(st.top()!='[') return false;
                    st.pop();
                } 
            }
        }
        return st.empty();
    }
};