package shopping;
import java.util.Scanner;

class InputValidator extends Shopping {

private final Scanner in;

InputValidator(){
    in = new Scanner(System.in);
    
}

public int readInteger( String errorMsg) {
    
 int num = 0;
 String strInput;
 boolean valid = false;
 
 while (valid == false){
     
 
     strInput = in.nextLine();  // /Getting the input from the user
 
     try{ // Keep looking until the user input a valid number or enter exit 
 
     num = Integer.parseInt(strInput); //  try to converte String to int
     valid = true; // if find a valid number change valid to true
     
     }
     catch (NumberFormatException e) {
         if ("exit".equals(strInput)){
          valid = true;
          num = 00011122233300;
         
         
         } else {
         System.out.println(errorMsg);
         }

     }
     

 }
    
 return num;


}


    
    
}
