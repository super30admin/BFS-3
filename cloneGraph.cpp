/*Intuition: Create a map of the new deep copy nodes, so that we dont loose reference to it.
Time: O(V+E)
Space: O(V)
*/

//DFS
class Solution {
public:
    map<Node*, Node*> map;
    Node* cloneGraph(Node* node) {
        if ( node == NULL) return NULL;
        dfs(node);
        return map[node];
    }
    
    void dfs(Node* node){
        if( map.find(node) != map.end()) return;
        if ( map.find(node) == map.end()){
            
            Node* newNode = new Node(node->val);
            map[node] = newNode;
        
        }
        for ( auto neighbor: node->neighbors){
            
            dfs(neighbor);
            map[node]->neighbors.push_back(map[neighbor]);
        
        
        }
        
    }
    
};

//BFS
class Solution {
public:
    Node* cloneGraph(Node* node) {
        if ( node == NULL) return node;
        queue<Node*> queue;
        map<Node*, Node*> visited;
        queue.push(node);
        Node* copyNode = new Node(node->val);
        Node* copyHead = copyNode;
        visited.insert({node, copyNode});
        
        while(queue.size()!=0){
            auto currentNode = queue.front();
            queue.pop();
            
            for ( auto neighbor: currentNode->neighbors){
                if ( visited.find(neighbor) == visited.end() ){
                    auto copyNeighbour = new Node(neighbor->val);     
                    visited.insert({neighbor, copyNeighbour}); 
                    queue.push(neighbor);
                }
                visited[currentNode]->neighbors.push_back(visited[neighbor]);
                
            }
        }
        return copyHead;
    }
};