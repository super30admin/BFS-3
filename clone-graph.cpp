//Time - O(num of nodes)
//Space - O(num of nodes)
class Solution {
public:
    Node* cloneGraph(Node* root) {
        if(root == NULL) return NULL;
        unordered_map<Node*, Node*> mp;
        queue<Node*> q;
        
        q.push(root);
        while(!q.empty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Node* node = q.front();q.pop();
                if(mp.find(node) == mp.end()) mp[node] = new Node(node->val);
                for(Node* n:node->neighbors){
                    if(mp.find(n) == mp.end()){
                        mp[n] = new Node(n->val);
                        mp[node]->neighbors.push_back(mp[n]);
                        q.push(n);
                    }else{
                        mp[node]->neighbors.push_back(mp[n]);
                    }
                }
            }
            
        }
        return mp[root];

    }
};