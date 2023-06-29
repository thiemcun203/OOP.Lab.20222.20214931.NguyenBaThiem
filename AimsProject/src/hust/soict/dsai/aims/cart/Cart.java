package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {

    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public void addMedia(Media item){
        itemsOrdered.add(item);
    }
    public void removeMedia(Media item){
        itemsOrdered.remove(item);
    }
    public float totalCost(){
        float total = 0;
        for (Media item: itemsOrdered){
            total+=item.getCost();
        }
        return total;
    }
    public ObservableList<Media> getItemsOrdered(){
        return itemsOrdered;
    }
    public void print(){
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");

        for (Media item: itemsOrdered) {
            
            // System.out.println(Integer.toString(item.getId())+". "+ "DVD - "+item.getTitle()+" - "+item.getCategory()+" - "+item.getDirector()+" - "+item.getLength()+":"+" "+Float.toString(item.getCost())+" $");
            System.out.println(item.toString());
        }
        System.out.println("Total Cost: "+Float.toString(this.totalCost()));
        System.out.println("***************************************************");
    }
    public Media searchId(int id) {
		for (Media media: itemsOrdered) {
			if (media.getId() == id) {
				if (media instanceof DigitalVideoDisc) {
					DigitalVideoDisc dvd = (DigitalVideoDisc) media;
					System.out.println(dvd.toString());
					return dvd;
				} else if (media instanceof CompactDisc) {
					CompactDisc cd = (CompactDisc) media;
					System.out.println(cd.toString());
					return cd;
				} else if (media instanceof Book) {
					Book b = (Book) media;
					System.out.println(b.toString());
					return b;
				}
			}
		}
		System.out.println("No match is found");
		return null;
	}
	
	public void searchTitle(String title) {
		for (Media media: itemsOrdered) {
			if (media.getTitle().equals(title)) {
				if (media instanceof DigitalVideoDisc) {
					DigitalVideoDisc dvd = (DigitalVideoDisc) media;
					System.out.println(dvd.toString());
					return;
				} else if (media instanceof CompactDisc) {
					CompactDisc cd = (CompactDisc) media;
					System.out.println(cd.toString());
					return;
				} else if (media instanceof Book) {
					Book b = (Book) media;
					System.out.println(b.toString());
					return;
				}
			}
		}
		System.out.println("No match is found");
		return;
	}

    public static void main(String[] args) {
        // code to execute when the program is run
        System.out.println("Hello, Thiem");
    }
    
}


