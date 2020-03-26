//Time Complexity-O(n)-->'n' is number of nodes
//Space Complexity-O(1) if recursive stack space is not considered or else it is O(n)
//Did the code execute on Leetcode? yes

// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> neighbors;
    
    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }
    
    Node(int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }
    
    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
public:
    void dfs(Node *node,unordered_map<int,Node*>&res)
    {
        if(res.find(node->val)!=res.end())
        {
            return;
        }
        Node* temp=new Node(node->val,vector<Node*>());
        res[node->val]=temp;
        for(int i=0;i<node->neighbors.size();i++)
        {
            dfs(node->neighbors[i],res);
            res[node->val]->neighbors.push_back(res[node->neighbors[i]->val]);
        }
    }
    
    Node* cloneGraph(Node* node) {
        if(node==NULL)
        {
            return NULL;
        }
        unordered_map<int,Node*>res;
        dfs(node,res);
        return res[node->val];
    }
};