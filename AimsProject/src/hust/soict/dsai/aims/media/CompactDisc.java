package hust.soict.dsai.aims.media;
import java.util.ArrayList;

import hust.soict.dsai.aims.exception.PlayerException;

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
    public void play() throws PlayerException{
        if (this.getLength() > 0){
            java.util.Iterator iter = authors.iterator();
            Track nextTrack;
            while(iter.hasNext()){
                nextTrack = (Track) iter.next();
                try {
                    nextTrack.play();
                } catch(PlayerException e){
                    throw e;
                }
            }

        }else{
            throw new PlayerException("ERROR: DVD length is not positive!");
        }
    }


    @Override
	public String toString() {
		return ("CD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.artist+ " - "+ this.getDirector() + " - " + this.getLength() +": " + this.getCost()+"$");
	}
    public static void main(String[] agrs) throws PlayerException{
        CompactDisc cd = new CompactDisc("thiem","kinh di", "thin",-10, 30.99f);
        cd.play();
    }
}


