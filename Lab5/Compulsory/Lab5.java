import java.io.File;
import java.io.IOException;
public class Lab5 {
    public static void main(String[] args) throws IOException {
        Lab5 lab5 = new Lab5();
        lab5.testCreateSave();
        lab5.testLoad();

    }
    void testCreateSave()throws IOException  {
        Catalog catalog = new Catalog("MyDocuments");
        var book = new Document("article1");
        var article = new Document("book1");
        catalog.add(book);
        catalog.add(article);
        System.out.println(catalog);
        try {
            CatalogManager.save(catalog, "C:\\Users\\stega\\OneDrive\\Desktop\\catalog");
        }
        catch (IOException e){
            System.out.println("ERR save");
        }

    }
    private void testLoad() throws IOException {

            Catalog catalog = CatalogManager.load("C:\\Users\\stega\\OneDrive\\Desktop\\catalog");

    }



}
