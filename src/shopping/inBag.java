/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping;

/**
 *
 * @author edgardpacheco
 */
public class inBag  {
    
     
       private String Name;
       private int qtd;
       private double Price;
       
       
       
       public inBag ( String name, int qtd, double price){
           
   
           this.Name = name;
           this.qtd = qtd;
           this.Price = price;
       
       }
       
       // get Name
       public String getName(){
           return this.Name;
       }
       
       public String getName(String newName){
           return (this.Name = newName);
       }
       
       // get Course
        public int getqtd(){
           return this.qtd;
       }
       
       public int getqtd(int newqtd){
           return (this.qtd = newqtd);
       }
       
       // get Price
       
       
         public double getPrice(){
           return this.Price;
       }      
       
       
       public double setPrice(double newPrice){      
        return (this.Price = newPrice);
       
       }

       //Override
       @Override
       public String toString(){
       return String.format("%s\t%s\t€ %.2f", this.Name, this.qtd, this.Price);
           //return String.format("%s\t%f", this.Name, this.Price);
       }
    
    
}
