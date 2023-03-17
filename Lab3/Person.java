import java.util.HashMap;
import java.util.Map;

public class Person implements Node, Comparable<Person> {
    private String name;
    private Map<Node, String> relationships = new HashMap<>();
    private String birth_date;
    public Person(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    @Override
    public int getId() {
        return 0;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getBirth_date() {
        return birth_date;
    }
    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }
    public void addRelationship(Node node, String value) { relationships.put(node, value);
    }

    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public Map<Node, String> getRelationships() {
        return this.relationships;
    }

    @Override
    public int nodeImportance(Map relationships) {
        return relationships.size();
    }





}
