
package shopping;

import java.util.ArrayList;
import static shopping.Shopping.printMenu;
import static shopping.removeItems.removeItem;



public class ShoppingBag  extends InputValidator { // extending class InputValidator
    

    public static void printBag (ArrayList<inBag> myBag , int firstTime) { //printBag
           
        int bagSize = myBag.size(); // initializing bagsize to the size of the bag to check if it is empty
        double finalPrice = 0; // initialilizing to 0 to use later to show the total of the bag
        
        if (bagSize != 0){ // if bagSize is not empty print the bag to user
            
           System.out.println("\n      HERE IS YOUR SHOPPING BAG:\n");
           System.out.println(" ID ---------------- AMOUNT ---- PRICE");
           
           // for loop to print the bag 
           for (int i = 0; i < myBag.size(); i++ ){
                System.out.println("[ " + i + " ]" + myBag.get(i));
                System.out.println("======================================");
            } 
           
           // printing a msg to see if user want to finish or delete something from the bag 
           
           if (firstTime == 0){
               
                System.out.println("\nPress 0 to remove Items or any number to finish your shopping:");
                int removeItem; 
                removeItem = sc.readInteger(error); // declaring removeItem to the user input
                
                if (removeItem == 0){ // if user selected remove call the method to remove Items
                    removeItem(myBag);
                }else{ // if user selected finish print the final bag and finish the program
                    printFinalBag(myBag);
                }
           
           }
           else{    
               System.out.println("\nKeep removing Items or press pay to finish your shopping:");
               removeItem(myBag);
           }
           
           
        }else // if Bag is empty,print the msg below and finish the program
        {
            System.out.println("\n###### You left the shop. ######");
            System.out.println("### We appreciate your visit ###\n");
        }
          
       
    } // end printBag
    
       public static void chooseItems (ArrayList<menu> item) { //chooseItems
        
        // printing 3 instructions to how users can buy or give up shopping
        System.out.println("\nHello there =), folow the Steps below to by on El Grito:");
        System.out.println("\n#1 - ADD ITEM TO SHOPPING BAG: cloose any Items by ID");
        System.out.println("#2 - SELECT THE AMOUNT THAT YOU WANT");
        System.out.println("#3 - TO LEAVE THE SHOP AND PAY TYPE: exit");
        System.out.println("\nPS: FREE DELIVERY FOR SHOPPING OVER €35 =]");
        
        intInput = sc.readInteger(error); // getting the first input from the user 
        
        ArrayList<inBag> mybag = new ArrayList<>(); // creating an new ArrayList object to storage the item that user will choose
        
        
        exit = sc.strInput; // leave the program in case of the user enter exit as first input
    
        while (!exit.contains("exit")) { // while user don't choose leave the program will still ask if he/she want keep buying

            // checking if the user input is greater than 0 and Less than ArrayList size and also if he/she choose leave
            while (intInput >= item.size() || intInput < 0 && !exit.contains("exit")){
                System.out.println("\n## ERROR! ## - Please choose a number betwen 0 to " + (item.size() -1) );
                intInput = sc.readInteger( error); // getting the new input after a wrong one
                
             }

            int userItem =  intInput; // getting the input from user and storege in userItem to add  the item to bag
            
            // asking how many Items they want to add to shopbag
            System.out.println("How many " + item.get(userItem).getName().trim() + " do you want to add to Shopping Bag?"); 
            intInput = sc.readInteger(error); // getting the amount for the choosen Item
            
            // creating and passing values to varible to store in new ArrayList (shooping-bag)
            amountItems =  intInput;
            itemName = item.get(userItem).getName();
            itemPrice = item.get(userItem).getPrice();
           // printing msg to users that the item was successfully added 
           System.out.println( "\nYou added " +amountItems + " " +  item.get(userItem).getName().trim() + " to your shopping Bag.\n" );
           
           printMenu(item); // printing menu again to users
           
           // Msg for users choose keep shooping or leave
           System.out.println("\nKeep shopping or type \"exit\" to leave the menu.");
           intInput = sc.readInteger(error); // getting new input 
           exit = sc.strInput; // setting the new input to varable exit in case of user want to leave
           
           // Adding the item to bag
           mybag.add(new inBag (itemName, amountItems , itemPrice));
            

        }

        printBag(mybag, 0 ); // print Bag after users selected leave
        

    } // end chooseItems
       

     
public static void printFinalBag(ArrayList<inBag> finalBag) { // Printing the final Bag with Final price and end the program
        
        System.out.println("\n    HERE IS YOUR SHOPPING :\n");
        System.out.println("ITEMS ------- AMOUNT --- PRICE");
        
        double finalPrice = 0;// initializing finalPrice to 0 
        double deliveryfee = 5.0; // initializing price to delivery fee
        
        // Printing the final bag 
           for (int i = 0; i < finalBag.size(); i++ ){
                System.out.println(finalBag.get(i));
                System.out.println("===============================");
                finalPrice = finalPrice + finalBag.get(i).getPrice() * finalBag.get(i).getqtd();
            } 
           
           if (finalPrice < 35){ // checking if finalPrice to add the delivery fee
               
               finalPrice = finalPrice + deliveryfee; // adding Delivery fee to finalPrice
                System.out.println("       Delivery fee:   € 5.00");
                System.out.println("         Item total:   € " + finalPrice );
                System.out.println("\nTHANK YOU FOR SHOPPING WITH US =)\n");
            
           }else{ //finalPrice with free Delivery
                System.out.println("       Delivery fee:   free");
                System.out.println("           Total is:   € " + finalPrice );
                System.out.println("\nTHANK YOU FOR SHOPPING WITH US =)\n");
           }

}

}
