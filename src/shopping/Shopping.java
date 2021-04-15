/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping;
import java.util.ArrayList;


public class Shopping  {

private static String strInput;
static String itemName;
static double itemPrice;
static int amountItems = 0;
static String error = "\n## ERROR! ## - It's not a valid number, please try again.";
static InputValidator sc = new InputValidator();
static int intInput;
static String exit;
static String deleteOption;


    public static void main(String[] args) {
          
    ShoppingBag myBag = new ShoppingBag(); //this is myBag. I can buy things to put in it

    ArrayList<menu> theMenu = new ArrayList<>(); // Create an ArrayList object menu
        
        // Below I added all the Items for the menu
        theMenu.add(new menu("Starters   ", "Nachos      ",3.2));
        theMenu.add(new menu("Starters   ", "Chicken bull",3.5));
        theMenu.add(new menu("Main Course", "BBQ         ",12.5));
        theMenu.add(new menu("Main Course", "Pasta       ",9));
        theMenu.add(new menu("Dessert    ", "IceCream    ",4.7));
        theMenu.add(new menu("Dessert    ", "Cake        ",3.8));
        theMenu.add(new menu("Drink      ", "Ceveza      ",5.5));
        theMenu.add(new menu("Drink      ", "SoftDrink   ",4));

        // printing the head of the menu 
        System.out.println("#############################################");
        System.out.println("###########  WELCOME TO EL GRITO  ###########");
        System.out.println("#############################################\n");
        System.out.println("ID:     Items           Category:       Price:\n");
        
      printMenu(theMenu); // call method to print the menu
      
      chooseItems(theMenu); // method to user choose items inside the menu
    
  
    } // end main 
    

    public static void printMenu (ArrayList<menu> printAll){ // printMenu
           
         for (int i = 0; i < printAll.size(); i++ ){    
            System.out.println("[ " + i + " ]" + printAll.get(i));
            System.out.println("==============================================");
        }
       
    } // end printMenu
    
    public static void chooseItems (ArrayList<menu> item) { //chooseItems
        
 
        System.out.println("\nHello there =), folow the Steps below to by on El Grito:");
        System.out.println("\n#1 - ADD ITEM TO SHOPPING BAG: cloose any Items by ID");
        System.out.println("#2 - SELECT THE AMOUNT THAT YOU WANT");
        System.out.println("#3 - TO LEAVE THE SHOP AND PAY TYPE: exit");
        System.out.println("\nPS: FREE DELIVERY FOR SHOPPING OVER €35");
        
        intInput = sc.readInteger(error); // First input from the user 
        
        ArrayList<inBag> mybag = new ArrayList<>(); // Item in the bag ArrayList
        
        
        exit = sc.strInput; // leave the program in case of the user enter exit as first input
     
        //exit = exit.toLowerCase();
        //while (intInput != (00011122233300)) { // need fix it
     
        
        while (!exit.contains("exit")) { // need fix it

            // checking if the number is greater than 0 and Less than ArrayList size
            while (intInput >= item.size() || intInput < 0 && !exit.contains("exit")){
                System.out.println("\n## ERROR! ## - Please choose a number betwen 0 to " + (item.size() -1) );
                
                intInput = sc.readInteger( error);
                
             }

            int userItem =  intInput; // getting the input from user and storege in userItem to add to bag
            
            System.out.println("How many " + item.get(userItem).getName().trim() + " do you want to add to Shopping Bag?"); 
            intInput = sc.readInteger(error); // getting the amount for the choosen Item
            
            // creating and passing values to varible to store in new ArrayList (shooping-bag)
            amountItems =  intInput;
            itemName = item.get(userItem).getName();
            itemPrice = item.get(userItem).getPrice();
            
           System.out.println( "\nYou added " +amountItems + " " +  item.get(userItem).getName().trim() + " to your shopping Bag." );
           System.out.println("Keep shopping or type \"exit\" to leave the menu.");
           intInput = sc.readInteger(error);
           exit = sc.strInput; // setting exit in case of user want to leave
           
           // Adding the item to bag
           mybag.add(new inBag (itemName, amountItems , itemPrice));

        }

        printBag(mybag); // print Bag after user had type exit
        

    } // end chooseItems
    
