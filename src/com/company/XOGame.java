package com.company;

import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class XOGame implements ActionListener {
    JFrame jFrame = new JFrame();
    JPanel infoPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    Random random = new Random();
    JLabel text = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean firstPlayer;


    XOGame() {
        jFrame.setSize(800, 900);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.getContentPane().setBackground(new Color(70, 70, 70));
        jFrame.setLayout(new BorderLayout());
        jFrame.setVisible(true);

        text.setBackground(new Color(30, 30, 30));
        text.setForeground(new Color(30, 200, 100));
        text.setFont(new Font("Ink Free", Font.BOLD, 50));
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setText("X - O GAME");
        text.setOpaque(true);

        infoPanel.setLayout(new BorderLayout());
        infoPanel.setBounds(0, 0, 800, 200);
        infoPanel.add(text);
        jFrame.add(infoPanel, BorderLayout.NORTH);

        buttonPanel.setLayout(new GridLayout(3, 3));
        buttonPanel.setBackground(new Color(213, 34, 213));

        for (int i = 0; i < 9; ++i) {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MVBoli", Font.BOLD, 100));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        jFrame.add(buttonPanel);
        firstMove();
        //jFrame.add(infoPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; ++i) {
            if (e.getSource() == buttons[i]) {
                if (firstPlayer) {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(222, 119, 0, 255));
                        buttons[i].setText("X");
                        firstPlayer = false;
                        text.setText("O turn");
                        check();
                    }
                } else {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(8, 43, 255, 255));
                        buttons[i].setText("O");
                        firstPlayer = true;
                        text.setText("X turn");
                        check();
                    }
                }
            }
        }
    }

    public void check() {
        //X wins:
        //horizontal lines:
        if ((buttons[0].getText().equals("X")) && (buttons[1].getText().equals("X")) && (buttons[2].getText().equals("X"))) {
            xWins(0, 1, 2);
        }
        if ((buttons[3].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[5].getText().equals("X"))) {
            xWins(3, 4, 5);
        }
        if ((buttons[6].getText().equals("X")) && (buttons[7].getText().equals("X")) && (buttons[8].getText().equals("X"))) {
            xWins(6, 7, 8);
        }
        //vertical lines:
        if ((buttons[0].getText().equals("X")) && (buttons[3].getText().equals("X")) && (buttons[6].getText().equals("X"))) {
            xWins(0, 3, 6);
        }
        if ((buttons[1].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[7].getText().equals("X"))) {
            xWins(1, 4, 7);
        }
        if ((buttons[2].getText().equals("X")) && (buttons[5].getText().equals("X")) && (buttons[8].getText().equals("X"))) {
            xWins(2, 5, 8);
        }
        //diagonals:
        if ((buttons[0].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[8].getText().equals("X"))) {
            xWins(0, 4, 8);
        }
        if ((buttons[2].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[6].getText().equals("X"))) {
            xWins(2, 4, 6);
        }
        //O wins:
        //horizontal lines:
        if ((buttons[0].getText().equals("O")) && (buttons[1].getText().equals("O")) && (buttons[2].getText().equals("O"))) {
            oWins(0, 1, 2);
        }
        if ((buttons[3].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[5].getText().equals("O"))) {
            oWins(3, 4, 5);
        }
        if ((buttons[6].getText().equals("O")) && (buttons[7].getText().equals("O")) && (buttons[8].getText().equals("O"))) {
            oWins(6, 7, 8);
        }
        //vertical lines:
        if ((buttons[0].getText().equals("O")) && (buttons[3].getText().equals("O")) && (buttons[6].getText().equals("O"))) {
            oWins(0, 3, 6);
        }
        if ((buttons[1].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[7].getText().equals("O"))) {
            oWins(1, 4, 7);
        }
        if ((buttons[2].getText().equals("O")) && (buttons[5].getText().equals("O")) && (buttons[8].getText().equals("O"))) {
            oWins(2, 5, 8);
        }
        //diagonals:
        if ((buttons[0].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[8].getText().equals("O"))) {
            oWins(0, 4, 8);
        }
        if ((buttons[2].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[6].getText().equals("O"))) {
            oWins(2, 4, 6);
        }
    }

    public void xWins(int firstIndex, int secondIndex, int thirdIndex) {
        buttons[firstIndex].setBackground(Color.CYAN);
        buttons[secondIndex].setBackground(Color.CYAN);
        buttons[thirdIndex].setBackground(Color.CYAN);
        for (int i = 0; i < 9; ++i) {
            buttons[i].setEnabled(false);
            text.setText("X's VICTORY");
        }
    }

    public void oWins(int firstIndex, int secondIndex, int thirdIndex) {
        buttons[firstIndex].setBackground(Color.CYAN);
        buttons[secondIndex].setBackground(Color.CYAN);
        buttons[thirdIndex].setBackground(Color.CYAN);
        for (int i = 0; i < 9; ++i) {
            buttons[i].setEnabled(false);
            text.setText("O's VICTORY");
        }
    }

    public void firstMove(){
        try{
            Thread.sleep(2000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        if (random.nextInt(2) == 0){
            firstPlayer = true;
            text.setText("First move is by X");
        }else{
            firstPlayer = false;
            text.setText("First move is by O");
        }
    }

}
