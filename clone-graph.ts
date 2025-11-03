/**
 * Definition for _Node.
 * class _Node {
 *     val: number
 *     neighbors: _Node[]
 *
 *     constructor(val?: number, neighbors?: _Node[]) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.neighbors = (neighbors===undefined ? [] : neighbors)
 *     }
 * }
 *
 */
// Time complexity- O(V+E)
// Space complexity- O(V)
function cloneGraph(node: _Node | null): _Node | null {
	if (node == null) return null;

	const map = new Map<_Node, _Node>();
	const q = [node];

	while (q.length > 0) {
		const curr = q.shift();
		const copyCurr = clone(curr);
		for (let ne of curr.neighbors) {
			if (!map.has(ne)) {
				q.push(ne);
			}
			copyCurr.neighbors.push(clone(ne));
		}
	}

	return map.get(node);

	function clone(node: _Node | null): _Node | null {
		if (node == null) return null;

		if (!map.has(node)) {
			const copyNode = new Node(node.val);
			map.set(node, copyNode);
		}
		return map.get(node);
	}
}
