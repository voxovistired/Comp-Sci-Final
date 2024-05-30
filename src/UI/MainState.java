/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import UI.States.PlayState;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 *
 * @author 797887
 */
public class MainState {
    
    private final Toolkit currentToolkit;
    public final JFrame mainUI;
    public PlayState playState;
    
    public MainState(String title, int initX, int initY) {
        currentToolkit = Toolkit.getDefaultToolkit();
        ImageIcon bgImage = new ImageIcon("assets/images/board.png");
        Image _bgImage = bgImage.getImage();
        _bgImage = _bgImage.getScaledInstance(currentToolkit.getScreenSize().width, currentToolkit.getScreenSize().height, Image.SCALE_SMOOTH);
        bgImage = new ImageIcon(_bgImage);
        
        this.mainUI = new JFrame(title);
        this.mainUI.setVisible(true);
        this.mainUI.setSize(currentToolkit.getScreenSize().width, currentToolkit.getScreenSize().height);
        this.mainUI.setResizable(false);
        this.mainUI.setBackground(Color.BLACK);
        this.mainUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.mainUI.setIconImage(currentToolkit.getImage("assets/images/icon.png"));
        this.mainUI.setLayout(null);
        this.mainUI.setContentPane(new JLabel(bgImage));
        
        playState = new PlayState(this.mainUI);
    }
}
