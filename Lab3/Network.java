import java.util.ArrayList;
import java.util.List;

public class Network {

    public List<Node> nodes = new ArrayList<>();

    public Network() {
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    @Override
    public String toString() {
        return "Network{" +
                "nodes=" + nodes +
                '}';
    }
}
