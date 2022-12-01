// Problem2 Clone graph (https://leetcode.com/problems/clone-graph/)

// Time Complexity : O(V+E)
// Space Complexity : O(V)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/**
 * // Definition for a Node.
 * function Node(val, neighbors) {
 *    this.val = val === undefined ? 0 : val;
 *    this.neighbors = neighbors === undefined ? [] : neighbors;
 * };
 */
let map;

var clone = (node) => {
    if (map.has(node)) {
        return map.get(node);
    }
    let newNode = new Node(node.val);
    map.set(node, newNode);
    return newNode;
}

var dfs = (node) => {
    // base case
    if (map.has(node))
        return;
    // logic
    clone(node);
    for (let i = 0; i < node.neighbors.length; i++) {
        let neighbor = node.neighbors[i];
        dfs(neighbor);
        map.get(node).neighbors.push(map.get(neighbor));
    }
}

/**
 * @param {Node} node
 * @return {Node}
 */
var cloneGraph = function (node) {
    if (node === null)
        return node;
    map = new Map();
    dfs(node);
    return map.get(node);
    // let rootNode = clone(node);
    // let queue = [];
    // queue.push(node);
    // while(queue.length > 0){
    //     let curr = queue.shift(); 
    //     for(let i=0; i<curr.neighbors.length; i++){
    //         let neighbor = curr.neighbors[i];
    //         if(!map.has(neighbor)){
    //             queue.push(neighbor);
    //         }
    //         let newNode = clone(neighbor);
    //         map.get(curr).neighbors.push(newNode);
    //     }
    // }
    // return rootNode;
};
