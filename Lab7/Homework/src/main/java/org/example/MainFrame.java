package org.example;
import java.awt.BorderLayout;
import javax.swing.JFrame;

public class MainFrame extends JFrame{
    RobotManager robotManager;
    public MainFrame(Exploration explore) {
        super("Command Input");
        init(explore);
    }
    private void init(Exploration explore){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        robotManager = new RobotManager(this, explore);
        add(robotManager,BorderLayout.CENTER);
        pack();
    }
}
