import java.util.HashMap;

public class CloneGraphUsingDFS {

	HashMap<Node, Node> map;

	public Node cloneGraph(Node node) {
		if (null == node)
			return null;
		map = new HashMap<Node, Node>();
		dfs(node);
		return map.get(node);
	}

	private void dfs(Node node) {
		// TODO Auto-generated method stub
		
		// base
		if (map.containsKey(node))
			return;

		
		// logic
		Node copy = new Node(node.val);
		map.put(node, copy);
		for (Node n : node.neighbors) {
			dfs(n);

			map.get(node).neighbors.add(n);
		}

	}
}
