package hust.soict.dsai.aims.media;
import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> authors = new ArrayList<Track>();
    public CompactDisc(int id,String title, String category, String director, int length, float cost) {
        super(id, title,category,cost,length, director);
    }
    public String getArtist(){
        return artist;
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
}

