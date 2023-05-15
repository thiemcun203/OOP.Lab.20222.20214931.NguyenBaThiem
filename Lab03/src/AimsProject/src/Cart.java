package AimsProject.src;
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

                System.out.println("The cart is full");
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
    public boolean search(String title){
    
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getTitle().equals(title)) {
                DigitalVideoDisc dvd = itemsOrdered[i];
                System.out.println(Integer.toString(dvd.id)+". "+ "DVD - "+dvd.getTitle()+" - "+dvd.getCategory()+" - "+dvd.getDirector()+" - "+dvd.getLength()+":"+" "+Float.toString(dvd.getCost())+" $");
                
                return true;
            } 
        }
        System.out.println("Can not find this dvd");
        return false;
    }
    public boolean search(int id){
    
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].id == id) {
                DigitalVideoDisc dvd = itemsOrdered[i];
                System.out.println(Integer.toString(dvd.id)+". "+ "DVD - "+dvd.getTitle()+" - "+dvd.getCategory()+" - "+dvd.getDirector()+" - "+dvd.getLength()+":"+" "+Float.toString(dvd.getCost())+" $");
                
                return true;
            } 
        }
        System.out.println("Can not find this dvd");
        return false;
    }
    
    public void print(){
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");

        for (int i = 0; i < qtyOrdered; i++) {
            DigitalVideoDisc dvd = itemsOrdered[i];
            System.out.println(Integer.toString(dvd.id)+". "+ "DVD - "+dvd.getTitle()+" - "+dvd.getCategory()+" - "+dvd.getDirector()+" - "+dvd.getLength()+":"+" "+Float.toString(dvd.getCost())+" $");

        }
        System.out.println("Total Cost: "+Float.toString(this.totalCost()));
        System.out.println("***************************************************");
    }
    public static void main(String[] args) {
        // code to execute when the program is run
        System.out.println("Hello, Thiem");
    }
    
}
