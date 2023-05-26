package hust.soict.dsai.aims.media;

abstract class Media {
    private String title;
    private  String category;
    private float cost;
    private int id;
    public String getTitle(){
        return title;
    }
    public String getCategory(){
        return category;

    }
    public void setTitle(String title){
        this.title=title;
    }
    public float getCost(){
        return cost;
    }
    // public Media(){}
    public Media(int id,String title, String category, float cost){
        this.id=id;
        this.title=title;
        this.category=category;
        this.cost=cost;
    }
    public Media(String title, String category, float cost){
        this.title=title;
        this.category=category;
        this.cost=cost;
    }
    public Media(String title){
        this.title=title;  
    }
}
