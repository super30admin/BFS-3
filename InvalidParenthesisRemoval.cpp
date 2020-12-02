class Solution {
public:
    
    bool isparen(char c)
    {
        return (c=='(')||(c==')');
    }
    bool isvalid(string s)
    {
        int count=0;
        
        for(auto x:s)
        {
            if(x=='(')
                count++;
            if(x==')')
                count--;
            
            if(count<0)
            {
                return false;
            }
        }
        return (count==0);
           
    }
    vector<string> removeInvalidParentheses(string s) {
        
        unordered_set<string> sets;
        queue<string> q;
        bool level=false;
        vector<string> answer;
        q.push(s);
        sets.insert(s);
        while(!q.empty())
        {
            s=q.front();
            
            q.pop();
            
            if(isvalid(s))
            {
                //cout<<s<<" "<<endl;
                answer.push_back(s);
                level=true;
            }
            
            if(level==true)
                continue;
            
            for(int i=0;i<s.length();i++)
            {
                if(isparen(s[i])==false)
                continue;
                    
                string n=s.substr(0,i)+s.substr(i+1);
                if(sets.find(n)==sets.end())
                {
                    sets.insert(n);
                    q.push(n);
                }
            }
        }
        
        if(answer.empty())
            answer.push_back("");
        
        return answer;
    }
};