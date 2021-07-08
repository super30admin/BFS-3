// Time Complexity : O(V + E)
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * // Definition for a Node.
 * function Node(val, neighbors) {
 *    this.val = val === undefined ? 0 : val;
 *    this.neighbors = neighbors === undefined ? [] : neighbors;
 * };
 */

/**
 * @param {Node} node
 * @return {Node}
 */
var cloneGraph = function(node) {
    if (!node) return node;
    
    const store = new Map();
    const q = [node];

    let cloneNode = new Node(node.val);
    store.set(node.val, cloneNode);

    while (q.length > 0) {
        const current = q.shift();
        let cloneCurrent = store.get(current.val);
        
        for (const neighbor of current.neighbors) {
            let cloneNeighbor = store.get(neighbor.val);
            if (!cloneNeighbor) {
                cloneNeighbor = new Node(neighbor.val);
                store.set(neighbor.val, cloneNeighbor);
                q.push(neighbor);
            }

            cloneCurrent.neighbors.push(cloneNeighbor);
        }
    }

    return cloneNode;
};
