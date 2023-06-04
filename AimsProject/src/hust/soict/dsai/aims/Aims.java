package hust.soict.dsai.aims;
import java.util.Scanner;
import java.util.Collections;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;


public class Aims {
    public static void main(String[] args) {
        Store store = new Store();
        // Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        store.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        store.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        store.addMedia(dvd3);
        
        Book b1 = new Book("Digital Marketing","Science",20.00f );
        store.addMedia(b1);
        
        CompactDisc cD1 = new CompactDisc( "Spider Man into multiverse","Animation Fiction", "Thiem cun", 120, 10.00f);
        store.addMedia(cD1);
        
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Avengers", "Action", "Joss Whedon", 143, 29.99f);
        store.addMedia(dvd4);
        
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Jurassic Park", "Adventure", "Steven Spielberg", 127, 14.95f);
        store.addMedia(dvd5);
        
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("The Incredibles", "Animation", "Brad Bird", 115, 17.99f);
        store.addMedia(dvd6);
        
        Book b2 = new Book("The Great Gatsby", "Fiction", 12.99f);
        store.addMedia(b2);
        
        Book b3 = new Book("The Catcher in the Rye", "Fiction", 10.99f);
        store.addMedia(b3);
        
        CompactDisc cD2 = new CompactDisc("Taylor Swift - 1989", "Pop", "Taylor Swift", 60, 12.50f);
        store.addMedia(cD2);
        
        CompactDisc cD3 = new CompactDisc("Queen - Greatest Hits", "Rock", "Queen", 90, 15.99f);
        store.addMedia(cD3);
        
        showMenu();
    }
    private static Store store = new Store();
	private static Cart cart = new Cart();
	private static Scanner sc = new Scanner(System.in);
	
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("----------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("----------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
        int opt = sc.nextInt();
		if (opt == 1) {
			storeMenu();
		} else if (opt == 2) {
			updateStore();
		} else if (opt == 3) {
			cartMenu();
		} else if (opt == 0) {
			System.out.println("Exit successfully");
		} else {
			System.out.println("Option does not exist"); // Do not need to enter again
		}
        }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("----------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("-----------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");  
        int opt = sc.nextInt();
		if (opt == 1) {
			storeMenuOption1();;
		} else if (opt == 2) {
			storeMenuOption2();
		} else if (opt == 3) {
			storeMenuOption3();
        } else if (opt == 4) {
			cartMenu();;    
		} else if (opt == 0) {
			System.out.println("Exit successfully");
            showMenu();
		} else {
			System.out.println("Option does not exist");
		}
    }

    public static void storeMenuOption1(){
        System.out.println("Enter the title of media");
        String title = sc.nextLine();
        title =sc.nextLine();
        
        int res = -1;
		for (Media media: store.getItemsInStore()) {
			if (media.getTitle().equals(title)) {
				res = 0;
				media.toString();
				mediaDetailsMenu(media);
                break;
			}
		}
		if (res == -1) {
			System.out.println("This media is not in store. Please check your title");
			storeMenu();
		}
    }

    public static void mediaDetailsMenu(Media media) {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
        int opt = sc.nextInt();
        if (opt==1){
            cart.addMedia(media);
            System.out.println("Add successfully");
        }
        else if (opt == 2){
            if (media instanceof CompactDisc){
				CompactDisc cd = (CompactDisc) media;
				cd.play();
			} else if (media instanceof DigitalVideoDisc){
				DigitalVideoDisc dvd = (DigitalVideoDisc) media;
				dvd.play();
			} else if (media instanceof Book) {
				System.out.println("Cannot play this media as it is a book");
			}
			storeMenu();
        }
        else if (opt == 0){
            storeMenu();
        }
        else{
            System.out.println("Option does not exist");
        }
    }
    public static void storeMenuOption2(){
        System.out.println("Enter the title of media");
        String title = sc.nextLine();
        title =sc.nextLine();
        int res = -1;
		for (Media media: store.getItemsInStore()) {
			if (media.getTitle()==title) {
				res = 0;
				cart.addMedia(media);
                System.out.println("Add successfully");
                break;
			}
		}
		if (res == -1) {
			System.out.println("This media is not in store. Please check your title to add media");
			storeMenu();
		}
    }
    public static void storeMenuOption3(){
        System.out.println("Enter the title of media");
        String title = sc.next();
        int res = -1;
		for (Media media: store.getItemsInStore()) {
			if (media.getTitle().equals(title)) {
				res = 0;
			    if (media instanceof Playable) {
                    System.out.println("Cannot play this media as it is a book");
                }
                else{
                    Playable md = (Playable) media;
                    md.play();
                }
                break;
			}
            storeMenu();
		}
		if (res == -1) {
			System.out.println("This media is not in store. Please check your title to add media");
			storeMenu();
		}
    }



