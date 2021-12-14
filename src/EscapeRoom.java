import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EscapeRoom {

    JPanel panel;
    JLabel creepyNarrator;
    JRadioButton choiceOne, choiceTwo, choiceThree;
    JButton endButton;

    JButton action;


    public static void main(String[] args) {

        new EscapeRoom();

    }

    public EscapeRoom() {

        JFrame frame = new JFrame("Escape Room");
        frame.setSize(300, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();

        creepyNarrator = new JLabel("<html>You are in a dark room. You hear a creepy laugh. You see a dimly lit candle, a phone, and what seems to be a portal (but it could be a trap). What do you do?");
        choiceOne = new JRadioButton("Grab the candle.");
        choiceTwo = new JRadioButton("Grab the phone.");
        choiceThree = new JRadioButton("Approach the portal.");
        endButton = new JButton("Walk out");
        action = new JButton("GO!");

        ButtonGroup radios = new ButtonGroup();

        creepyNarrator.setBounds(20, 20, 250, 200);

        choiceOne.setBounds(20, 250, 150, 50);
        choiceTwo.setBounds(20, 300, 150, 50);
        choiceThree.setBounds(20, 350, 150, 50);


        action.setSize(100, 100);
        action.setBounds(200, 300, 80, 80);
        endButton.setSize(100, 100);
        endButton.setBounds(100, 150, 100, 100);

        radios.add(choiceOne);
        radios.add(choiceTwo);
        radios.add(choiceThree);



        action.addActionListener(new actionButtonListener());
        endButton.addActionListener(new endButtonListener());
        choiceOne.setSelected(true);

        panel.add(choiceOne);
        panel.add(choiceTwo);
        panel.add(choiceThree);
        panel.add(action);
        panel.add(creepyNarrator);

        frame.add(panel);

        panel.setLayout(null);
        frame.setVisible(true);

    }

    private class actionButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent actionEvent) {
            if (choiceOne.isSelected()) {
                choiceA();
            }
            if (choiceTwo.isSelected()) {
                choiceB();
            }
            if (choiceThree.isSelected()) {
                choiceC();
            }

        }
    }

    private class endButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent actionEvent) {
            creepyNarrator.setText("<html>The portal was in fact a way to get home but you wake up and find out it was a dream! or was it?");
            panel.remove(endButton);

            panel.updateUI();

        }
    }




    public void choiceA() {

        creepyNarrator.setText("<html>When you grab the candle, it melts completely. The clown that was in the same room killed you. YOU LOSE!!!");
        panel.remove(choiceOne);
        panel.remove(choiceTwo);
        panel.remove(choiceThree);
        panel.remove(action);

        panel.updateUI();

    }

    public void choiceB() {

        creepyNarrator.setText("<html>When you try to turn on the flashlight you realize it has no batteries. The clown in the same room puts you in an eternal slumber. YOU LOSE!!!");
        panel.remove(choiceOne);
        panel.remove(choiceTwo);
        panel.remove(choiceThree);
        panel.remove(action);

        panel.updateUI();

    }

    public void choiceC() {

        creepyNarrator.setText("<html>Congrats!!! You have escaped. The portal was unlocked You have escaped and won!");
        panel.remove(choiceOne);
        panel.remove(choiceTwo);
        panel.remove(choiceThree);
        panel.remove(action);
        panel.add(endButton);
        panel.updateUI();
    }
}