import java.util.HashMap;
import java.util.Map;

public class Company implements Node, Comparable<Company>{
    private String name;
    private int NumberofEmployees;

    private Map<Node, String> relationships = new HashMap<>();
    public Company(String name) {
        this.name = name;
    }

    public int getNumberofEmployees() {
        return NumberofEmployees;
    }

    public void setNumberofEmployees(int numberofEmployees) {
        NumberofEmployees = numberofEmployees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return 0;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", NumberofEmployees=" + NumberofEmployees +
                ", relationships=" + relationships +
                '}';
    }

    public int compareTo(Company other) {
        return this.name.compareTo(other.name);
    }

    public void addRelationship(Node node, String value) {
        relationships.put(node, value);
    }

    public Map<Node, String> getRelationships() {
        return relationships;
    }

    public int nodeImportance(Map relationships) {
        return relationships.size();
    }
}
