package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.Iterator;
public class Book {
    private ArrayList<String> authors = new ArrayList<>();

    public Book(){}
    public Book(int id, String title, String category, float cost, ArrayList<String> authors){
        super(id,title,category,cost);
        // this.id = id;
        // this.title = title;
        // this.category = category;
        // this.cost = cost;
        this.authors = authors;
    }
    // add new author name
    public void addAuthor(String authorName){
        this.authors.add(authorName);
    }
    // remove author name
    public void removeAuthor(String authorName){
        Iterator<String> iterator = this.authors.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            if (name.equals(authorName)) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args){
        System.out.println("done");
        // Book newbook = new Book();
    }
}
