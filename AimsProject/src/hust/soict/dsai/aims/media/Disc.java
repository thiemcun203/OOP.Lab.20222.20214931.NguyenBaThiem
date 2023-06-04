package hust.soict.dsai.aims.media;

public abstract class Disc extends Media{
    private int length;
    private String director;
    public String getDirector(){
        return director;
    }
    public int getLength(){
        return length;
    }
    public void setLength(int length){
        this.length=length;
    }
    public void setDirector(String director){
        this.director=director;
    }

    public Disc(String title){
        super(title);
    }

    // public Disc(int id, String title){
    //     super(id,title);
    // }

    public Disc(String title, String category,float cost){
        super(title,category,cost);
    }
    
    public Disc(String title,String category,float cost,int length, String director){
        super(title, category,cost);
        this.length=length;
        this.director=director;
    }
    // public Disc(int id, String title,String category,float cost,int length, String director){
    //     super(id, title, category,cost);
    //     this.length=length;
    //     this.director=director;
    // }


    
}
