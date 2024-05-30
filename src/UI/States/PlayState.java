/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI.States;

import Cards.Card;
import Turns.ComputerTurns;
import java.awt.Color;
import Turns.PlayerTurn;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author 797887
 */
public class PlayState implements ActionListener  {

    PlayerTurn Play = new PlayerTurn();
    ComputerTurns compt1 = new ComputerTurns();
    ComputerTurns compt2 = new ComputerTurns();
    ComputerTurns compt3 = new ComputerTurns();
    Font pokerFont;
    
    private TextField t1;
    private boolean hasturnc1=true;
    private boolean hasturnc2=true;
    private boolean hasturnc3=true;
    private boolean hasturn =true;
    private static int totalbid = 0; 
    private boolean checker;
    
    private JLabel PlayerMoney;
    private JLabel Comp1;
    private JLabel Comp2;
    private JLabel Comp3;
    private JLabel Pot;
    
    private JLabel decisionLabel;
    
    private JButton R;
    private JButton S;
    private JButton F;
    private JButton ok;
    private ImageIcon backofc;
    private JButton End;
    static int index = 0; 
    
    ArrayList<Card> deck;
    ArrayList<Card> player;
    ArrayList<Card> dealer; 
    ArrayList<Card> c1; 
    ArrayList<Card> c2; 
    ArrayList<Card> c3;
    
    
    
     
    int[][] dealerBounds = {
        // Dealers.
        { 690, 350, 100, 145 },
        { 800, 350, 100, 145 },
        { 910, 350, 100, 145 },
        { 1020, 350, 100, 145 },
        { 1130, 350, 100, 145 },
        // Players.
        { 850, 630, 100, 145 },
        { 960, 630, 100, 145 },
        // Computer.
        { 100, 350, 100, 145 },
        { 100, 500, 100, 145 },
        { 850, 50, 100, 145 },
        { 960, 50, 100, 145 },
        { 1700, 350, 100, 145 },
        { 1700, 500, 100, 145 },
    };
    
    // Indexes 0-4 Dealers
    // Indexes 5-6 Players
    // Indexes 7-12 Computer
    JButton[] dealers = new JButton[dealerBounds.length];
   
