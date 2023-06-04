package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {

    public DigitalVideoDisc(String title){
        super(title);
    }
    public DigitalVideoDisc(String title,String category, float cost){
        super(title,category,cost);
    }
    
    public DigitalVideoDisc(String title,String category,String director, int length, float cost){
        super(title, category,cost,length, director);
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + getTitle());
        System.out.println("DVD length: " + getLength());
    }
    @Override
	public String toString() {
		return ("DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() +": " + this.getCost()+"$");
	}
    public static void main(String[] args) {
        // code to execute when the program is run
        System.out.println("Hello, world!");
    }

}

