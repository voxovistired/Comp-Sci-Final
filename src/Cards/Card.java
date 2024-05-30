/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cards;

import javax.swing.ImageIcon;



public class Card {
   private boolean tf; 
   private ImageIcon card;
   private int score;
   private String Name;
   
   public Card (boolean torf, String image, int scoree, String name)
   {
       tf = torf;
       card = new ImageIcon(image);
       score = scoree; 
       Name = name; 
   }
   
   
   public ImageIcon returnimage()
   {
       return card; 
   }
   
   
   public boolean returntorf ()
   {
       return tf; 
   }
   
   public int getScore() {
       return score;
   }
   
   public void settorf (boolean t)
   {
       tf=t; 
   }
   
    
}