package hust.soict.dsai.aims.media;

abstract class Media {
    private String title;
    private  String category;
    private float cost;
    public int id;
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

}