    public PlayState(JFrame mainUI) {
        checker =false; 
        backofc = new ImageIcon("assets/images/cards/back_card.png");
        deck = new ArrayList<>();
        player = new ArrayList<>();
        dealer = new ArrayList<>();
        c1 = new ArrayList<>();
        c2 = new ArrayList<>();
        c3 = new ArrayList<>();
        try {
            pokerFont = Font.createFont(Font.TRUETYPE_FONT, new File("assets/fonts/Poker.ttf")).deriveFont(Font.BOLD, 25);
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(pokerFont);   
        } catch (IOException | FontFormatException e) {
            System.out.println(e);
        }
        Card TwoC = new Card(true, "assets/images/cards/2_of_clubs.png", 2, "Two of Clubs");
        deck.add(TwoC);
        Card TwoS = new Card(true, "assets/images/cards/2_of_spades.png", 2, "Two of Spades");
        deck.add(TwoS);
        Card TwoH = new Card(true, "assets/images/cards/2_of_hearts.png", 2, "Two of Hearts");
        deck.add(TwoH);
        Card TwoD = new Card(true, "assets/images/cards/2_of_diamonds.png", 2, "Two of Diamonds");
        deck.add(TwoD);
        Card ThreeC = new Card(true, "assets/images/cards/3_of_clubs.png", 3, "Three of Clubs");
        deck.add(ThreeC);
         Card ThreeS = new Card(true, "assets/images/cards/3_of_spades.png", 3, "Three of Spades");
        deck.add(ThreeS);
         Card ThreeH = new Card(true, "assets/images/cards/3_of_hearts.png", 3, "Three of Hearts");
        deck.add(ThreeH);
         Card ThreeD = new Card(true, "assets/images/cards/3_of_diamonds.png", 3, "Three of Diamonds");
        deck.add(ThreeD);
         Card FourC = new Card(true, "assets/images/cards/4_of_clubs.png", 4, "Four of Clubs");
        deck.add(FourC);
        Card FourS = new Card(true, "assets/images/cards/4_of_spades.png", 4, "Four of Spades");
        deck.add(FourS);
        Card FourH = new Card(true, "assets/images/cards/4_of_hearts.png", 4, "Four of Hearts");
        deck.add(FourH);
        Card FourD = new Card(true, "assets/images/cards/4_of_diamonds.png", 4, "Four of Diamonds");
        deck.add(FourD);
        Card FiveC = new Card(true, "assets/images/cards/5_of_clubs.png", 5, "Five of Clubs");
        deck.add(FiveC);
        Card FiveS = new Card(true, "assets/images/cards/5_of_spades.png", 5, "Five of Spades");
        deck.add(FiveS);
        Card FiveH = new Card(true, "assets/images/cards/5_of_hearts.png", 5, "Five of Hearts");
        deck.add(FiveH);
        Card FiveD = new Card(true, "assets/images/cards/5_of_diamonds.png", 5, "Five of Diamonds");
        deck.add(FiveD);
        Card SixC = new Card(true, "assets/images/cards/6_of_clubs.png", 6, "Six of Clubs");
        deck.add(SixC);
        Card SixS = new Card(true, "assets/images/cards/6_of_spades.png", 6, "Six of Spades");
        deck.add(SixS);
        Card SixH = new Card(true, "assets/images/cards/6_of_hearts.png", 6, "Six of Hearts");
        deck.add(SixH);
        Card SixD = new Card(true, "assets/images/cards/6_of_diamonds.png", 6, "Six of Diamonds");
        deck.add(SixD);
        Card SevenC = new Card(true, "assets/images/cards/7_of_clubs.png", 7, "Seven of Clubs");
        deck.add(SevenC);
        Card SevenS = new Card(true, "assets/images/cards/7_of_spades.png", 7, "Seven of Spades");
        deck.add(SevenS);
        Card SevenH = new Card(true, "assets/images/cards/7_of_hearts.png", 7, "Seven of Hearts");
        deck.add(SevenH);
        Card SevenD = new Card(true, "assets/images/cards/7_of_diamonds.png", 7, "Seven of Diamonds");
        deck.add(SevenD);
        Card EightC = new Card(true, "assets/images/cards/8_of_clubs.png", 8, "Eight of Clubs");
        deck.add(EightC);
        Card EightS = new Card(true, "assets/images/cards/8_of_spades.png", 8, "Eight of Spades");
        deck.add(EightS);
        Card EightH = new Card(true, "assets/images/cards/8_of_hearts.png", 8, "Eight of Hearts");
        deck.add(EightH);
        Card EightD = new Card(true, "assets/images/cards/8_of_diamonds.png", 8, "Eight of Diamonds");
        deck.add(EightD);
        Card NineC = new Card(true, "assets/images/cards/9_of_clubs.png", 9, "Nine of Clubs");
        deck.add(NineC);
        Card NineS = new Card(true, "assets/images/cards/9_of_spades.png", 9, "Nine of Spades");
        deck.add(NineS);
        Card NineH = new Card(true, "assets/images/cards/9_of_hearts.png", 9, "Nine of Hearts");
        deck.add(NineH);
        Card NineD = new Card(true, "assets/images/cards/9_of_diamonds.png", 9, "Nine of Diamonds");
        deck.add(NineD);
        Card TenC = new Card(true, "assets/images/cards/10_of_clubs.png", 10, "Ten of Clubs");
        deck.add(TenC);
        Card TenS = new Card(true, "assets/images/cards/10_of_spades.png", 10, "Ten of Spades");
        deck.add(TenS);
        Card TenH = new Card(true, "assets/images/cards/10_of_hearts.png", 10, "Ten of Hearts");
        deck.add(TenH);
        Card TenD = new Card(true, "assets/images/cards/10_of_diamonds.png", 10, "Ten of Diamonds");
        deck.add(TenD);
        Card JackC = new Card(true, "assets/images/cards/jack_of_clubs.png", 11, "Jack of Clubs");
        deck.add(JackC);
        Card JackS = new Card(true, "assets/images/cards/jack_of_spades.png", 11, "Jack of Spades");
        deck.add(JackS);
        Card JackH = new Card(true, "assets/images/cards/jack_of_hearts.png", 11, "Jack of Hearts");
        deck.add(JackH);
        Card JackD = new Card(true, "assets/images/cards/jack_of_diamonds.png", 11, "Jack of Diamonds");
        deck.add(JackD);
        Card QueenC = new Card(true, "assets/images/cards/queen_of_clubs.png", 12, "Queen of Clubs");
        deck.add(QueenC);
        Card QueenS = new Card(true, "assets/images/cards/queen_of_spades.png", 12, "Queen of Spades");
        deck.add(QueenS);
        Card QueenH = new Card(true, "assets/images/cards/queen_of_hearts.png", 12, "Queen of Hearts");
        deck.add(QueenH);
        Card QueenD = new Card(true, "assets/images/cards/queen_of_diamonds.png", 12, "Queen of Diamonds");
        deck.add(QueenD);
        Card KingC = new Card(true, "assets/images/cards/king_of_clubs.png", 13, "King of Clubs");
        deck.add(KingC);
        Card KingS = new Card(true, "assets/images/cards/king_of_spades.png", 13, "King of Spades");
        deck.add(KingS);
        Card KingH = new Card(true, "assets/images/cards/king_of_hearts.png", 13, "King of Hearts");
        deck.add(KingH);
        Card KingD = new Card(true, "assets/images/cards/king_of_diamonds.png", 13, "King of Diamonds");
        deck.add(KingD);
        Card AceC = new Card(true, "assets/images/cards/ace_of_clubs.png", 14, "Ace of Clubs");
        deck.add(AceC);
        Card AceS = new Card(true, "assets/images/cards/ace_of_spades2.png", 14, "Ace of Spades");
        deck.add(AceS);
        Card AceH = new Card(true, "assets/images/cards/ace_of_hearts.png", 14, "Ace of Hearts");
        deck.add(AceH);
        Card AceD = new Card(true, "assets/images/cards/ace_of_diamonds.png", 14, "Ace of Diamonds");
        deck.add(AceD);
        
        decisionLabel = new JLabel("", SwingConstants.CENTER);
        decisionLabel.setFont(new Font("Serif", Font.BOLD, 56));
        decisionLabel.setBounds(0, (mainUI.getHeight() + 56) / 2, mainUI.getWidth(), 56);
        decisionLabel.setVisible(false);
        mainUI.add(decisionLabel);
        
        PlayerMoney = new JLabel("Your Money: " + Play.returnmoney());
        PlayerMoney.setBounds(1100, 630, 110, 30);
        mainUI.add(PlayerMoney);
        PlayerMoney.setOpaque(false);
        PlayerMoney.setVisible(true);
        PlayerMoney.setForeground(Color.WHITE);
        
        Comp1 = new JLabel("CPU1 Money: " + compt1.getmoney());
        Comp1.setBounds(250, 500, 110, 30);
        mainUI.add(Comp1);
        Comp1.setOpaque(false);
        Comp1.setVisible(true);
        Comp1.setForeground(Color.WHITE);
        
        Comp2 = new JLabel("CPU2 Money: " + compt2.getmoney(), SwingConstants.CENTER);
        Comp2.setBounds(900, 200, 110, 30);
        mainUI.add(Comp2);
        Comp2.setOpaque(false);
        Comp2.setVisible(true);
        Comp2.setForeground(Color.WHITE);
        
        Comp3 = new JLabel("CPU3 Money: " + compt3.getmoney());
        Comp3.setBounds(1550, 500, 110, 30);
        mainUI.add(Comp3);
        Comp3.setOpaque(false);
        Comp3.setVisible(true);
        Comp3.setForeground(Color.WHITE);
        
        Pot = new JLabel("Pot Money: " + totalbid, SwingConstants.CENTER);
        Pot.setBounds(905, 500, 110, 30);
        mainUI.add(Pot);
        Pot.setOpaque(false);
        Pot.setVisible(true);
        Pot.setForeground(Color.WHITE);
        
        t1 = new TextField();
        t1.setBounds(750, 900, 400, 50);
        R = new JButton("Raise");
        ok = new JButton("OK");
        S = new JButton("Stand");
        F = new JButton("Fold");
      ok.setBounds(900,950,75,50);
        ok.setVisible(false);
        R.setBounds(700, 800, 100, 50);
        S.setBounds(900, 800, 100, 50);
        F.setBounds(1100, 800,100, 50);
        R.setBackground(Color.red);
        F.setBackground(Color.green );
        S.setBackground(Color.WHITE);

        R.setFont(pokerFont);
        ok.setFont(pokerFont);
        S.setFont(pokerFont);
        F.setFont(pokerFont);
                
        mainUI.add(R);
        mainUI.add(ok);
        mainUI.add(t1);
        mainUI.add(S);
        mainUI.add(F);
        R.addActionListener(this);
        ok.addActionListener(this);
        F.addActionListener(this);
        S.addActionListener(this);
        t1.setVisible(false);

        for (int i = 0; i < dealerBounds.length; i++) {
            dealers[i] = new JButton();
            mainUI.add(dealers[i]);
            dealers[i].setBounds(dealerBounds[i][0], dealerBounds[i][1], dealerBounds[i][2], dealerBounds[i][3]);
            dealers[i].setLayout(null);
            dealers[i].setBorderPainted(false);
            dealers[i].setFocusPainted(false);
            dealers[i].setContentAreaFilled(false);
        } 

       
    }
   
           
    @Override
    public void actionPerformed(ActionEvent e)
        {
          if(e.getSource()== R)
          {
           ok.setVisible(true);
           t1.setVisible(true);
          }
          
          else if (e.getSource()== F)
          {
           hasturn =false; 
           checker =true;
           R.setVisible(false);
           F.setVisible(false);
           S.setBounds(850, 800, 200, 50);
           S.setText("Continue");
         
          }
          
          else if (e.getSource()== S)
          {
            checker =true;
            //Play.Stand();
          }
          else if (e.getSource()==ok)
          {
              String s1= t1.getText();
              int a = Integer.parseInt(s1);
              if(hasturn)
              {
              if(a>0)
              {
              if(a >= Play.returnmoney())
              {
                  totalbid+=Play.returnmoney();
                  Play.Raise(Play.returnmoney());
                  Play.setmoney(0);
                  PlayerMoney.setText("Your Money: " + 0);
                  Pot.setText("Pot Money: " + totalbid);
              }
              else
              {
               Play.Raise(a);
              PlayerMoney.setText("Your Money: " + Play.returnmoney());
              totalbid += a;
              Pot.setText("Pot Money: " + totalbid);
              }
              }
              t1.setVisible(false);
              t1.setText("");
              ok.setVisible(false);
              checker =true; 
              
          }
          }
             
          
              }
    
