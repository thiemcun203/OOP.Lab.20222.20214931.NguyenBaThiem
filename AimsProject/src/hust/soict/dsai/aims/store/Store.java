package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;
public class Store {
    public static void main(String[] args){

    }
    
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    public  void addMedia(Media item){
        itemsInStore.add(item);
    }
    public  void removeMedia(Media item) {
        itemsInStore.remove(item);
    }
    
    public void print(){
        System.out.println("***********************STORE***********************");
        System.out.println("Ordered Items:");

        for (Media item: itemsInStore) {
            
            System.out.println(Integer.toString(item.id)+". "+ "DVD - "+item.getTitle()+" - "+item.getCategory()+" - "+item.getDirector()+" - "+item.getLength()+":"+" "+Float.toString(item.getCost())+" $");

        }
        System.out.println("***************************************************");
    }

}