    public static void cartMenu() {
		cart.print();
		System.out.println("Options: ");
		System.out.println("------------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("------------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
        int opt = sc.nextInt();
 
		if (opt == 1) {
			cartMenuOpt1();
		} else if (opt == 2) {
			cartMenuOpt2();
		} else if (opt == 3) {
			cartMenuOpt3();
		} else if (opt == 4) {
			cartMenuOpt4();
		} else if (opt == 5) {
			System.out.println("An order is created");
			cart.getItemsOrdered().clear();
		} else if (opt == 0) {
			storeMenu();
		}
    }
    public static void cartMenuOpt1() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter by id");
		System.out.println("2. Filter by title");
		System.out.println("0. Back");
		
		int opt = sc.nextInt();
		if (opt == 1) {
			System.out.println("Enter id: ");
			int id = sc.nextInt();
			cart.searchId(id);
			cartMenu();
		} else if (opt == 2) {
			System.out.println("Enter title: ");
			String title = sc.next();
			title = sc.next();
			cart.searchTitle(title);
			cartMenu();
		} else if (opt == 0) {
			cartMenu();
		}
	}
	public static void cartMenuOpt2() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Sort by title");
		System.out.println("2. Sort by cost");
		System.out.println("0. Back");
		
		int opt = sc.nextInt();
		if (opt == 1) {
			Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_TITLE_COST);
			cart.print();
			cartMenu();
		} else if (opt == 2) {
			Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_COST_TITLE);
			cart.print();
			cartMenu();
		} else if (opt == 0) {
			cartMenu();
		}
	}
    public static void cartMenuOpt3() {
		System.out.println("Enter the title of the media: ");
		String mediaName = sc.next();
		mediaName = sc.next();
		int findingRes = -1;
		for (Media media: cart.getItemsOrdered()) {
			if (media.getTitle().equals(mediaName)) {
				findingRes = 0;
				cart.removeMedia(media);
			}
		}
		if (findingRes == -1) {
			System.out.println("This media is not in cart");
		}
		cartMenu();
	}
    public static void cartMenuOpt4() {
		System.out.println("Enter the title of the media: ");
		String mediaName = sc.next();
		mediaName = sc.next();
		int findingRes = -1;
		for (Media media: store.getItemsInStore()) {
			if (media.getTitle().equals(mediaName)) {
				findingRes = 0;
				if (media instanceof CompactDisc){
					CompactDisc cd = (CompactDisc) media;
					cd.play();
				} else if (media instanceof DigitalVideoDisc){
					DigitalVideoDisc dvd = (DigitalVideoDisc) media;
					dvd.play();
				} else if (media instanceof Book) {
					System.out.println("Cannot play this media as it is a book");
				}
			}
		}
		if (findingRes == -1) {
			System.out.println("This media is not in cart");
		}
		cartMenu();
	}


    public static void updateStore(){
        System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add a media to store");
		System.out.println("2. Remove a media from store");
		System.out.println("0. Back");
		
		int opt = sc.nextInt();
		if (opt == 1) {
			updateStoreOpt1();
		} else if (opt == 2) {
			updateStoreOpt2();
		} else {
			showMenu();
		}
	}
    public static void updateStoreOpt1() {
		System.out.println("Enter the title of the media: ");
		String title = sc.next();

        System.out.println("Enter the category of the media: ");
		String category = sc.next();

		System.out.println("Enter the cost of the media: ");
		float cost = sc.nextFloat();

		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Book");
		System.out.println("2. DigitalVideoDisc");
		System.out.println("3. CompactDisc");
		System.out.println("0. Back");
		
		int opt = sc.nextInt();
		if (opt == 1) {
			Book newBook =  new Book(title, category, cost);
			store.addMedia(newBook);
		} else if (opt == 2) {
			DigitalVideoDisc newDVD = new DigitalVideoDisc(title,category, cost);
			store.addMedia(newDVD);
		} else if (opt == 3) {
			CompactDisc newCD = new CompactDisc(title,category,cost);
			store.addMedia(newCD);
		}
		updateStore();
	}
    public static void updateStoreOpt2() {
		System.out.println("Enter the title of the media: ");
		String mediaName = sc.next();
		mediaName = sc.next();
		int findingRes = -1;
		for (Media media: store.getItemsInStore()) {
			if (media.getTitle().equals(mediaName)) {
				findingRes = 0;
				store.removeMedia(media);
			}
		}
		if (findingRes == -1) {
			System.out.println("This media is not in store");
		}
		updateStore();
	}
}

