package hust.soict.dsai.aims.media;

public class Disc extends Media{
    private int length;
    private String director;
    public String getDirector(){
        return director;
    }
    public int getLength(){
        return length;
    }
    
    public Disc(String title,String category,float cost,int length, String director){
        super(title, category,cost);
        this.length=length;
        this.director=director;
    }
    public Disc(int id, String title,String category,float cost,int length, String director){
        super(title, category,cost);
        this.length=length;
        this.director=director;
    }
    // public Disc(){}
}
