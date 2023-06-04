package hust.soict.dsai.aims.media;
import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> authors = new ArrayList<Track>();
    public CompactDisc(String title, String category, String director, int length, float cost) {
        super(title,category,cost,length, director);
    }
    public CompactDisc(String title,String category, float cost){
        super(title,category,cost);
    }
    public String getArtist(){
        return artist;
    }
    public void setArtist(String artist){
        this.artist=artist;
    }
    public void setAuthors(ArrayList<Track> authors){
        this.authors=authors;
    }
    public ArrayList<Track> getAuthors(){
        return authors;
    }

    public void addTrack(Track newTrack){
        if (authors.contains(newTrack)){
            System.out.println("This track already has been in the list of tracks");
        }
        else{
            authors.add(newTrack);
        }
    }
    
    public void removeTrack(Track newTrack){
        if (!authors.contains(newTrack)){
            System.out.println("This track does not exist in the list of tracks");
        }
        else{
            authors.remove(newTrack);
        }
    }
    public int getLength(ArrayList<Track> cD) {
        int totalLength = 0;
    
        for (Track track : cD) {
            totalLength += track.getLength();
        }
    
        return totalLength;
    }
    @Override
    public void play() {
        System.out.println("Playing CompactDisc: " + getTitle());
        System.out.println("CD length: " + getLength());

        for (Track track : authors) {
            track.play();
        }
    }
    @Override
	public String toString() {
		return ("CD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.artist+ " - "+ this.getDirector() + " - " + this.getLength() +": " + this.getCost()+"$");
	}
}

