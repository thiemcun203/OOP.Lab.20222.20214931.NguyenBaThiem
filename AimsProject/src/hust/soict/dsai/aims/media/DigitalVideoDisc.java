package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Media {
    private String director;
    private int length;
    private static int nbDigitalvideoDiscs = 0;
    public int id;
    public String getDirector(){
        return director;
    }
    public int getLength(){
        return length;
    }

    public DigitalVideoDisc(String title){
        super(title);
        // this.title =title;
        DigitalVideoDisc.nbDigitalvideoDiscs ++;
        this.id = DigitalVideoDisc.nbDigitalvideoDiscs;

    }
    public DigitalVideoDisc(String title,String category, float cost){
        super(title,category,cost);
        // this.title =title;
        // this.category= category;
        // this.cost=cost;
        DigitalVideoDisc.nbDigitalvideoDiscs ++;
        this.id = DigitalVideoDisc.nbDigitalvideoDiscs;

    }
    public DigitalVideoDisc(String title,String category,String director, float cost){
        super(title, category, cost);
        // this.title =title;
        // this.category= category;
        // this.cost=cost;
        this.director = director;
        DigitalVideoDisc.nbDigitalvideoDiscs ++;
        this.id = DigitalVideoDisc.nbDigitalvideoDiscs;

    }
    public DigitalVideoDisc(String title,String category,String director, int length, float cost){
        DigitalVideoDisc.nbDigitalvideoDiscs ++;
        super(title, category,cost);
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

