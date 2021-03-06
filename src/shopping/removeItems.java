/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping;

import java.util.ArrayList;


/**
 *
 * @author edgardpacheco
 */
public class removeItems extends ShoppingBag {
    
    
     public static void removeItem (ArrayList<inBag> itemRemove) { // remove items
  
     // printing the instruction for users to delete items or finish the shopping   
     System.out.println("To remove Items from your Shopping Bag follow the options below:");
     System.out.println("#1 - DELETE SINGLE ITEM: choose by ID");
     System.out.println("#2 - DELETE ALL ITEM TYPE: all");
     System.out.println("#3 - FINISH YOUR SHOPPING TYPE: pay");
     
     intInput = sc.readInteger(error); // getting users input
     deleteOption = sc.strInput; // setting users input to variable deleteOption 
     
     if (deleteOption.contains("all")){ // if user want to delete all the items in the bag   
         itemRemove.clear(); // delete all the items in the bag
         System.out.println("\n## You choose delete aLl, Now your bag is empty");
         System.exit(0);// stop the program
     } 
     else if (deleteOption.contains("pay")){ // if user wants to finish, print final bag and finish the program
         printFinalBag(itemRemove);
         System.exit(0);// stop the program
 
     } else{ // if user wants to delete single item
       
             while (!deleteOption.contains("pay" ) || !deleteOption.contains("all") )  { // checking if user wants to leave or keeping deleting
                 
            // checking if the user input is greater than 0 and Less than ArrayList size
             while (intInput >= itemRemove.size() || intInput < 0){ // check if the input is on the range of the Arraylist size
                // Message error after a wrong input 
                System.out.println("\n## ERROR! ## - choose a number between 0 to " + (itemRemove.size() -1) );
                intInput = sc.readInteger( error); // getting next input
             }

            int idRemove =  intInput; // setting the user input to idRemove to remove the item 

            if (itemRemove.size() == 1){ // checking if there just one item in the bag. if it is true run the code below and finish the program 
                
                System.out.println("\nYou removed the last item in your bag: " ); // Message 'last item was successfully deleted
                itemRemove.remove(idRemove); // remove the last item
                System.out.println("Now your bag is empty \nTHANK YOU FOR YOUR VISIT =]\n");
                System.exit(0); // stop the program
            
            }
            else if (deleteOption.contains("pay")) { // if user chooses finish type "pay"
            printBag(itemRemove, 2);
            }
            else
            {
            System.out.println("\nYou have removed " + itemRemove.get(idRemove).getName().trim()); // Message that item was successfully deleted
            itemRemove.remove(idRemove);

            printBag(itemRemove, 2);

            }
        } // end
         
       }      
             
        if (intInput > 0) {
        printFinalBag(itemRemove); 
        }     
                
    }// remove Items  
    
}