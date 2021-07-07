//Time Complexity-O(2^n)--->because at each point we are taking two decisions whether to consider that paricular 
//                          element in our new string or not(Basically we are trying all the combinations in worst case)
//Space Complexity-O(2^n)---> Because in the hashset we might store all different combinations in the worst case
//                            Say for Ex: if input string is ")))))(())))))". So our Hashset will contain all the unique 
//                            combinations which will be produced by eleminating each character at each level.
//                            Here 'n' is size of input string.
//Did the code execute on Leetcode? Yes

class Solution {
public:
    bool isvalid(string s)
    {
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            if(s[i]=='(')
            {
                count++;
            }
            else if(s[i]==')')
            {
                if(count==0)
                {
                    return false;
                }
                count--;
            }
            else
            {
                continue;
            }
        }
        return count==0;
    }
    
    vector<string> removeInvalidParentheses(string s) {
        vector<string>res={};
        if(s.length()==0)
        {
            res.push_back("");
            return res;
        }
        unordered_set<string>m;
        queue<string>k;
        m.insert(s);
        k.push(s);
        bool flag=false;
        while(!k.empty())
        {
            string temp=k.front();
            k.pop();
            if(isvalid(temp))
            {
                flag=true;
                res.push_back(temp);
            }
            if(flag==false)
            {
                for(int i=0;i<temp.size();i++)
                {
                    if(isalpha(temp[i]))
                    {
                        continue;
                    }
                    string a=temp.substr(0,i)+temp.substr(i+1,temp.length());
                    if(m.find(a)==m.end())
                    {
                        k.push(a);
                        m.insert(a);
                    }
                }
            }
        }
        return res;
    }
};