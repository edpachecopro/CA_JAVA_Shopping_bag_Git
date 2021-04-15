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
public class menu  {
    
    
  
       private String Name;
       private String Course;
       private double Price;
       private int Amount;
       
       
       // Class
       public menu ( String course, String name, double price){
           
   
           this.Name = name;
           this.Course = course;
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
        public String getCourse(){
           return this.Course;
       }
       
       public String getCourse(String newCourse){
           return (this.Course = newCourse);
       }
       
       // get Price
      
         public double getPrice(){
           return this.Price;
       }      
       
       
       public double setPrice ( double newPrice){      
        return (this.Price = newPrice);
       
       }

       

       //Override
       @Override
       public String toString(){
       return String.format("\t%s\t%s\t€ %.2f", this.Name, this.Course, this.Price);
           //return String.format("%s\t%f", this.Name, this.Price);
       }

    
}

