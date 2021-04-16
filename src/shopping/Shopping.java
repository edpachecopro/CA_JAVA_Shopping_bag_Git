/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping;
import java.util.ArrayList;


public class Shopping extends ShoppingBag {

    public static void main(String[] args) {

    ArrayList<menu> theMenu = new ArrayList<>(); // Create an ArrayList object theMenu
        
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
        
        
      printMenu(theMenu); // call method to print the menu
      
      chooseItems(theMenu); // method to user choose items inside the menu
    
  
    } // end main 
    

    public static void printMenu (ArrayList<menu> printMenu){ // printMenu
         System.out.println("''''''''''''''''' MENU  '''''''''''''''''''''\n");
         System.out.println("ID:     Items           Category:       Price:\n"); 
         for (int i = 0; i < printMenu.size(); i++ ){    
            System.out.println("[ " + i + " ]" + printMenu.get(i));
            System.out.println("==============================================");
        }
       
    } // end printMenu'
    
}