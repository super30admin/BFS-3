/**
Intuition:
Traverse the graph using "BFS" and maintain a map from each original node to its cloned node to avoid recreating nodes.
When visiting a node, create its clone if it doesn’t exist and connect it to the clones of its neighbors.
The map ensures every node is cloned once and correctly preserves all neighbor relationships in the new graph.
T.C: O(v+e)
S.C: O(v)
 */
var cloneGraph = function (node) {
    if (!node) return null;
    let queue = [node];
    let map = new Map();

    // helps in removing duplicate code
    const clone = (node) => {
        if (map.has(node)) return map.get(node);
        let nodeCopy = new _Node(node.val);
        map.set(node, nodeCopy);
        return nodeCopy;
    }
    while (queue.length) {
        let currNode = queue.shift();
        let nodeCopy = clone(currNode);

        for (let neighbor of currNode.neighbors) {
            let neighborCopy;
            if (!map.has(neighbor)) {
                queue.push(neighbor);
            }
            nodeCopy.neighbors.push(clone(neighbor));
        }
    }

    return map.get(node);
};