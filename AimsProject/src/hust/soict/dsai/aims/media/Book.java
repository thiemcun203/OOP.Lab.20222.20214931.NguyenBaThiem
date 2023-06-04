package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.Iterator;
public class Book extends Media{
    private ArrayList<String> authors = new ArrayList<String>();
    public void setAuthors(ArrayList<String> authors){
        this.authors=authors;
    }
    public ArrayList<String> getAuthors(){
        return authors;
    }
    public Book(String title, String category, float cost){
        super(title,category,cost);
        
    }
    public Book(String title, String category, float cost, ArrayList<String> authors){
        super(title,category,cost);
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
