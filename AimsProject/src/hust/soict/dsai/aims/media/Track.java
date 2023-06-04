package hust.soict.dsai.aims.media;
import java.lang.Object;
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
    public void play() {
        System.out.println("Playing track: " + title);
        System.out.println("Track length: " + length);
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
