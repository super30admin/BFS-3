
 V = number of vertices
 E = number of edges
 TC: O(V + E)
 SC: O(N)
const cloneGraph = node => {
	const map = new Map();
	const queue = [node];

	if (!node) return node;

	map.set(node, new Node(node.val));

	while (queue.length) {
		const root = queue.shift();

		for (const neighbor of root.neighbors) {
			if (!map.has(neighbor)) {
				map.set(neighbor, new Node(neighbor.val));
				queue.push(neighbor);
			}

			// add cloned neighbor to current node's neighbor array
			const neighbors = map.get(root).neighbors;
			neighbors.push(map.get(neighbor));
		}
	}

	return map.get(node);
};