import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
public class CatalogManager {
    public static void save(Catalog catalog, String path)
            throws IOException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(
                    new File(path),
                    catalog);
        } catch (IOException e) {
            System.out.println("Eroare");
        }
    }

    public static Catalog load(String path)
            throws IOException {
        Catalog catalog=new Catalog();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
             catalog = objectMapper.readValue(
                    new File(path),
                    Catalog.class);

        } catch (IOException e) {
            System.out.println("ERR load");
        }
        return catalog;
    }
}