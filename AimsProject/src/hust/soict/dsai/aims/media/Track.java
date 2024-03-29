package hust.soict.dsai.aims.media;
import java.lang.Object;

import hust.soict.dsai.aims.exception.PlayerException;
public class Track implements Playable{
    private String title;
    private int length;
    public String getTitle(){
        return title;
    }
    public int getLength(){
        return length;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setLength(int length){
        this.length = length;
    }

    public Track(String title, int length){
        this.title=title;
        this.length=length;
    }
    @Override
    public void play() throws PlayerException{
        if (this.length > 0){
            System.out.println("Playing track: " + title);
            System.out.println("Track length: " + length);
        }
        else{
            throw new PlayerException("ERROR: DVD length is not positive!");
        }
        
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof Track){
            Track that = (Track) o;
            return this.title == that.title && this.length == that.length;
        }
        else{
            return false;
        }
    }
}
