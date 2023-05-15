package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
    public static void main(String[] args){

    }
    private int qtyItems = 0;
    public static final int MAX_ITEMS =50;
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_ITEMS];
    public  void addDVD(DigitalVideoDisc dics){
        itemsInStore[qtyItems]=dics;
        qtyItems +=1;
    }
    public  void removeDVD(DigitalVideoDisc disc) {
        int index = -1;
        for (int i = 0; i < qtyItems; i++) {
            if (itemsInStore[i].equals(disc)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < qtyItems - 1; i++) {
                itemsInStore[i] = itemsInStore[i + 1];
            }
            qtyItems--;
            itemsInStore[qtyItems] = null;
        }
    }
    
    public void print(){
        System.out.println("***********************STORE***********************");
        System.out.println("Ordered Items:");

        for (int i = 0; i < qtyItems; i++) {
            DigitalVideoDisc dvd = itemsInStore[i];
            System.out.println(Integer.toString(dvd.id)+". "+ "DVD - "+dvd.getTitle()+" - "+dvd.getCategory()+" - "+dvd.getDirector()+" - "+dvd.getLength()+":"+" "+Float.toString(dvd.getCost())+" $");

        }
        System.out.println("***************************************************");
    }

}
