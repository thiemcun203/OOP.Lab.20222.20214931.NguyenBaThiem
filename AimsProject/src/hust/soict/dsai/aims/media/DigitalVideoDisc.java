package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    private String director;
    private int length;
    
    public DigitalVideoDisc(String title){
        super(title);
    }
    public DigitalVideoDisc(String title,String category, float cost){
        super(title,category,cost);
    }
    public DigitalVideoDisc(String title,String category,String director, float cost){
        super(title, category, cost);
        this.director = director;
    }
    public DigitalVideoDisc(String title,String category,String director, int length, float cost){
        super(title, category,cost,length, director);
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + getTitle());
        System.out.println("DVD length: " + getLength());
    }
    public static void main(String[] args) {
        // code to execute when the program is run
        System.out.println("Hello, world!");
    }

}

