package projlabView;

import projabModel.Field;
import projabModel.Game;
import projlabController.EndMouseListener;
import projlabController.PlayerInputListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class GameWindow extends JFrame {

    private JPanel gamePanel = new JPanel();
    private JLabel player1Point = new JLabel();
    private JLabel player2Point = new JLabel();
    private JLabel stepsLeft = new JLabel();
    private JLabel movableBoxesLeft = new JLabel();
    private KeyListener pIL = new PlayerInputListener();

    public GameWindow() {
        this.setVisible(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    public void load() {
        JPanel infoPanel = new JPanel();
        JPanel endPanel = new JPanel();
        gamePanel = new JPanel();

        this.setResizable(false);
        this.add(gamePanel, BorderLayout.CENTER);
        this.add(infoPanel, BorderLayout.NORTH);
        this.add(endPanel, BorderLayout.SOUTH);

        infoPanel.setLayout(new GridLayout(1, 4));
        infoPanel.add(player1Point);
        infoPanel.add(player2Point);
        infoPanel.add(stepsLeft);
        infoPanel.add(movableBoxesLeft);

        //TODO: This should be a button
        endPanel.addMouseListener(new EndMouseListener());
        endPanel.add(new JLabel("End"));
        endPanel.setBackground(Color.CYAN);

        drawElements();
        this.pack();
        this.addKeyListener(pIL);
    }

    public void endView() {
        this.removeKeyListener(pIL);
        gamePanel.removeAll();

        player1Point.setText(Integer.toString(Game.getInstance().getPlayer1Point()) + '\t');
        player2Point.setText(Integer.toString(Game.getInstance().getPlayer2Point()) + '\t');
        stepsLeft.setText(Integer.toString(Game.getInstance().getStepsLeft()) + '\t');
        movableBoxesLeft.setText(Integer.toString(Game.getInstance().getMovableBoxes()));

        this.setPreferredSize(new Dimension(250, 200));

        this.pack();
        gamePanel.add(new JLabel("Game Over!", SwingConstants.CENTER));
        gamePanel.add(new JLabel(("Winner: Player " + Game.getInstance().getWinner()), SwingConstants.CENTER));

        gamePanel.updateUI();
    }

    //TODO: add more cases
    public void drawElements() {
        gamePanel.removeAll();

        player1Point.setText(Integer.toString(Game.getInstance().getPlayer1Point()) + '\t');
        player2Point.setText(Integer.toString(Game.getInstance().getPlayer2Point()) + '\t');
        stepsLeft.setText(Integer.toString(Game.getInstance().getStepsLeft()) + '\t');
        movableBoxesLeft.setText(Integer.toString(Game.getInstance().getMovableBoxes()));


        ArrayList<ArrayList<Field>> map = Game.getInstance().getMap();
        this.setMaximumSize(new Dimension(map.size() * 20, map.get(0).size() * 20 + 50));
        gamePanel.setLayout(new GridLayout(map.size(), map.get(0).size()));

        for (ArrayList<Field> row : map) {
            for (Field item : row) {
                switch (item.toString()) {
                    case "Box":
                        gamePanel.add(new JLabel(new ImageIcon(ImageManager.getBox())));
                        break;
                    case "Wall":
                        gamePanel.add(new JLabel(new ImageIcon(ImageManager.getWall())));
                        break;
                    case "Field":
                        gamePanel.add(new JLabel(new ImageIcon(ImageManager.getField())));
                        break;
                    case "Player":
                        gamePanel.add(new JLabel(new ImageIcon(ImageManager.getPlayerOnField())));
                        break;
                    case "Target":
                        gamePanel.add(new JLabel(new ImageIcon(ImageManager.getTarget())));
                        break;
                }
            }
        }

        gamePanel.updateUI();

    }


}
