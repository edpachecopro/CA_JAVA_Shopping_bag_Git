
package shopping;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A simple ShoppingBag
 * 
 * Stores items in an ArrayList
 * 
 * Possible to add  items
 * Also can "empty" the bag
 * 
 * You should NOT need to amend this code at all!
 * 
 * @author Ken
 */

public class ShoppingBag {
    
    private ArrayList<Object> items;
    
    /**
     * Create a shopping bag by initialising the items to an empty arraylist
     */
    public ShoppingBag(){
           
        
    }
    
    
    
    public void printBag (ArrayList<inBag> myBag) { //printBag
           
           double finalPrice = 0;
            System.out.println("\n\nHere is you bag Shop:");
             System.out.println("ITEM =============QTD ===================PRICE");
           for (int i = 0; i < myBag.size(); i++ ){
  
   
            System.out.println( myBag.get(i));
            System.out.println("================================================");
                
            
            finalPrice = finalPrice + myBag.get(i).getPrice() * myBag.get(i).getqtd();
            } 
           
           System.out.println("                                    Total is: " + finalPrice );
           System.out.println("Press 0 to finish or 1 to remove Items:");
           
           
           Scanner sc = new Scanner(System.in);
           int removeItem;
           
           Scanner remove = new Scanner(sc.nextLine());
           removeItem = remove.nextInt();
           
           if (removeItem == 0){
               System.out.println("Lets go remove");
           }else{
               System.out.println("You Left");
           }
          
       
    } // printBag
    
    
    
    
    
    /**
     * Add an item to the shopping bag
     * @param someItem the item that has been bought
     */
    public void buyItem(Object someItem){
        
        this.items.add(someItem);
    }
    
 
    /**
     * create a formatted String containing all the items in the ShoppingBag
     * @return the formatted String
     * Also clears the items list
     */
    public String emptyBag(){
        
        String itemList = "";
        
        for(Object item: this.items){
            
            itemList = itemList + item.toString() + "\n";
        }
        
        this.items.clear();
        
        return itemList;
    }
}