    private Card getRandomCard() {
        int random = (int)(Math.random() * 51);  
        if(deck.get(random).returntorf())
        {
          deck.get(random).settorf(false);
          return deck.get(random);
        }
        return getRandomCard();
    }
    public void setup()
    {
        totalbid=0;
        checker= false;
        Pot.setText("Pot Money: " + 0);
        hasturn =true;
        hasturnc1 =true;
        hasturnc2 =true;
        hasturnc3 =true;
        R.setVisible(true);
        S.setBounds(900,800,100,50);
        S.setText("Stand");
        F.setVisible(true);
        decisionLabel.setVisible(false);
         if(compt1.getmoney()==0)
        {
            compt1.Csetmoney(100);
            Comp1.setText("CPU1 Money: " + 100);
        }
         if(compt2.getmoney()==0)
        {
            compt2.Csetmoney(100);
            Comp2.setText("CPU2 Money: " + 100);
        }
          if(compt3.getmoney()==0)
        {
            compt3.Csetmoney(100);
            Comp3.setText("CPU3 Money: " + 100);
        }
        
        Comp1.setText("CPU1 Money: " + compt1.getmoney());
        Comp2.setText("CPU2 Money: " + compt2.getmoney());
        Comp3.setText("CPU3 Money: " + compt3.getmoney());
        if(Play.returnmoney()==0)
        {
            Play.setmoney(100);
            PlayerMoney.setText("Player Money: " +100);
        }
       
        dealer.add(deck.get((int)(Math.random()*51)));
        deck.get(0).settorf(false);
        
        while(dealer.size()<5)
        {
            dealer.add(getRandomCard());
        } 
        
        while(player.size() < 2)
        {
            player.add(getRandomCard());
        }
        
        while(c1.size() < 2)
        {
            c1.add(getRandomCard());
        }
        
        while(c2.size() < 2)
        {
            c2.add(getRandomCard());
        }
        
        while(c3.size() < 2)
        {
            c3.add(getRandomCard());
        }
        
        dealers[0].setIcon(backofc);
        dealers[1].setIcon(backofc);
        dealers[2].setIcon(backofc);
        dealers[3].setIcon(backofc);
        dealers[4].setIcon(backofc);
        dealers[5].setIcon(player.get(0).returnimage());
        dealers[6].setIcon(player.get(1).returnimage());
        dealers[7].setIcon(backofc);
        dealers[8].setIcon(backofc);
        dealers[9].setIcon(backofc);
        dealers[10].setIcon(backofc);
        dealers[11].setIcon(backofc);
        dealers[12].setIcon(backofc);
    }

    
    /**
     * Ends the current game that is being ran.
     */
    public void endGame() {
        int highestCard = player.get(0).getScore();
        int highestIndex = 0;
        JLabel highestLabel = null;
        
        ComputerTurns highestTurn = null;
        PlayerTurn highestPlrTurn = null;
        
        // All given players
        String[] checkedPlrs = {
            "Player",
            "CPU1",
            "CPU2",
            "CPU3"
        };
        
        for (int s = 0; s < checkedPlrs.length; s++) {
            ArrayList<Card> currentPlr = player;
            // I have to do it like this because they are both different classes, end my sufferage.
            ComputerTurns currentTurn = null;
            PlayerTurn currentPlrTurn = null;
            JLabel currentLabel = null;
            
            switch(s) {
                case 0 -> { currentPlr = player; currentPlrTurn = Play; currentLabel = PlayerMoney; }
                case 1 -> { currentPlr = c1; currentTurn = compt1; currentLabel = currentLabel = Comp1; }
                case 2 -> { currentPlr = c2; currentTurn = compt2; currentLabel = Comp2; }
                case 3 -> { currentPlr = c3; currentTurn = compt3; currentLabel = Comp3; }
            }
            
            if (currentPlr == null && currentTurn == null) continue;
            for (Card card: currentPlr) {
                if (card.getScore() > highestCard) {
                    highestCard = card.getScore();
                    highestLabel = currentLabel;
                    highestIndex = s;
                    if (currentTurn != null)
                        highestTurn = currentTurn;
                    else
                        highestPlrTurn = currentPlrTurn;
                }
            }
        }
        
        if (highestTurn != null) {
            highestTurn.incMoney(totalbid);
            highestLabel.setText(checkedPlrs[highestIndex] + " Money: " + highestTurn.money);
        } else if (highestPlrTurn != null) {
            highestPlrTurn.incMoney(totalbid);
            highestLabel.setText("Your Money: " + highestPlrTurn.money);
        }
        
        totalbid = 0;
        
        decisionLabel.setVisible(true);
        decisionLabel.setText("Winner is: " + checkedPlrs[highestIndex] + "!");
        // Attempting to sleep can throw errors.
        try {
            player.clear();
            c1.clear();
            c2.clear();
            c3.clear();
            dealer.clear();
            for (Card card: deck)
                card.settorf(true);
            
            TimeUnit.SECONDS.sleep(3);
            setup();
        } catch(InterruptedException e) {}
    }
    
