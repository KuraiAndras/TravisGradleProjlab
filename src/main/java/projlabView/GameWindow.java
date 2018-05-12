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
    private JLabel stepsLeft = new JLabel();
    private JLabel movableBoxesLeft = new JLabel();
    private KeyListener pIL = new PlayerInputListener();
    private ArrayList<JLabel> playerPoints = new ArrayList<>();


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

        for (Integer item : Game.getInstance().getPointList()) {
            playerPoints.add(new JLabel(item.toString()));
        }
        for(JLabel item : playerPoints){
            infoPanel.add(item);
        }

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

    private void updatePointList() {
        int i, j;
        for (i = 0, j = 0; i < playerPoints.size(); i++, j++){
            playerPoints.get(i).setText(Game.getInstance().getPointList().get(j).toString() + '\t');
        }
    }

    public void endView() {
        this.removeKeyListener(pIL);
        gamePanel.removeAll();
        updatePointList();

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

        updatePointList();
        stepsLeft.setText(Integer.toString(Game.getInstance().getStepsLeft()) + '\t');
        movableBoxesLeft.setText(Integer.toString(Game.getInstance().getMovableBoxes()));


        ArrayList<ArrayList<Field>> map = Game.getInstance().getMap();
        this.setMaximumSize(new Dimension(map.size() * 20, map.get(0).size() * 20 + 50));
        gamePanel.setLayout(new GridLayout(map.size(), map.get(0).size()));

        for (ArrayList<Field> row : map) {
            for (Field item : row) {
                switch (item.toString()) {
                    case "BoxOnField":
                        gamePanel.add(new JLabel(new ImageIcon(ImageManager.getBoxOnField())));
                        break;
                    case "BoxOnFieldWithOil":
                        gamePanel.add(new JLabel(new ImageIcon(ImageManager.getBoxOnFieldWithOil())));
                        break;
                    case "BoxOnFieldWithHoney":
                        gamePanel.add(new JLabel(new ImageIcon(ImageManager.getBoxOnFieldWithHoney())));
                        break;
                    case "BoxOnSwitch":
                        gamePanel.add(new JLabel(new ImageIcon(ImageManager.getBoxOnSwitch())));
                        break;
                    case "BoxOnSwitchWithOil":
                        gamePanel.add(new JLabel(new ImageIcon(ImageManager.getBoxOnSwitchWithOil())));
                        break;
                    case "BoxOnSwitchWithHoney":
                        gamePanel.add(new JLabel(new ImageIcon(ImageManager.getBoxOnSwitchWithHoney())));
                        break;
                    case "BoxOnTarget":
                        gamePanel.add(new JLabel(new ImageIcon(ImageManager.getBoxOnTarget())));
                        break;
                    case "BoxOnTargetWithOil":
                        gamePanel.add(new JLabel(new ImageIcon(ImageManager.getBoxOnTargetWithOil())));
                        break;
                    case "BoxOnTargetWithHoney":
                        gamePanel.add(new JLabel(new ImageIcon(ImageManager.getBoxOnTargetWithHoney())));
                        break;
                    case "WallOnField":
                        gamePanel.add(new JLabel(new ImageIcon(ImageManager.getWall())));
                        break;
                    case "Field":
                        gamePanel.add(new JLabel(new ImageIcon(ImageManager.getField())));
                        break;
                    case "FieldWithOil":
                        gamePanel.add(new JLabel(new ImageIcon(ImageManager.getFieldWithOil())));
                        break;
                    case "FieldWithHoney":
                        gamePanel.add(new JLabel(new ImageIcon(ImageManager.getFieldWithHoney())));
                        break;
                    case "PlayerOnField":
                        gamePanel.add(new JLabel(new ImageIcon(ImageManager.getPlayerOnField())));
                        break;
                    case "PlayerOnFieldWithOil":
                        gamePanel.add(new JLabel(new ImageIcon(ImageManager.getPlayerOnFieldWithOil())));
                        break;
                    case "PlayerOnFieldWithHoney":
                        gamePanel.add(new JLabel(new ImageIcon(ImageManager.getPlayerOnFieldWithHoney())));
                        break;
                    case "PlayerOnSwitch":
                        gamePanel.add(new JLabel(new ImageIcon(ImageManager.getPlayerOnSwitch())));
                        break;
                    case "PlayerOnSwitchWithOil":
                        gamePanel.add(new JLabel(new ImageIcon(ImageManager.getPlayerOnSwitchWithOil())));
                        break;
                    case "PlayerOnSwitchWithHoney":
                        gamePanel.add(new JLabel(new ImageIcon(ImageManager.getPlayerOnSwitchWithHoney())));
                        break;
                    case "PlayerOnTarget":
                        gamePanel.add(new JLabel(new ImageIcon(ImageManager.getPlayerOnTarget())));
                        break;
                    case "PlayerOnTargetWithOil":
                        gamePanel.add(new JLabel(new ImageIcon(ImageManager.getPlayerOnTargetWithOil())));
                        break;
                    case "PlayerOnTargetWithHoney":
                        gamePanel.add(new JLabel(new ImageIcon(ImageManager.getPlayerOnTargetWithHoney())));
                        break;
                    case "Target":
                        gamePanel.add(new JLabel(new ImageIcon(ImageManager.getTarget())));
                        break;
                    case "TargetWithOil":
                        gamePanel.add(new JLabel(new ImageIcon(ImageManager.getTargetWithOil())));
                        break;
                    case "TargetWithHoney":
                        gamePanel.add(new JLabel(new ImageIcon(ImageManager.getTargetWithHoney())));
                        break;
                    case "Switch":
                        gamePanel.add(new JLabel(new ImageIcon(ImageManager.getSwitchImage())));
                        break;
                    case "SwitchWithOil":
                        gamePanel.add(new JLabel(new ImageIcon(ImageManager.getSwitchImageWithOil())));
                        break;
                    case "SwitchWithHoney":
                        gamePanel.add(new JLabel(new ImageIcon(ImageManager.getSwitchImageWithHoney())));
                        break;
                    case "Hole":
                        gamePanel.add(new JLabel(new ImageIcon(ImageManager.getHole())));
                        break;

                }
            }
        }

        gamePanel.updateUI();

    }


}
