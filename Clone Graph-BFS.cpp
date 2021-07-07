//Time Complexity-O(n)-->'n' is number of nodes in the graph
//Space Complexity-O(n)+O(n)-->queue+hashmap(Auxiliary Data Strcutures)
//Did the code execute on Leetcode? Yes

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

class Solution {
public:
    Node* cloneGraph(Node* node) {
        if(node==NULL)
        {
            return NULL;
        }
        unordered_map<int,Node*>res;
        queue<Node*>m;
        Node* b=new Node(node->val,vector<Node*>());
        res[node->val]=b;
        m.push(node);
        while(!m.empty())
        {
            Node *temp=m.front();
            m.pop();
            for(int i=0;i<temp->neighbors.size();i++)
            {
                if(res.find(temp->neighbors[i]->val)==res.end())
                {
                    Node* a=new Node(temp->neighbors[i]->val,vector<Node*>());
                    res[temp->neighbors[i]->val]=a;
                    m.push(temp->neighbors[i]);
                }
                res[temp->val]->neighbors.push_back(res[temp->neighbors[i]->val]);
            }
        }
        return b;
    }
};