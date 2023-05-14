package AimsProject.src;

// import DigitalVideoDisc;
public class Cart {
    public  final int MAX_NUMBERS_ORDERED = 20;
    private  DigitalVideoDisc itemsOrdered[] = 
            new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    public  int qtyOrdered = 0;
    public  void addDigitalVideoDisc(DigitalVideoDisc dics){
        qtyOrdered +=1;
        itemsOrdered[qtyOrdered-1]=dics;

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

