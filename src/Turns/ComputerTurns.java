/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Turns;

/**
 *
 * @author 796455
 */
public class ComputerTurns  {
    public int money;
   
    public ComputerTurns()
    {
       money = 100; 
    }
   
    public void CRaise(int mon)
    {
       money -= mon;
    }
 
    public void incMoney(int mon) {
        money += mon;
    }
    
    public int getmoney()
    {
        return money; 
    }
    
     public void Csetmoney(int mony)
   {
       money = mony;
   }
     
       
       
}
