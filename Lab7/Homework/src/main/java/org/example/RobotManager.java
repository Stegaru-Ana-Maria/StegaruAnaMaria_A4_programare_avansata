package org.example;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RobotManager extends JPanel{
    JTextField textField;
    JButton button;
    String input;
    final MainFrame frame;
    Exploration explore;

    public String getInput() {
        return input;
    }

    public RobotManager(MainFrame frame, Exploration explore) {
        this.frame = frame;
        this.explore = explore;
        init();
    }

    private void init(){
        textField = new JTextField(20);
        button = new JButton("Enter");
        add(textField);
        add(button);
        button.addActionListener(this::enterInput);
    }

    private void enterInput(ActionEvent e) {
        try {
            explore.checkCommand(textField.getText());
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
