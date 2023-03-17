import java.util.Map;

public interface Node {
    String getName();
    int getId();
    Map<Node, String> getRelationships();
    int nodeImportance(Map relationships);


}
