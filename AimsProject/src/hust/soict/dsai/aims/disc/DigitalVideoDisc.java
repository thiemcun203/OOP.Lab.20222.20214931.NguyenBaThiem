package hust.soict.dsai.aims.disc;

public class DigitalVideoDisc {
    private String title;
    private  String category;
    private String director;
    private int length;
    private float cost;
    private static int nbDigitalvideoDiscs = 0;
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
    public String getDirector(){
        return director;
    }
    public int getLength(){
        return length;
    }
    public float getCost(){
        return cost;
    }
    public DigitalVideoDisc(String title){
        super();
        this.title =title;
        DigitalVideoDisc.nbDigitalvideoDiscs ++;
        this.id = DigitalVideoDisc.nbDigitalvideoDiscs;

    }
    public DigitalVideoDisc(String title,String category, float cost){
        super();
        this.title =title;
        this.category= category;
        this.cost=cost;
        DigitalVideoDisc.nbDigitalvideoDiscs ++;
        this.id = DigitalVideoDisc.nbDigitalvideoDiscs;

    }
    public DigitalVideoDisc(String title,String category,String director, float cost){
        super();
        this.title =title;
        this.category= category;
        this.cost=cost;
        this.director = director;
        DigitalVideoDisc.nbDigitalvideoDiscs ++;
        this.id = DigitalVideoDisc.nbDigitalvideoDiscs;

    }
    public DigitalVideoDisc(String title,String category,String director, int length, float cost){
        super();
        this.title =title;
        this.category= category;
        this.cost=cost;
        this.director = director;
        this.length = length;
        DigitalVideoDisc.nbDigitalvideoDiscs ++;
        this.id = DigitalVideoDisc.nbDigitalvideoDiscs;
    }
    
    // public static void main(String[] args){
    //     DigitalVideoDisc dvd1 = new DigitalVideoDisc();
    // }
    public static void main(String[] args) {
        // code to execute when the program is run
        System.out.println("Hello, world!");
    }

}

