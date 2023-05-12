// type to run: java Cart.java
package src;
import java.security.DigestInputStream;

import src.DigitalVideoDisc;
public class Cart {
    public  final int MAX_NUMBERS_ORDERED = 20;
    private  DigitalVideoDisc itemsOrdered[] = 
            new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    public  int qtyOrdered = 0;
    public  void addDigitalVideoDisc(DigitalVideoDisc dics){
        qtyOrdered +=1;
        itemsOrdered[qtyOrdered-1]=dics;

    }
    public  void addDigitalVideoDisc(DigitalVideoDisc [] dvdList){
        
        int length = dvdList.length;
        for (int i=0; i < length; i++ ){
            if (qtyOrdered <= MAX_NUMBERS_ORDERED) {
                qtyOrdered +=1;
                itemsOrdered[qtyOrdered-1]=dvdList[i];
            }
            else{

                System.out.println("Can not add");
            }

        }
    }
    // public  void addDigitalVideoDisc(DigitalVideoDisc ... dvdList){
        
    //     int length = dvdList.length;
    //     for (DigitalVideoDisc n: dvdList){
    //         if (qtyOrdered <= MAX_NUMBERS_ORDERED) {
    //             qtyOrdered +=1;
    //             itemsOrdered[qtyOrdered-1]=dvdList;
    //         }
    //         else{

    //             System.out.println("Can not add");
    //         }

    //     }
    // }
    
    public  void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2 ){
        qtyOrdered +=1;
        itemsOrdered[qtyOrdered-1]=dvd1;
        qtyOrdered +=1;
        itemsOrdered[qtyOrdered-1]=dvd2;
    }
    public  void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        int index = -1;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < qtyOrdered - 1; i++) {
                itemsOrdered[i] = itemsOrdered[i + 1];
            }
            qtyOrdered--;
            itemsOrdered[qtyOrdered] = null;
        }
    }
    public  float totalCost(){
        float totalCost =0;
        for (int i=0; i<qtyOrdered;i++){
            totalCost += itemsOrdered[i].getCost();
        
        }
        return totalCost;
    }
    public static void main(String[] args) {
        // code to execute when the program is run
        System.out.println("Hello, Thiem");
    }
    
}
