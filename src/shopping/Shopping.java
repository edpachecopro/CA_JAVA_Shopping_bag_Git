/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping;
import java.util.ArrayList;
import java.util.Scanner;

public class Shopping  {

private static String strInput;
static String itemName;
static double itemPrice;
static int amountItems = 0;
static String error1 = ":( Sorry It's not a valid number, please try again.";
static InputValidator sc = new InputValidator();
static int intInput;

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
        System.out.println("##########################################");
        System.out.println("#########  WELCOME TO EL GRITO  ##########");
        System.out.println("##########################################\n");
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
        System.out.println("\n1 - ADD ITEM TO BAD: cloose by ID");
        System.out.println("2 - SELECT THE AMOUNT YOU WANT");
        System.out.println("3 - TO LEAVE THE SHOP AND PAY PRESS: exit");
        System.out.println("\nPS: FREE DELIVERY FOR SHOPPING OVER €35");
        
        intInput = sc.readInteger(error1);
      
        
        ArrayList<inBag> mybag = new ArrayList<>(); // Item in the bag ArrayList
     
        while (intInput != (00011122233300)) { // need fix it

            // checking if the number is greater than 0 and Less than ArrayList
             while (intInput >= item.size() || intInput < 0){
                System.out.println("Please choose a number betwen o to " + (item.size() -1) );
                intInput = sc.readInteger( error1);
             }

            int userItem =  intInput;
            System.out.println("How many " + item.get(userItem).getName().trim() + " do you want?");
           
            intInput = sc.readInteger(error1);

            amountItems =  intInput;

            itemName = item.get(userItem).getName();
            itemPrice = item.get(userItem).getPrice();
            
           System.out.println( "\nYou added " +amountItems + " " +  item.get(userItem).getName().trim() + " to your bag." );
           System.out.println("Keep shopping or type exit to leave the menu.");
           intInput = sc.readInteger(error1);
           
           mybag.add(new inBag (itemName, amountItems , itemPrice));

        }

        printBag(mybag);
        

    } // end chooseItems
    
    public static void printBag (ArrayList<inBag> myBag) { //printBag
           
           double finalPrice = 0;
            System.out.println("\n\nHere is you Shopbag:");
             System.out.println("ID ===================AMOUNT ===PRICE");
           for (int i = 0; i < myBag.size(); i++ ){
  
           System.out.println("[ " + i + " ]" + myBag.get(i));
        
            System.out.println("======================================");
                
            
            finalPrice = finalPrice + myBag.get(i).getPrice() * myBag.get(i).getqtd();
            } 
           
           System.out.println("                       Total is: " + finalPrice );
           
           System.out.println("/nPress 0 to remove Items or any number to pay:");
           int removeItem;
           
           removeItem = sc.readInteger(error1);
 
           
           if (removeItem == 0){
               System.out.println("Thank you to Shop with us =)");
           }else{
               removeItem(myBag);
           }
          
       
    } // printBag
    
    public static void removeItem (ArrayList<inBag> myBag){

        
     int idRemoveItem;
        
     System.out.println("To remove Items from your Shopping Bag follow the Options below:");
     System.out.println("1 - DELETE SINGLE ITEM: cloose by ID");
     System.out.println("2 - DELETE ALL ITEM: type all");
     System.out.println("3 - FINISH YOUR SHOPPING: type pay");
     
     intInput = sc.readInteger(error1);
     
     
     
     
             while (intInput != (00011122233300)) { // need fix it

            // checking if the number is greater than 0 and Less than ArrayList
             while (intInput >= myBag.size() || intInput < 0){
                System.out.println("Sorry :[ the ID " + intInput + "Choose between 0 to " + (myBag.size() -1) );
                intInput = sc.readInteger( error1);
             }

            int idRemove =  intInput;

           myBag.remove(idRemove);


        } // end
     
     

    
    }

         
}