    public static void printBag (ArrayList<inBag> myBag) { //printBag
           
        int bagSize = myBag.size();
        double finalPrice = 0;
        if (bagSize != 0){
            
           System.out.println("\n     HERE IS YOUR SHOPPING BAG:");
           System.out.println(" ID ---------------- AMOUNT ---- PRICE");
           
           for (int i = 0; i < myBag.size(); i++ ){
                System.out.println("[ " + i + " ]" + myBag.get(i));
                System.out.println("======================================");
                finalPrice = finalPrice + myBag.get(i).getPrice() * myBag.get(i).getqtd();
            } 
           
           System.out.println("                      Total is: € " + finalPrice );
           System.out.println("\nPress 0 to remove Items or any number to finish your shopping:");
           int removeItem;
           
           removeItem = sc.readInteger(error);

           if (removeItem == 0){
               removeItem(myBag);
           }else{
               printFinalBag(myBag);
           }
           
        }else 
        {
            System.out.println("\n###### You left the shop. ######");
            System.out.println("### We appreciate your visit ###\n");
        }
          
       
    } // printBag
    
    public static void removeItem (ArrayList<inBag> itemRemove){
  
     int idRemoveItem;
        
     System.out.println("To remove Items from your Shopping Bag follow the options below:");
     System.out.println("#1 - DELETE SINGLE ITEM: cloose by ID");
     System.out.println("#2 - DELETE ALL ITEM: type all");
     System.out.println("#3 - FINISH YOUR SHOPPING: type pay");
     
     intInput = sc.readInteger(error);
     deleteOption = sc.strInput;
     
     if (deleteOption.contains("all")){
         
         itemRemove.clear();
         System.out.println("\n## You choose delete aLl, Now your bag is empty");
     } 
     else if (deleteOption.contains("pay")){
         printFinalBag(itemRemove);
 
     } else{
       
             while (!deleteOption.contains("pay") )  {
                 
            // checking if the number is greater than 0 and Less than ArrayList
             while (intInput >= itemRemove.size() || intInput < 0){
                System.out.println("\n## ERROR! ## - The ID " + intInput + "choose a number between 0 to " + (itemRemove.size() -1) );
                intInput = sc.readInteger( error);
             }

            int idRemove =  intInput;

            
            if (idRemove == 0 ){
            System.out.println("You have removed " + itemRemove.get(idRemove));
            itemRemove.remove(idRemove);
            System.out.println("\n## Now your bag is empty");
            deleteOption = "pay";
            }
            else {
            itemRemove.remove(idRemove);
            printBag(itemRemove);
            //System.out.println("To still removing choose another item by Id or press pay to finish your shop");
            //intInput = sc.readInteger( error1);
            }
        } // end
         
       }      
             
        if (intInput > 0) {
        printFinalBag(itemRemove); 
        }     
            
     
    }
    
    public static void printFinalBag(ArrayList<inBag> finalBag) {
        
        System.out.println("\n\nHere is your Final Shopping:");
        System.out.println("  ID -------- AMOUNT --- PRICE");
        double finalPrice = 0;
        double tax = 5.0;
           for (int i = 0; i < finalBag.size(); i++ ){
                System.out.println("[ " + i + " ]" + finalBag.get(i));
                System.out.println("======================================");
                finalPrice = finalPrice + finalBag.get(i).getPrice() * finalBag.get(i).getqtd();
            } 
           if (finalPrice < 35){
              finalPrice = finalPrice + tax; 
           System.out.println("                   Item total:   € " + finalPrice );
           System.out.println("                 Delivery tax:   € 5.00");
            
           }
           System.out.println("                 Delivery tax:   free");
           System.out.println("                     Total is:   € " + finalPrice );
           System.out.println("\nTHANK YOU FOR SHOPPING WITH US =)\n");
        

}

         
}