import java.util.ArrayList;
import java.util.List;
public class Catalog {
    private String name;
    private List<Document> docs;

    public Catalog() {
        docs=new ArrayList<>();
    }

    public Catalog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Document> getDocs() {
        return docs;
    }

    public void setDocs(List<Document> docs) {
        this.docs = docs;
    }

    public void add(Document doc) {
        docs.add(doc);
    }

    public Document findById(String id) {
        return docs.stream()
                .filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }


    @Override
    public String toString() {
        return "Catalog{" + "name=" + name + ", docs=" + docs + '}';
    }
}
