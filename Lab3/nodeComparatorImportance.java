import java.util.Comparator;

public class nodeComparatorImportance implements Comparator<Node> {
    public int compare(Node node1, Node node2) {
        return Integer.compare(node1.nodeImportance(node1.getRelationships()), node2.nodeImportance(node2.getRelationships()));
    }
}
