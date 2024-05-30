/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turns;

import java.util.ArrayList;

/**
 *
 * @author 796455
 */
public class PlayerTurn {
   public int money; 
   
   public PlayerTurn()
   {
      money = 100;
   }
   
// int is the money you are raising 
    public void Raise (int mon)
    {
            money -= mon; 
    }
   
   public void Stand()
   {
      
   }
   
    public void incMoney(int mon) {
        money += mon;
    }
 
   public int returnmoney()
   {
       return money; 
   }
   
   public void setmoney(int mony)
   {
       money = mony;
   }
   
  
   
 
}
