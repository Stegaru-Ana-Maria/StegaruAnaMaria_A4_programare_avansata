import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Document {
    private String id;
    private String title;
    private String location;
    Map<String,Object> tags = new HashMap<>();

    public Document() {

    }

    public Document(String id) {
        this.id = id;
    }
    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Document{" + "id=" + id + ", title=" + title + ", location=" + location + '}';
    }

}
