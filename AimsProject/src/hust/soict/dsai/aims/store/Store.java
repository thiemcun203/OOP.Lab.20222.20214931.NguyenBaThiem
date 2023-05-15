package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
    public static void main(String[] args){

    }
    private int qtyOrdered = 0;
    public final int MAX_ITEMS =50;
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_ITEMS];
    public  void addDVD(DigitalVideoDisc dics){
        itemsInStore[qtyOrdered]=dics;
        qtyOrdered +=1;
    }
    public  void removeDVD(DigitalVideoDisc disc) {
        int index = -1;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsInStore[i].equals(disc)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < qtyOrdered - 1; i++) {
                itemsInStore[i] = itemsInStore[i + 1];
            }
            qtyOrdered--;
            itemsInStore[qtyOrdered] = null;
        }
    }
    
    public void print(){
        System.out.println("***********************STORE***********************");
        System.out.println("Ordered Items:");

        for (int i = 0; i < qtyOrdered; i++) {
            DigitalVideoDisc dvd = itemsInStore[i];
            System.out.println(Integer.toString(dvd.id)+". "+ "DVD - "+dvd.getTitle()+" - "+dvd.getCategory()+" - "+dvd.getDirector()+" - "+dvd.getLength()+":"+" "+Float.toString(dvd.getCost())+" $");

        }
        System.out.println("***************************************************");
    }

}
