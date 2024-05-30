/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package finalproject;

import UI.MainState;

/**
 *
 * @author 797887
 */
public class FinalProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create Main State.
        boolean playerturncheck= false;
        MainState main = new MainState("Poker Project", 1280, 720);
        main.playState.setup();
        while (true) {
            playerturncheck = false;
                   while(playerturncheck == false)
        {
            playerturncheck= main.playState.hasplayerturnhappened();
            System.out.print("");
        }
         main.playState.computerturns();
        main.playState.dealerturn();   
        playerturncheck= false;
          while(playerturncheck == false)
        {
            playerturncheck= main.playState.hasplayerturnhappened();
            System.out.print("");
        }
         main.playState.computerturns();
        main.playState.dealerturn();
        playerturncheck= false;
           while(playerturncheck == false)
        {
            playerturncheck= main.playState.hasplayerturnhappened();
            System.out.print("");
        }
         main.playState.computerturns();
        main.playState.dealerturn();
        main.playState.endGame(); 
        }
    }
    }
    

