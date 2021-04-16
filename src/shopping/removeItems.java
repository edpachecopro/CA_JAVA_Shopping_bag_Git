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
  
     // print instruction to users to delete items or finish the shopping   
     System.out.println("To remove Items from your Shopping Bag follow the options below:");
     System.out.println("#1 - DELETE SINGLE ITEM: cloose by ID");
     System.out.println("#2 - DELETE ALL ITEM: type all");
     System.out.println("#3 - FINISH YOUR SHOPPING: type pay");
     
     intInput = sc.readInteger(error); // getting users input
     deleteOption = sc.strInput; // setting users input to variable deleteOption 
     
     if (deleteOption.contains("all")){ // if user want to delete all the items in the bag   
         itemRemove.clear(); // delete all the items in the bag
         System.out.println("\n## You choose delete aLl, Now your bag is empty");
     } 
     else if (deleteOption.contains("pay")){ // if user want to finish print final bag and finish the program
         printFinalBag(itemRemove);
 
     } else{ // if user want to delete single item
       
             while (!deleteOption.contains("pay" ) || !deleteOption.contains("all") )  { // checking if user want to leave or keeping deleting
                 
            // checking if the number is greater than 0 and Less than ArrayList
             while (intInput >= itemRemove.size() || intInput < 0){ // check if the input is on the range of the Arraylist size
                // Msg error after a wrong input 
                System.out.println("\n## ERROR! ## - choose a number between 0 to " + (itemRemove.size() -1) );
                intInput = sc.readInteger( error); // getting next input
             }

            int idRemove =  intInput; // setting the user input to idRemove to remove the item 

            if (itemRemove.size() == 1){ // checking if there just one item in the bag. if it is true run the code below and finish the program 
                
                System.out.println("You have removed the last item in your bad: " + itemRemove.get(idRemove)); // Msg last item was successfully deleted
                itemRemove.remove(idRemove); // remove the last item
                System.out.println("\n## Now your bag is empty \n THANK YOU FOR YOUR VISIT =]");
                deleteOption = "pay"; // set deleteOption to "pay"to finish the loop and program
            
            }
            else if (deleteOption.contains("pay")) { // if user choose finish typing "pay"
            printBag(itemRemove, 2);// check it 
            }
            else
            {
            System.out.println("\nYou have removed " + itemRemove.get(idRemove).getName().trim()); // Msg that item was successfully deleted
            itemRemove.remove(idRemove);

            printBag(itemRemove, 2);
            //System.out.println("To still removing choose another item by Id or press pay to finish your shop");
            //intInput = sc.readInteger( error1);
            }
        } // end
         
       }      
             
        if (intInput > 0) {
        printFinalBag(itemRemove); 
        }     
            
     
    }// remove Items  
    
}

