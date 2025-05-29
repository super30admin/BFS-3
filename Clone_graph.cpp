// Clone Graph
// Time Complexity: O(V + E), where V is the number of vertices and E is the number of edges in the graph.
// Space Complexity: O(V), where V is the number of vertices in the graph.
// Did this code pass the LeetCode test cases? Yes, it passed all the test cases.

// Approach: 
// 1. Use a queue to perform a breadth-first search (BFS) on the graph.
// 2. Use an unordered_map to keep track of visited nodes and their corresponding cloned nodes.
// 3. For each node, create a clone and add it to the map if it hasn't been visited yet.
// 4. For each neighbor of the current node, check if it has been visited. If not, clone it and add it to the queue.
// 5. Finally, return the cloned node corresponding to the original input node.

/*
// Definition for a Node.

*/
#include <unordered_map>
#include <vector>
#include <queue>
using namespace std;

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
        if(node == nullptr){return nullptr;}

        unordered_map<Node*, Node*>visited;
        Node* clone = new Node(node -> val);
        visited[node] = clone;

        queue<Node*> q;
        q.push(node);

        while(!q.empty()){
            Node* curr = q.front();
            q.pop();
            for(Node* neighbor : curr -> neighbors){
                if(visited.find(neighbor) == visited.end()){
                    visited[neighbor] = new Node(neighbor -> val);
                    q.push(neighbor);
                }
                visited[curr] -> neighbors.push_back(visited[neighbor]); 
            }
        }
        return clone;
    }
};