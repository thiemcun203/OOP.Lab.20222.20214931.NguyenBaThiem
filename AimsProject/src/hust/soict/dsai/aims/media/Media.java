package hust.soict.dsai.aims.media;
import java.lang.Object;
public abstract class Media {
    private String title;
    private  String category;
    private float cost;
    private int id ;
    private static int nbMedia = 0;
    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getCategory(){
        return category;
    }
    public float getCost(){
        return cost;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setCost(float cost){
        this.cost=cost;
    }
    public void setCategory(String category){
        this.category=category;
    }
    public void setTitle(String title){
        this.title=title;
    }
    // public Media(int id,String title, String category, float cost){
    //     this.id=id;
    //     this.title=title;
    //     this.category=category;
    //     this.cost=cost;
    // }

    public Media(String title, String category, float cost){
        this.title=title;
        this.category=category;
        this.cost=cost;
        this.id = ++Media.nbMedia;
    }

    public Media(String title){
        this.title=title; 
        this.id = ++Media.nbMedia; 
    }
    @Override
    public boolean equals(Object o){
        if (o instanceof Media){
            Media that = (Media) o;
            return this.title == that.title;
        
        }
        else{
            return false;
        }
    }
}
