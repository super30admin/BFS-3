//Time Complexity- O(n)
//Space Complexity- O(n)

class Solution {
public:
    vector<string> removeInvalidParentheses(string s) {
        
        vector<string> ans;
        map<string,bool> visited;
        queue<string> q;
        q.push(s);
        int found=0;
        while(!q.empty()){
            string u=q.front();
            q.pop();
            if(visited[u]){
                continue;
            }
            visited[u]=1;
            if(isBalanced(u)){
                found=1;
                ans.push_back(u);
            }
            if(found){
                continue;
            }
            for(int i=0;i<u.size();i++){
                if(u[i]=='(' || u[i]==')'){
                    string temp=u.substr(0,i)+u.substr(i+1,u.size());
                    q.push(temp);
                }
            }
        }
        return ans;
    }
    
    bool isBalanced(string s){
        
        int cnt=0;
        for(char ch:s){
            if(ch=='('){
                cnt++;
            }
            else if(ch==')'){
                cnt--;
            }
            if(cnt<0){
                return 0;
            }
        }
        return cnt==0;
    }
};