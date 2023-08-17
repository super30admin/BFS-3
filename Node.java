import java.util.LinkedList;
import java.util.List;
public class Node {

    int val;
    List<Node> neighbors;

    public Node() {

        this.val = 0;
        this.neighbors = new LinkedList<>();
    }

    public Node(int val) {

        this.val = val;
        this.neighbors = new LinkedList<>();
    }

    public Node(int val, List<Node> neighbors) {

        this.val = val;
        this.neighbors = neighbors;
    }

}