    public boolean hasplayerturnhappened()
    {
        return checker; 
    }
    public void computerturns()
    {
        checker =false; 
        int c1= (int)(Math.random()*100)+1;
        int c2= (int)(Math.random()*100)+1;
        int c3= (int)(Math.random()*100)+1;
        if(compt1.getmoney()>0)
        {
        if(hasturnc1)
        {
           
        
            if(c1<= 60)
        {
            int raised = (int)((Math.random()*compt1.getmoney()+1));
            compt1.CRaise(raised);
            totalbid+= raised;
            Pot.setText("Pot Money: " + totalbid);
            Comp1.setText("CPU1 Money: " +compt1.getmoney());
        }
        else if(c1>60&& c1<=85)
        {
                
        }     
                
         else
        {   
            hasturnc1=false;
            Comp1.setText("CPU1 Money: "+compt1.getmoney() + " has folded");
        }
        } 
        }
    if(compt2.getmoney()>0)
    {
    if(hasturnc2)
    {
       
        
        if(c2 <= 60)
        {
            int raised = (int)((Math.random()*compt2.getmoney()+1));
            compt2.CRaise(raised);
            totalbid+= raised;
            Pot.setText("Pot Money: " + totalbid);
            Comp2.setText("CPU2 Money: " +compt2.getmoney());
        }
            else if(c2>60&& c2<=85)
            {
            
            }
            else
            {
                hasturnc2=false;
                Comp2.setText("CPU2 Money: "+compt2.getmoney() + " has folded");
            } 
        }
    }
    if(compt3.getmoney()>0) 
    {
    if(hasturnc3)
    {
            if(c3 <= 60)
            {
                int raised = (int)((Math.random()*compt3.getmoney()+1));
                compt3.CRaise(raised);
                totalbid+= raised;
                Pot.setText("Pot Money: " + totalbid);
                Comp3.setText("CPU3 Money: " +compt3.getmoney());;
            }
            else if(c3>60&& c3<=85)
            {
            
            }
                
             else
            {
          
            hasturnc3=false;
             Comp3.setText("CPU3 Money: "+compt3.getmoney() +  " has folded");
            }
        }
    }
    }
    
    public void dealerturn()
    {
        if(index == 0)
        {
           dealers[0].setIcon(dealer.get(0).returnimage());
           dealers[1].setIcon(dealer.get(1).returnimage());
           dealers[2].setIcon(dealer.get(2).returnimage()); 
           ++index;
        }
        else if(index ==1)
        {
            dealers[3].setIcon(dealer.get(3).returnimage());
            ++index;
        }
        else
        {
           dealers[4].setIcon(dealer.get(4).returnimage()); 
           index =0;
        }
    }
}
