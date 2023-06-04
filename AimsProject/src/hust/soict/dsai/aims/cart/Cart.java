package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.*;
import java.util.ArrayList;
public class Cart {
    private  ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    
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
    
    public void print(){
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");

        for (Media item: itemsOrdered) {
            
            System.out.println(Integer.toString(item.getId())+". "+ "DVD - "+item.getTitle()+" - "+item.getCategory()+" - "+item.getDirector()+" - "+item.getLength()+":"+" "+Float.toString(item.getCost())+" $");

        }
        System.out.println("Total Cost: "+Float.toString(this.totalCost()));
        System.out.println("***************************************************");
    }


    
    public static void main(String[] args) {
        // code to execute when the program is run
        System.out.println("Hello, Thiem");
    }
    
}








    // public boolean search(String title){
    
    //     for (int i = 0; i < qtyOrdered; i++) {
    //         if (itemsOrdered[i].getTitle().equals(title)) {
    //             DigitalVideoDisc dvd = itemsOrdered[i];
    //             System.out.println(Integer.toString(dvd.id)+". "+ "DVD - "+dvd.getTitle()+" - "+dvd.getCategory()+" - "+dvd.getDirector()+" - "+dvd.getLength()+":"+" "+Float.toString(dvd.getCost())+" $");
                
    //             return true;
    //         } 
    //     }
    //     System.out.println("Can not find this dvd");
    //     return false;
    // }
    // public boolean search(int id){
    
    //     for (int i = 0; i < qtyOrdered; i++) {
    //         if (itemsOrdered[i].id == id) {
    //             DigitalVideoDisc dvd = itemsOrdered[i];
    //             System.out.println(Integer.toString(dvd.id)+". "+ "DVD - "+dvd.getTitle()+" - "+dvd.getCategory()+" - "+dvd.getDirector()+" - "+dvd.getLength()+":"+" "+Float.toString(dvd.getCost())+" $");
                
    //             return true;
    //         } 
    //     }
    //     System.out.println("Can not find this dvd");
    //     return false;
    // }
