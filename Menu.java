package restaurant;
/**
 * Use this class to test your Menu method. 
 * This class takes in two arguments:
 * - args[0] is the menu input file
 * - args[1] is the output file
 * 
 * This class:
 * - Reads the input and output file names from args
 * - Instantiates a new RUHungry object
 * - Calls the menu() method 
 * - Sets standard output to the output and prints the restaurant
 *   to that file
 * 
 * To run: java -cp bin restaurant.Menu menu.in menu.out
 * 
 */
public class Menu {

    public static void main(String[] args) {
    
	// 1. Read input files
	// Option to hardcode these values if you don't want to use the command line arguments
	   
        String inputFile = "menu.in";
        String stockInputFile = "stock.in"; 
        String orderInputFile = "order1.in"; 
        String outputFile = "menu.out";
        String stockOutputFile = "stock.out"; 
        String orderOutputFile = "order1.out";
	
        // 2. Instantiate an RUHungry object
        RUHungry rh = new RUHungry();

	// 3. Call the menu() method to read the menu
        rh.menu(inputFile);
        rh.createStockHashTable(stockInputFile);
        rh.updatePriceAndProfit();
        Orders(orderInputFile, rh);

        
	// 4. Set output file
	// Option to remove this line if you want to print directly to the screen
        StdOut.setFile(outputFile);
        StdOut.setFile(stockOutputFile);
        StdOut.setFile(orderOutputFile);
        


	// 5. Print restaurant
        rh.printRestaurant();
    }

    public static void Orders(String inputFile, RUHungry rh) {

        StdIn.setFile(inputFile);
        int totOrders = StdIn.readInt(); 
        StdIn.readLine(); 
        for(int i = 0; i < totOrders; i++) {
                int amount = StdIn.readInt(); 
                StdIn.readChar(); 
                String name = StdIn.readLine(); 
                rh.order(name, amount); 
        }
        }
}


